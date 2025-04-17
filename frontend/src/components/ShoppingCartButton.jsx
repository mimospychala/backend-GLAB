import { ShoppingCart } from "lucide-react";
import Button from "./Button";
import styles from "./ShoppingCartButton.module.css"

export default function ShoppingCartButton() {

    
    return (
        <>
            <Button to="/shoppingCart" className={styles.button}>
                <ShoppingCart />
            </Button>
        </>
    )
}