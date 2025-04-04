const URL = "http://localhost:8080"

import { getJWTToken } from "./session"


export async function fetchPrices() {
  const response = await fetch(`${URL}/prices`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function fetchPriceById(id) {
  const response = await fetch(`${URL}/prices/${id}`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function createPrice(price) {
  const response = await fetch(`${URL}/prices`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(price),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function updatePrice(price) {
  const response = await fetch(`${URL}/prices/${price.id}`, {
    method: "PUT",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(price),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function deletePrice(id) {
  const response = await fetch(`${URL}/prices/${id}`, {
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

