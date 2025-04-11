import SideBar from "@/components/SideBar"
import LinkButton from "@/components/LinkButton"
import ShoppingCartCard from "@/components/ShoppingCartCard"
import ProductCard from "@/components/ProductCard"
import ProductCards from "@/components/ProductCards"
import Button from "@/components/Button"
import ShoppingCartCards from "@/components/ShoppingCartCards"
import siedeBarItems from "@/lib/data/sideBarItems";
import ShareButton from "@/components/ShareButton"
import ProductDetailCard from "@/components/ProductDetailCard"
import DetailRoute from "./DetailsRoute"
import sideBarItems from "@/lib/data/sideBarItems"

export default function ComponetRoute() {
    return (
        <>
            <SideBar sideBarItems={siedeBarItems}/>
            <SideBar sideBarItems={sideBarItems}/>
            <Button>Kasse</Button>
            <ShoppingCartCard product={product[0]} />
            <ShoppingCartCards products={product}/>
            <ShareButton/>
            <ProductDetailCard product={product[0]}/>
            

        </>
    )
}

const product = [
    {
        id: "1",
        name: "Cola",
        marke: "Coca-Cola",
        numNumRating: "5",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "0.5L", price: "1.50" },
            { volume: "1.0L", price: "2.50" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."
    },
    {
        id: "2",
        name: "Fanta",
        marke: "Coca-Cola",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "0.5L", price: "1.40" },
            { volume: "1.0L", price: "2.40" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    },
    {
        id: "3",
        name: "Snickers",
        marke: "Mars",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "50g", price: "1.20" },
            { volume: "100g", price: "2.00" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    },
    {
        id: "4",
        name: "Chips",
        marke: "Pringles",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "150g", price: "2.50" },
            { volume: "200g", price: "3.50" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    },
    {
        id: "5",
        name: "Sprite",
        marke: "Coca-Cola",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "0.5L", price: "1.30" },
            { volume: "1.0L", price: "2.30" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    },
    {
        id: "6",
        name: "Twix",
        marke: "Mars",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "50g", price: "1.10" },
            { volume: "100g", price: "1.90" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    },
    {
        id: "7",
        name: "Oreo",
        marke: "Mondelez",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "154g", price: "2.00" },
            { volume: "308g", price: "3.80" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    },
    {
        id: "8",
        name: "Ice Tea",
        marke: "Lipton",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "0.5L", price: "1.60" },
            { volume: "1.5L", price: "2.80" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    },
    {
        id: "9",
        name: "Bounty",
        marke: "Mars",
        altImag: "/snacks.png",
        img: "/snacks.png",
        prices: [
            { volume: "57g", price: "100.3" },
            { volume: "114g", price: "200.2" }
        ],
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sed eos praesentium pariatur, cumque, repellendus laudantium enim ducimus libero consectetur, natus provident. Officiis quae labore magni, error pariatur autem voluptatum. Eius."

    }
];

