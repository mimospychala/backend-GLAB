import ComboDetailCard from "@/components/ComboDetailCard"
import { fetchComboById } from "@/lib/combos.API"
import { useLoaderData } from "react-router"

async function loader({params}) {
    return fetchComboById(params.id)
}

export default function ComboDetailRoute(){
    
        const combo = useLoaderData()
        return (
            <>
                <ComboDetailCard combo={combo}/>
            </>
        )

}

ComboDetailRoute.loader = loader