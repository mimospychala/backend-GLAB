import { fetchProductById } from "@/lib/products.API"
import { useEffect, useState } from "react"
import styles from "./ComboDetailCard.module.css"
import { Link } from "react-router"
import NumNumRating from "./NumNumRating"
import CommentButton from "./CommentButton"
import ShareButton from "./ShareButton"
import LikeButton from "./LikeButton"
import Button from "./Button"
import Comments from "./Comments"

export default function ComboDetailCard({ combo }) {

    const { id, description, name, price, linkedProductIds } = combo
    const [products, setProducts] = useState(null)
    async function loadProducts(id) {
        return await fetchProductById(id)
    }

    useEffect(() => {
        const fetchProducts = async () => {
            const fetchProducts = await Promise.all(linkedProductIds.map((id) => loadProducts(id)))
            setProducts(fetchProducts)
        }
        fetchProducts()
    }, [linkedProductIds])

    return (
        <>
            {products ?
                <>
                    <div className={styles.container}>
                        <div className={styles.images}>
                            {products.map((product) => <Link key={product.id} to={`/products/${product.id}`}><img src={product.image} alt="fkfld" /></Link>)}
                        </div>
                        <div className={styles.itemContainer}>
                            <div>
                                <h2>{name}</h2>
                            </div>
                            <p>{`${price.toFixed(2)} chf`}</p>
                            <div className={styles.ratingMarke}>
                                <NumNumRating rating={combo.nomNomRating} />
                                <div className={styles.spacer}></div>
                                <div>
                                    <p>Marken:</p>
                                    {products.map((product) => <h3 key={product.id}>{product.marke}</h3>)}
                                </div>
                            </div>
                            <div className={styles.comentShare}>
                                <LikeButton />
                                <CommentButton/>
                                <ShareButton />
                            </div>
                            <Button to="/combos">Back</Button>
                        </div>
                    </div>
                    <div>
                        <p>
                            {combo.description}
                        </p>
                    </div>
                </>
                :
                <div className={styles.loading}>loading...</div>

            }

        </>
    )
}