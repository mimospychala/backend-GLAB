import ProductCards from "@/components/ProductCards";
import { fetchPriceById } from "@/lib/prices.API";
import { fetchProducts } from "@/lib/products.API";
import { useLoaderData } from "react-router";
import styles from "./ListRoute.module.css"

async function loader() {
    const products = await fetchProducts()
    return products
}

export default function ListRoute() {
    const products = useLoaderData()

    return (
        <>
        <h1 className={styles.title}>Alle Produkte</h1>
            <ProductCards products={products} />
        </>
    )
}


ListRoute.loader = loader;