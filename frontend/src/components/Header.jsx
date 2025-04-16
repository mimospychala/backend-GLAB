import { useNavigate } from "react-router"
import styles from "./Header.module.css"
import "./Header.module.css"
import { removeSession, useCurrentUser } from "@/lib/session"
import Button from "./Button"
import ButtonGroup from "./ButtonGroup"



export default function Header() {
    const navigate = useNavigate()
    const user = useCurrentUser()

    const logout = async (e) => {
        e.preventDefault()
        removeSession()
        navigate("/")
    }

    return (
        <header>


            <div className={styles.header}>
                <div className={styles.filler}>
                <ButtonGroup>
                    {user ? (
                        <>
                            <Button onClick={logout}>Abmelden</Button>
                        </>
                    ) : (
                        <Button to="/auth/signin">Anmelden</Button>
                    )}
                </ButtonGroup>
                </div>
                <img src="/logo.png" alt="Logo Nom Nom Bar" className={styles.logo} />
            </div>


        </header>

    )
}