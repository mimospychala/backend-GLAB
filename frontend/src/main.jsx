import { StrictMode } from "react"
import { createRoot } from "react-dom/client"
import "./index.css"
import App from "./App.jsx"
import { createBrowserRouter, RouterProvider } from "react-router"
import IndexRoute from "@/routes/IndexRoute.jsx"
import ComponetRoute from "./routes/ComponetRoute"
import ShoppingCartRoute from "./routes/ShoppingCartRoute"
import DetailCard from "./components/DetailCard"
import DetailRoute from "./routes/DetailsRoute"
import ListRoute from "./routes/ListRoute"

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        index: true,
        element: <IndexRoute />
      },
      {
        path: "componets",
        element: <ComponetRoute/>
      },
      {
        path: "shoppingcart",
        element: <ShoppingCartRoute/>
      },
      {
        path: "products/:id",
        element: <DetailRoute />,
        loader: DetailRoute.loader
      },
      {
        path: "products",
        element: <ListRoute />,
        loader: ListRoute.loader
      },

    ]
  }
])

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
)


