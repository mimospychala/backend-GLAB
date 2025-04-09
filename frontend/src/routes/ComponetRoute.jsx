import SideBar from "@/components/SideBar"
import LinkButton from "@/components/LinkButton"
import ShoppingCartCard from "@/components/ShoppingCartCard"
import ProductCard from "@/components/ProductCard"
import ProductCards from "@/components/ProductCards"
import Button from "@/components/Button"
import ShoppingCartCards from "@/components/ShoppingCartCards"

export default function ComponetRoute() {
    return (
        <>
            <SideBar sideBarItems={sideBarItems}/>
            <Button>Kasse</Button>
            <ShoppingCartCard product={product[0]} />
            <ShoppingCartCards products={product}/>
            <ProductCard product={product[0]}/>
            <ProductCards products={product}/>

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

const sideBarItems = [
    {
      name: "Snacks",
      children: [
        {
          name: "Chips",
          children: [
            { name: "Paprika", url: "#" },
            { name: "Salt & Vinegar", url: "#" },
            { name: "Classic", url: "#" }
          ]
        },
        {
          name: "Nüsse",
          children: [
            { name: "Gesalzen", url: "#" },
            { name: "Geröstet", url: "#" },
            { name: "Mit Honig", url: "#" }
          ]
        },
        {
          name: "Süßes",
          children: [
            { name: "Schokolade", url: "#" },
            { name: "Gummibärchen", url: "#" },
            { name: "Cookies", url: "#" }
          ]
        }
      ]
    },
    {
      name: "Getränke",
      children: [
        {
          name: "Alkoholisch",
          children: [
            {
              name: "Vodka",
              url: "#"
            },
            {
              name: "Bier",
              children: [
                {
                  name: "Dunkel",
                  url: "#"
                },
                {
                  name: "Hell",
                  url: "#"
                }
              ]
            },
            {
              name: "Wein",
              children: [
                { name: "Rotwein", url: "#" },
                { name: "Weißwein", url: "#" }
              ]
            }
          ]
        },
        {
          name: "Alkoholfrei",
          children: [
            { name: "Wasser", url: "#" },
            { name: "Softdrinks", url: "#" },
            { name: "Säfte", url: "#" }
          ]
        }
      ]
    },
    {
      name: "Kategorien",
      children: [
        { name: "Vegan", url: "#" },
        { name: "Glutenfrei", url: "#" },
        { name: "Bio", url: "#" },
        { name: "Neuheiten", url: "#" }
      ]
    },
    {
      name: "Angebote",
      children: [
        { name: "Bestseller", url: "#" },
        { name: "Rabatte", url: "#" },
        { name: "Saisonale Angebote", url: "#" }
      ]
    }
  ];