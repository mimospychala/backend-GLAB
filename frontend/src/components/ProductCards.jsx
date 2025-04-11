import ProductCard from "./ProductCard";
import styles from "./ProductCards.module.css"

export default function ProductCards({products}){
    return(
        <>
            <div className={styles.parent}>
                {products.map((product => <ProductCard key={product.id} product={product}/>))}
            </div>
            
        </>
    )
}