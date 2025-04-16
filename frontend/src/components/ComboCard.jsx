import { fetchProductById } from "@/lib/products.API"
import { useEffect, useState } from "react"
import styles from "./ComboCard.module.css"
import { Link } from "react-router"

export default function ComboCard({ combo }) {
    const { id, account, name, price, linkedProductIds} = combo
    const [products, setProducts] = useState(null)
    console.log(linkedProductIds)

    async function loadProducts(id) {
        return await fetchProductById(id)
    }

    useEffect(() => {
        const fetchProducts = async () => {
            const fetchProducts = await Promise.all(linkedProductIds.map((id) => loadProducts(id)))
            setProducts(fetchProducts)
        }
        fetchProducts()
    },[linkedProductIds])

    return (
        <>
            {products ?
                <Link to={`/combos/${id}`} className={styles.link}>
                    <article className={styles.productCard}>
                        <h2>{name}</h2>
                        { products.map((product) => <img key={product.id} src={product.image} alt="fkfld"/>)}
                        <p>{`${price.toFixed(2)} chf`}</p>
                    </article>
                </Link>
                :
                <div className={styles.loadingCard}></div>
            }

        </>
    )
}