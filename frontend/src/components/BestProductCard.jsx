import { Link } from "react-router"
import styles from "./BestProductCard.module.css"
import "./BestProductCard.module.css"

export default function BestProductCard({ product, label, img, id }) {
    const { name, marke, volumes, altImg } = product
  
    return (
      <>
        <div className={styles.productCard}> 
      <Link to={`products/${id}`} className={styles.link}>
        <article className={styles.productCard}>
          <h2>{label}</h2> {}
          <img src={img} alt={label} />
        </article>
      </Link>

      </div>
      </>
    )
  }
  