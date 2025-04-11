import CommentButton from "@/components/CommentButton";
import NumNumRating from "@/components/numNumRating";
import ShareButton from "@/components/ShareButton";


import styles from "./DetailCard.module.css"
import Button from "@/components/Button";
import LikeButton from "@/components/LikeButton";
import { useState, useEffect } from "react";
import { fetchPriceById } from "@/lib/prices.API";

async function loadPrice(id) {
    return await fetchPriceById(id)
}

export default function DetailCard({ product }) {
    const [prices, setPrices] = useState(null);
    const [price, setPrice] = useState(null);
    const [count, setCount] = useState(1);

    useEffect(() => {
        const fetchPrice = async () => {
            const fetchPrices = await Promise.all(
                product.linkedPricesIds.map((priceId) => loadPrice(priceId))
            );
             setPrices(fetchPrices); 
            setPrice(fetchPrices[0].price);
        };

        fetchPrice();
    }, [product.linkedPricesIds]);

    function calcPrice(price, count) {
        let result = price * count;
        return result.toFixed(2);
    }

    function handleAddToCart() {
        const selectedPriceObj = prices.find(p => p.price == price);

        const newItem = {
            id: product.id,
            volume: selectedPriceObj?.volume || "",
            count: parseInt(count),
        };

        const cart = JSON.parse(localStorage.getItem("cart")) || [];

        const existingItem = cart.find((item) => item.id === newItem.id && item.volume === newItem.volume);

        if (existingItem) {
            existingItem.count += newItem.count;
        } else {
            cart.push(newItem);
        }

        localStorage.setItem("cart", JSON.stringify(cart));

    }


    function handleAddToCart() {
        const selectedPriceObj = prices.find(p => p.price == price);
    
        const newItem = {
            id: product.id,
            name: product.name,
            image: product.image,
            price: parseFloat(price),
            volume: selectedPriceObj?.volume || "",
            count: parseInt(count),
        };
    
        const cart = JSON.parse(localStorage.getItem("productCart")) || [];
    
        const existingItem = cart.find((item) => item.id === newItem.id && item.volume === newItem.volume);
    
        if (existingItem) {
            existingItem.count += newItem.count;
        } else {
            cart.push(newItem);
        }
    
        localStorage.setItem("productCart", JSON.stringify(cart));
        alert("Zum Warenkorb hinzugefügt!");
    }
    
    
    return (
        <>
            {prices ? (
                <>
                    <div className={styles.container}>
                        <img src={product.image} alt="Produkt image" />
                        <div className={styles.itemContainer}>
                            <div>
                                <h2>{product.name}</h2>
                            </div>
                            <div className={styles.priceVolume}>
                                <h3>{`${calcPrice(price, count)} CHF`}</h3>
                                <select
                                    className={styles.selectVolume}
                                    name="Volume"
                                    id="volume"
                                    onChange={(e) => {
                                        const selectedObj = JSON.parse(e.target.value);
                                        setPrice(selectedObj.price);
                                    }}
                                >
                                    {prices.map((priceObj) => (
                                        <option key={priceObj.volume} value={JSON.stringify(priceObj)}>
                                            {priceObj.volume}
                                        </option>
                                    ))}
                                </select>

                            </div>
                            <div className={styles.ratingMarke}>
                                <NumNumRating rating={product.nomNomRating} />
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
                                <Button className={styles.addToCart} onClick={handleAddToCart}>
                                    Add to cart
                                </Button>
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
                        <p>{product.description}</p>
                    </div>
                </>
         ) : (
            <div className={styles.container}>
    <div className={styles.imageLoading}></div>
    <div className={styles.itemContainer}>
        <div className={`${styles.priceVolume} ${styles.priceVolumeLoading}`}></div>

        <div className={styles.ratingMarke}>
            <div className={styles.ratingLoading}></div>
            <div className={styles.spacer}></div>
            <div className={styles.brandLoading}></div>
        </div>

        <div className={styles.comentShare}>
            <div className={styles.likeButtonLoading}></div>
            <div className={styles.commentButtonLoading}></div>
            <div className={styles.shareButtonLoading}></div>
        </div>

        <div className={`${styles.addToCart} ${styles.addToCartLoading}`}></div>
    </div>
</div>

        )}
    </>
);}
