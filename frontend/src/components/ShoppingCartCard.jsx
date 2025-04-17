import styles from "./ShoppingCartCard.module.css";
import Button from "./Button";
import { useShoppingCart } from "@/lib/shoppingcart";
import { useState, useEffect } from "react";
import { fetchProductById } from "@/lib/products.API";
import { fetchPriceById } from "@/lib/prices.API";

export default function ShoppingCartCard({ values }) {
  const [products, addProduct, removeProduct] = useShoppingCart()
  const [product, setProduct] = useState(null)
  const { id, volume } = values;

  useEffect(() => {
    const fetchProduct = async () => {
      const fetchProduct = await fetchProductById(id)
      const fetchtPrice = await Promise.all(
        fetchProduct.linkedPricesIds.map((priceId) => fetchPriceById(priceId)))
      fetchProduct.prices = fetchtPrice
      setProduct(fetchProduct)
    }
    fetchProduct()
  }, []);


  const productInCart = products.find(p => p.id === id)
  const count = productInCart ? productInCart.count : values.count

  const increment = () => {
    addProduct({ ...product, volume })
  };

  const decrement = () => {
    removeProduct({ ...product, volume })
  };

  function calcPrice(price, count) {
    const result = price * count;
    const result2 = Math.round(result * 100) / 100;
    return result2.toFixed(2);
  }

  function findPrice() {
    if (!product?.prices) return 0;
    const priceVolume = product.prices.find(p => p.volume === volume);
    return priceVolume?.price || 0;
  }

  return (
    product ? (
      <article>
        <img src="/snacks.png" alt="Snacks" className={styles.drinksSnacks} />

        <div>
          <h3>{product.name}</h3>
          <p>{product.marke}</p>
        </div>

        <div>
          <Button className={styles.smallButton} onClick={decrement}>-</Button>
          {count}
          <Button className={styles.smallButton} onClick={increment}>+</Button>
          <p>{calcPrice(findPrice(), count)} CHF</p>
        </div>
      </article>
    ) : (
      <article>
        Loading...
      </article>
    )
  )
}
