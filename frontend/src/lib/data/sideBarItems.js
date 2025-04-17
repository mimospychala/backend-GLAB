const sideBarItems = [
  {
    name: "Drinks",
    children: [
      {
        name: "Mit Kohlensäure",
        children: [
          { name: "Cola", url: "#" },
          { name: "Sprite", url: "#" },
          { name: "Fanta", url: "#" }
        ]
      },
      {
        name: "Ohne Kohlensäure",
        children: [
          { name: "Wasser", url: "#" },
          { name: "Eistee", url: "#" },
          { name: "Saft", url: "#" }
        ]
      }
    ]
  },
  {
    name: "Snacks",
    children: [
      {
        name: "Salzig",
        children: [
          { name: "Chips", url: "#" },
          { name: "Nüsse", url: "#" }
        ]
      },
      {
        name: "Süss",
        children: [
          { name: "Schokolade", url: "#" },
          { name: "Gummibärchen", url: "#" },
          { name: "Kekse", url: "#" }
        ]
      }
    ]
  },
  {
    name: "Combos",
    children: [
      { name: "Snack + Drink", url: "#" },
      { name: "Süß + Salzig", url: "#" },
      { name: "Family Pack", url: "#" }
    ]
  }
];

export default sideBarItems;
