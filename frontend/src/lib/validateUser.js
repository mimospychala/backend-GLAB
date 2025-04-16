export function validateUser(user) {
    const errors = {
        email: "",
        password: "",
    }

    let isValid = true

    if (user.email.trim().length === 0 || !user.email.includes("@")) {
        errors.email = "E-Mail darf nicht leer sein und muss eine gültige E-Mail Adresse sein"
        isValid = false
    }

    if (user.password.trim().length === 0 || user.password.length < 8) {
        errors.password = "Passwort darf nicht leer sein und muss mindestens 8 Zeichen lang sein"
        isValid = false
    }

    return { errors, isValid }
}
