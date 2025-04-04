const URL = "http://localhost:8080"

import { getJWTToken } from "./session"


export async function fetchComments() {
  const response = await fetch(`${URL}/comments`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function fetchCommentById(id) {
  const response = await fetch(`${URL}/comments/${id}`)

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function createComment(comment) {
  const response = await fetch(`${URL}/comments`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(comment),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function updateComment(comment) {
  const response = await fetch(`${URL}/comments/${comment.id}`, {
    method: "PUT",
    headers: {
      "content-type": "application/json",
      "authorization": `Bearer ${getJWTToken()}`
    },
    body: JSON.stringify(comment),
  })

  if (!response.ok) {
    throw new Error("An error occured while fetching")
  }

  const data = await response.json()
  return data
}

export async function deleteComment(id) {
  const response = await fetch(`${URL}/comments/${id}`, {
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

