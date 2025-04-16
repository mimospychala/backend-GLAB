import { Link, useNavigate, useActionData, redirect, redirectDocument } from "react-router"
import AuthForm from "@/components/AuthForm"

import { signIn } from "@/lib/auth"
import { saveSession } from "@/lib/session"
import { validateUser } from "@/lib/validateUser"



async function clientAction({ request }) {
    const formData = await request.formData()
    const user = Object.fromEntries(formData)

    const { errors, isValid } = validateUser(user)
    if (!isValid) {
        return errors
    }

    const response = await signIn(user)
    saveSession(response)

    const param = new URLSearchParams(location.search)
    const path = param.get("path")
    return redirect(path ?? "/")
}

export default function SignInRoute() {
    const errors = useActionData()
    const navigate = useNavigate()

    const goBack = () => {
        navigate("/")
    }

    return (
        <main>
            <h2>Anmelden</h2>
            <AuthForm onCancel={goBack} errors={errors} />
            <p>
                Hast du noch keinen Account? <Link to="/auth/signup">Hier</Link> kannst du dich
                registrieren.
            </p>
        </main>
    )
}

SignInRoute.action = clientAction
