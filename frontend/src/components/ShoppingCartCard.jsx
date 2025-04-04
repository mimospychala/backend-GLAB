import IndexRoute from "@/routes/IndexRoute";
import styles from "./ShoppingCartCard.module.css"
import "./ShoppingCartCard.module.css"


export default function ShoppingCartCard({product}){
  const {id, name, marke, volumes } = product

  return (
    <article >
      <img src="/snacks.png" alt="Snacks" className={styles.drinksSnacks} />
          <h3>{name}</h3>
          <p>{marke}</p>
          <p>{`${volumes[1].volume}`}</p>
          <p>{`${volumes[1].price} chf`}</p>
    </article>
  );
}
