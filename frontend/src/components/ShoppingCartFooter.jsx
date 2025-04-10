import Button from "./Button";
import styles from "./ShoppingCartFooter.module.css";
import { useShoppingCart } from "@/lib/shoppingcart";
<<<<<<< HEAD
import { useShoppingCart } from "@/lib/shoppingcart";

export default function ShoppingcartFooter({ }) {
    const [products, setProducts] = useShoppingCart()

    let totalPrice = 0

    for (const product of products) {
        totalPrice += product.count * Number(product.volumes[0].price)
    }

    return (
        <footer className={styles.footer}>
            <div className={styles.bar}></div>
            <div className={styles.content}>
                <p >Total:</p>
                <div className={styles.footerMargin}>
                    <p>{`${totalPrice.toFixed(2)}`} CHF</p>
                    <Button> Zur Kasse </Button>
                </div>
=======

export default function ShoppingcartFooter({ }) {
    const [products, setProducts] = useShoppingCart()
    
    let totalPrice = 0

    for(const product of products) {
        totalPrice += product.count * Number(product.volumes[0].price)
    }

    return (
        <footer className={styles.footer}>
            <div>
                <p>Total:</p>
                <p></p>
            </div>


            <div>
                <p>{totalPrice.toFixed(2)} CHF</p>
                <Button> Zur Kasse </Button>
>>>>>>> a64520b (ShoppingCartCard optimized)
            </div>
        </footer>

    )
}