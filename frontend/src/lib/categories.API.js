const URL = "http://localhost:8080"

import { getJWTToken } from "./session"


export async function fetchCategories() {
  const response = await fetch(`${URL}/categories`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function fetchCategorieById(id) {
  const response = await fetch(`${URL}/categories/${id}`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function createCategorie(categorie) {
  const response = await fetch(`${URL}/categories`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(categorie),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function updateCategorie(categorie) {
  const response = await fetch(`${URL}/categories/${categorie.id}`, {
    method: "PUT",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(categorie),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function deleteCategorie(id) {
  const response = await fetch(`${URL}/categories/${id}`, {
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

