import { useNavigate, useActionData, redirect, Link } from "react-router"
import styles from "./SignUpRoute.module.css"
import { signUp } from "@/lib/auth"
import { saveSession } from "@/lib/session"
import { validateRegistration } from "@/lib/validateRegistration"
import RegistrationForm from "@/components/RegistrationForm"



async function clientAction({ request }) {
    const formData = await request.formData()
    const user = Object.fromEntries(formData)

    const { errors, isValid } = validateRegistration(user)
    if (!isValid) {
        return errors
    }

    const response = await signUp(user)
    saveSession(response)
    return redirect("/auth/signin")
}

export default function SignUpRoute() {
    const errors = useActionData()
    const navigate = useNavigate()

    const goBack = () => {
        navigate("/")
    }

    return (
          <main className={styles.center}>
            <h2>Registration</h2>
            <RegistrationForm onCancel={goBack} errors={errors} />
            <p>
                Hast du schon einen Account? <Link to="/auth/signin">Hier</Link> kannst du dich
                anmelden.
            </p>
        </main>
    )
}

SignUpRoute.action = clientAction
