const URL = "http://localhost:8080"

import { getJWTToken } from "./session"


export async function fetchCombos() {
  const response = await fetch(`${URL}/combos`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function fetchComboById(id) {
  const response = await fetch(`${URL}/combos/${id}`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function createCombo(combo) {
  const response = await fetch(`${URL}/combos`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(combo),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function updateCombo(combo) {
  const response = await fetch(`${URL}/combos/${combo.id}`, {
    method: "PUT",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(combo),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function deleteCombo(id) {
  const response = await fetch(`${URL}/combos/${id}`, {
    method: "DELETE",
    headers: {
      "authorization": `Bearer ${getJWTToken()}`
    },
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }
}

export async function signIn(user) {
  const response = await fetch(`${URL}/auth/signin`, {
    method: "POST",
    headers: {
      "content-type": "application/json"
    },
    body: JSON.stringify(user),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

