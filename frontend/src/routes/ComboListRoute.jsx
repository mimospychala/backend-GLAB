import ComboCards from "@/components/ComboCards";
import { fetchCombos } from "@/lib/combos.API";
import { useLoaderData } from "react-router";
import styles from "./ComboListRoute.module.css"

async function loader() {
    const combos = await fetchCombos()
    return combos
}

export default function ComboListRoute() {
    const combos = useLoaderData()

    return (
        <>
        <h1 className={styles.title}>Alle Combos</h1>
            <ComboCards combos={combos} />
        </>
    )
}


ComboListRoute.loader = loader;