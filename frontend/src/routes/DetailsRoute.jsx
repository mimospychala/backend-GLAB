import CommentButton from "@/components/CommentButton";
import NumNumRating from "@/components/numNumRating";
import ShareButton from "@/components/ShareButton";


import "./DetailsRoute.module.css"
import styles from "./DetailsRoute.module.css"
import Button from "@/components/Button";
import LikeButton from "@/components/LikeButton";
import { useState } from "react";

export default function DetailRoute({ product }) {
    const [price, setPrice] = useState(product.prices[0].price);
    const [count, setCount] = useState(1)
    
    function calcPrice(price, count){
        let result = price * count
        return result.toFixed(2)
    }

    return (
        <>
            <div className={styles.container}>
                <img src={product.img} alt="Produkt image" />
                <div className={styles.itemContainer}>
                    <div>
                        <h2>{product.name}</h2>
                    </div>
                    <div className={styles.priceVolume}>
                        <h3>{`${calcPrice(price, count)} CHF`}</h3>
                        <select className={styles.selectVolume} name="Volume" id="volume" onChange={(e) => setPrice(e.target.value)}>
                            {product.prices.map((price) =>
                                <option value={price.price}>{`${price.volume}`}</option>
                            )}
                        </select>
                    </div>
                    <div className={styles.ratingMarke}>
                        <NumNumRating rating={product.numNumRating} />
                        <div className={styles.spacer}></div>
                        <div>
                            <p>Marke:</p>
                            <h3>{product.marke}</h3>
                        </div>
                    </div>
                    <div className={styles.comentShare}>
                        <LikeButton />
                        <CommentButton />
                        <ShareButton />
                    </div>
                    <div className={styles.addToCartCount}>
                        <Button className={styles.addToCart}>Add to cart </Button>
                        <select
                            className={styles.selectCount}
                            name="count"
                            id="count"
                            onChange={(e) => setCount(e.target.value)}
                        >
                            {[...Array(5)].map((_, i) => (
                                <option key={i + 1} value={i + 1}>
                                    {i + 1}
                                </option>
                            ))}

                        </select>
                    </div>
                </div>
            </div>
            <div>
                <p>
                    {product.description}
                </p>
            </div>
        </>
    )
}