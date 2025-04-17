import BestProductCard from "@/components/bestProductCard"
import styles from "./IndexRoute.module.css"


export default function IndexRoute() {
    return (
        <>
            <h3 className={styles.title}>Nom Nom Bar</h3>
            <div className={styles.container}>
                <BestProductCard product={product[0]} label="Best Snack" img="/snacks.png" id={15}/>
                <BestProductCard product={product[1]} label="Best Combo" img="/combo.png" id={5}/>
                <BestProductCard product={product[2]} label="Best Drink" img="/drinks.png" id={2}/>
            </div>
        </>
    )
}

const product = [
    {
        id: "1",
        name: "Cola",
        marke: "Coca-Cola",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "0.5L", price: "1.50" },
            { volume: "1.0L", price: "2.50" }
        ]
    },
    {
        id: "2",
        name: "Fanta",
        marke: "Coca-Cola",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "0.5L", price: "1.40" },
            { volume: "1.0L", price: "2.40" }
        ]
    },
    {
        id: "3",
        name: "Snickers",
        marke: "Mars",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "50g", price: "1.20" },
            { volume: "100g", price: "2.00" }
        ]
    },
    {
        id: "4",
        name: "Chips",
        marke: "Pringles",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "150g", price: "2.50" },
            { volume: "200g", price: "3.50" }
        ]
    },
    {
        id: "5",
        name: "Sprite",
        marke: "Coca-Cola",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "0.5L", price: "1.30" },
            { volume: "1.0L", price: "2.30" }
        ]
    },
    {
        id: "6",
        name: "Twix",
        marke: "Mars",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "50g", price: "1.10" },
            { volume: "100g", price: "1.90" }
        ]
    },
    {
        id: "7",
        name: "Oreo",
        marke: "Mondelez",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "154g", price: "2.00" },
            { volume: "308g", price: "3.80" }
        ]
    },
    {
        id: "8",
        name: "Ice Tea",
        marke: "Lipton",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "0.5L", price: "1.60" },
            { volume: "1.5L", price: "2.80" }
        ]
    },
    {
        id: "9",
        name: "Bounty",
        marke: "Mars",
        altImag: "/snacks.png",
        img: "/snacks.png",
        volumes: [
            { volume: "57g", price: "100.3" },
            { volume: "114g", price: "200.2" }
        ]
    }
];

