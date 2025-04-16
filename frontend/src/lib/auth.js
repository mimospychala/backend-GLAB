const URL = "http://localhost:8080"

export async function signIn({ email, password }) {
    const response = await fetch(`${URL}/accounts/signin`, {
        method: "POST",
        headers: {
            "content-type": "application/json",
        },
        body: JSON.stringify({ email, password }),
    })

    if (!response.ok) {
        throw new Error(
            `Error while fetching, status: ${response.status}, message: ${response.message}`
        )
    }

    return await response.json()
}

export async function signUp({ email, username, password }) {
    const response = await fetch(`${URL}/accounts/signup`, {
        method: "POST",
        headers: {
            "content-type": "application/json",
        },
        body: JSON.stringify({ email, username, password }),
    })

    if (!response.ok) {
        throw new Error(
            `Error while fetching, status: ${response.status}, message: ${response.message}`
        )
    }

    return await response.json()
}
