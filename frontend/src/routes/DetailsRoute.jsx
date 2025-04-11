import "./DetailsRoute.module.css"
import DetailCard from "@/components/DetailCard";

export default function DetailRoute({ product }) {

    return (
        <>
            <DetailCard product={product}/>
        </>
    )
}