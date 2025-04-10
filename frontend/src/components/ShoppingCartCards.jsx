import { useEffect } from "react";
import ShoppingCartCard from "./ShoppingCartCard";
import styles from "./ShoppingCartCards.module.css"

export default function ShoppingCartCards({products}){
    
    return(
        <>
            <div className={styles.parent}>
                {products.map((product => <ShoppingCartCard product={product}/>))}
            </div>
            
        </>
    )
}