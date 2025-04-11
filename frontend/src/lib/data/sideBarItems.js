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
        name: "Süsses",
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

export default sideBarItems;