import IndexRoute from "@/routes/IndexRoute";
import styles from "./ShoppingCartCard.module.css";
import "./ShoppingCartCard.module.css";
import { useState, useEffect } from "react";
import Button from "./Button";

export default function ShoppingCartCard({ product }) {
  const { id, name, marke, volumes } = product;


  const getInitialCount = () => {
    const saved = localStorage.getItem(`count-${id}`);
    return saved ? parseInt(saved) : 1;
  };

  const [count, setCount] = useState(getInitialCount);

  useEffect(() => {
    localStorage.setItem(`count-${name}`, count);
  }, [count, id]);

  const increment = () => {
    setCount(prev => prev + 1);
  };

  const decrement = () => {
    setCount(prev => (prev > 1 ? prev - 1 : 1));
  };

  function calcPrice(price, count) {
    const result = price * count;
    const result2 = Math.round(result * 100) / 100;
    return result2.toFixed(2);
  }

  return (
    <article>
      <img src="/snacks.png" alt="Snacks" className={styles.drinksSnacks} />
      <div>
        <h3>{name}</h3>
        <p>{marke}</p>
      </div>
      <div>
        <Button className={styles.smallButton} onClick={decrement}>-</Button>
        {count}
        <Button className={styles.smallButton} onClick={increment}>+</Button>
        <p>{calcPrice(volumes[0].price, count)} CHF</p>
      </div>
    </article>
  );
}
