import Button from "./Button";
import "@/components/ProductDetailCard.module.css"
import styles from "@/components/ProductDetailCard.module.css"
import { useState } from "react";
import ShareButton from "./ShareButton";
import CommentButton from "./CommentButton";

export default function ProductDetailCard({ product }) {
    const [count, setCount] = useState(1)
    const increment = () => {
        setCount(count + 1)
    }

    const decrement = () => {
        if (count > 1) {
            setCount(count - 1)
        }
    }

    return (
        <div className={styles.border}>
            <div className={styles.product}>
                <div className={styles.title}>
                    <h2>{product.name}</h2>
                    <h3>{product.marke}</h3>
                </div>
                <div className={styles.middle}>
                    <img src={product.img} alt={product.altImag} />
                    <div className={styles.icons}>
                        <div></div>
                        <ShareButton />
                        <CommentButton/>
                        <div></div>
                    </div>

                </div>
                <div className={styles.volumes}>
                    {product.prices.map((volume) => <Button>{volume.volume}<br />{volume.price} CHF</Button>)}
                </div>
                <div className={styles.count}>
                    <Button onClick={decrement}>-</Button>
                    {count}
                    <Button onClick={increment}>+</Button>
                    <Button>Add to cart</Button>
                </div>
            </div>
        </div >
    )
}