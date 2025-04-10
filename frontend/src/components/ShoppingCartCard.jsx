import IndexRoute from "@/routes/IndexRoute";
import styles from "./ShoppingCartCard.module.css";
import "./ShoppingCartCard.module.css";
import { useState, useEffect } from "react";
import Button from "./Button";
import { useShoppingCart } from "@/lib/shoppingcart";

export default function ShoppingCartCard({ product }) {
  const [products, addProduct, removeProduct] = useShoppingCart()

  const { id, name, marke, prices

    
   } = product;

  const [count, setCount] = useState(getInitialCount);

  useEffect(() => {
    localStorage.setItem(`count-${name}`, count);
  }, [count, id]);

  const increment = () => {
    addProduct(product)
    setCount(prev => prev + 1);
  };

  const decrement = () => {
    removeProduct(product)
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
        <p>{calcPrice(prices[0].price, count)} CHF</p>
      </div>
    </article>
  );
}
