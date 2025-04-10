import { Link } from "react-router"
import styles from "./ProductCard.module.css"
import "./ProductCard.module.css"
import { fetchPriceById } from "@/lib/prices.API"
import { useState } from "react"
import { useEffect } from "react"

async function loadPrice(id) {
    return await fetchPriceById(id)
}

export default function ProductCard({ product }) {
    console.log(product)
    const { id, name, marke, linkedPricesIds, image, altImg } = product
    console.log(image)
    console.log(marke)
    const [price, setPrice] = useState(null)

    useEffect(() => {
        const fetchPrice = async () => {

            const price = await loadPrice(linkedPricesIds[0])
            setPrice(price)
        }
        fetchPrice()
    }, [linkedPricesIds[0]])

    return (

        <>
            {price ?
                <Link to={`details/${id}`} className={styles.link}>
                    <article className={styles.productCard}>
                        <h2>{name}</h2>
                        <img src={image ? image : altImg} alt={`${name}/${marke}`} />
                        <p>{`${price.price} chf`}</p>
                    </article>
                </Link>
                :
                <div>
                    loading...
                </div>}

        </>

    )
}