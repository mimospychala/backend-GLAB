import ProductCards from "@/components/ProductCards";
import { fetchPriceById } from "@/lib/prices.API";
import { fetchProducts } from "@/lib/products.API";
import { useLoaderData } from "react-router";

async function loader() {
    const products = await fetchProducts()
    return products
}

export default function ListRoute() {
    const products = useLoaderData()

    return (
        <>
            <ProductCards products={products} />
        </>
    )
}


ListRoute.loader = loader;