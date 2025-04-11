import { fetchProductById } from "@/lib/products.API";
import "./DetailsRoute.module.css"
import DetailCard from "@/components/DetailCard";
import { useLoaderData } from "react-router";

async function loader({params}) {
    return fetchProductById(params.id)
}

export default function DetailRoute() {
    const product = useLoaderData()
    console.log(product)
    return (
        <>
            <DetailCard product={product}/>
        </>
    )
}

DetailRoute.loader = loader