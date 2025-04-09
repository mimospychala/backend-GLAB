import IndexRoute from "@/routes/IndexRoute";
import styles from "./ShoppingCartCard.module.css"
import "./ShoppingCartCard.module.css"
import { useState } from "react";
import Button from "./Button";


export default function ShoppingCartCard({ product }) {
  const { id, name, marke, volumes } = product
  const [count, setCount] = useState(1)

  const increment = () => {
    setCount(count + 1)
  }

  const decrement = () => {
    if (count > 1) {
      setCount(count - 1)
    }
  }

  function calcPrice(price, count) {
    let result = price * count
    let result2 = Math.round(result * 100) / 100
    return result2.toFixed(2)
  }

  return (
    <article >
      <img src="/snacks.png" alt="Snacks" className={styles.drinksSnacks} />
      <div>
        <h3>{name}</h3>
        <p>{marke}</p>
      </div>
      <div>
        <Button className={styles.smallButton} onClick={decrement}>-</Button>
        {count}
        <Button className={styles.smallButton} onClick={increment}>+</Button>
        <p>{calcPrice(volumes[1].price, count)} CHF</p>
      </div>
    </article>
  );
}
