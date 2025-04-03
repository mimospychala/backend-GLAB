import Header from "@/components/Header"
import LinkButton from "@/components/LinkButton"
import SideBar from "@/components/SideBar"
import styles from "./IndexRoute.module.css"

const product = [
  {
      "id": "1",
      "name": "Cola",
      "marke": "Coca-Cola",
      "prices": [
          {
              "volume": "0.5L",
              "price": "1.50"
          },
          {
              "volume": "1.0L",
              "price": "2.50"
          }
      ]
  },
  {
      "id": "2",
      "name": "Fanta",
      "marke": "Coca-Cola",
      "volumes": [
          {
              "volume": "0.5L",
              "price": "1.40"
          },
          {
              "volume": "1.0L",
              "price": "2.40"
          }
      ]
  },
  {
      "id": "3",
      "name": "Snickers",
      "marke": "Mars",
      "volumes": [
          {
              "volume": "50g",
              "price": "1.20"
          },
          {
              "volume": "100g",
              "price": "2.00"
          }
      ]
  },
  {
      "id": "4",
      "name": "Chips",
      "marke": "Pringles",
      "volumes": [
          {
              "volume": "150g",
              "price": "2.50"
          },
          {
              "volume": "200g",
              "price": "3.50"
          }
      ]
  }
]

export default function IndexRoute() {
  return (
    <>
      <SideBar/>
      <LinkButton to="/kasse">Kasse</LinkButton>

    </>
  )
}