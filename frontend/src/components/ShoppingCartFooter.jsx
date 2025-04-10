import Button from "./Button";
import styles from "./ShoppingCartFooter.module.css";

export default function ShoppingcartFooter({ price }) {

    return (
        <footer className={styles.footer}>
            <div>
                <p>Total:</p>
                <p></p>
            </div>


            <div>
                <p>19.90 CHF</p>
                <Button> Zur Kasse </Button>
            </div>
        </footer>

    )
}