import { useState } from "react" 
import Button from "./Button" 
import styles from "./ShoppingCartFooter.module.css" 
import { useShoppingCart } from "@/lib/shoppingcart" 
import { fetchProductById } from "@/lib/products.API" 
import { fetchPriceById } from "@/lib/prices.API" 
import { useEffect } from "react" 

export default function ShoppingcartFooter({ }) {
    const[cartItems] = useShoppingCart() 
    const [products, setProducts] = useState([]) 
    const [totalPrice, setTotalPrice] = useState(0) 

    useEffect(() => {
        const fetchData = async () => {
            const fetchedProducts = await Promise.all(
                cartItems.map(async (item) => {
                    const product = await fetchProductById(item.id) 
                    const prices = await Promise.all(
                        product.linkedPricesIds.map((id) => fetchPriceById(id))
                    ) 

                    const priceObj = prices.find(p => p.volume === item.volume)
                    const price = priceObj?.price || 0

                    return {
                        ...item,
                        price: price,
                    } 
                })
            ) 

            setProducts(fetchedProducts) 

            const total = fetchedProducts.reduce((acc, item) => {
                return acc + item.count * item.price 
            }, 0) 

            setTotalPrice(Number(total.toFixed(2))) 
        } 

        fetchData() 
    }, [cartItems]) 

    return (
        <footer className={styles.footer}>
            <div className={styles.bar}></div>
            <div className={styles.content}>
                <p >Total:</p>
                <div className={styles.footerMargin}>
                    <p>{`${totalPrice.toFixed(2)}`} CHF</p>
                    <Button> Zur Kasse </Button>
                </div>
            </div>
        </footer>

    )
}