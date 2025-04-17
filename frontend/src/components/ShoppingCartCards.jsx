import ShoppingCartCard from "./ShoppingCartCard";
import styles from "./ShoppingCartCards.module.css"
import { fetchProductById } from "@/lib/products.API";

async function loadItem(id) {
    return await fetchProductById(id)
}

export default function MyCartComponent() {
    const cartItems = JSON.parse(localStorage.getItem("cart")) || [];

    return (
        <>
                <div className={styles.parent}>
                    {cartItems.map((item => <ShoppingCartCard values={item} />))}
                </div>
            
        </>
    )
}