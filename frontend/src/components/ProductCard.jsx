import { Link } from "react-router"
import styles from "./ProductCard.module.css"
import "./ProductCard.module.css"

export default function ProductCard({ product }) {
    const { id, name, marke, volumes, img, altImg } = product
    
    return (
        <Link to={`details/${id}`} className={styles.link}>
            <article className={styles.productCard}>
                <h2>{name}</h2>
                <img src={img ? img : altImg} alt={`${name}/${marke}`} />
                <p>{`${volumes[0].price} chf`}</p>
            </article>
        </Link>
    )
}