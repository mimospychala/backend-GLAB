const URL = "http://localhost:8080"

import { getJWTToken } from "./session"


export async function fetchProducts() {
  const response = await fetch(`${URL}/products`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function fetchProductById(id) {
  const response = await fetch(`${URL}/products/${id}`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function createProduct(product) {
  const response = await fetch(`${URL}/products`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(product),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function updaeProduct(product) {
  const response = await fetch(`${URL}/products/${product.id}`, {
    method: "PUT",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(product),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function deleteProduct(id) {
  const response = await fetch(`${URL}/products/${id}`, {
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

