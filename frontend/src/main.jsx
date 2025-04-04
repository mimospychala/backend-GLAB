import { StrictMode } from "react"
import { createRoot } from "react-dom/client"
import "./index.css"
import App from "./App.jsx"
import { createBrowserRouter, RouterProvider } from "react-router"
import IndexRoute from "@/routes/IndexRoute.jsx"
import ComponetRoute from "./routes/ComponetRoute"

const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
    children: [
      {
        index: true,
        element: <IndexRoute/>
      },
      {
        path: "componets",
        element: <ComponetRoute/>
      }
    ]
  }
])

createRoot(document.getElementById("root")).render(
    <StrictMode>
      <RouterProvider router={router}/>
    </StrictMode>
)


