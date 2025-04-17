# Nom Nom Bar

### Inhaltsverzeichnis
1. [Über das Projekt](#über-das-projekt)  
2. [Funktionen](#funktionen)  
3. [Installation & Setup](#installation--setup)  
4. [Benutzung](#benutzung)  
5. [API Dokumentation](#api-dokumentation)  
6. [Projektstruktur](#projektstruktur)  
7. [Mitwirkende](#mitwirkende)  
8. [Learnings](#learnings)


### Über das Projekt
Unser Ziel war es, einen Online-Shop für Snacks und Getränke zu erstellen. Man kann durch die Produkte scrollen und neue entdecken, und man kann Kommentare sowie eigene Kombinationen (Combos) posten. Das Ganze funktioniert natürlich nur, wenn man eingeloggt ist. Andernfalls kann man die Produkte nur betrachten, aber sie nicht kaufen, dem Warenkorb hinzufügen oder kommentieren.



### Funktionen
- Funktion 1: Man kann sich registrieren.
- Funktion 2: Man kann sich anmelden.
- Funktion 3: Man kann über die Listenansicht zu den Details eines Produktes    kommen und ein Produkt teilen. Wenn man eingeloggt ist, kann Produkte zum Warenkorb hinzufügen und kommentieren.
- Funktion 4: Man kann Combos anschauen und kommentieren (verschiedene Produkte die zusammenpassen).
- Funktion 5: Über die Sidebar kann man zu den verschiedenen Kategorien kommen und jeder Zeit auf andere Proekute wechseln. 

### Installation & Setup


### API Dokumentation
Die API ist mit Swagger dokumentiert.

Swagger UI ist erreichbar unter:
http://localhost:8080/swagger 

### Projektstruktur

nom-num-bar/

│

├── frontend/                       

│   ├── public/                

│   └── src/                         

│       ├── assets/                 

│       ├── components/            

│       ├── lib/                    

│       └── routes/                 

│

├── backend/                       

│   └── src/

│       └── main/

│           ├── java/

│           │   └── ch.bbcag.backend/

│           │       ├── account/           

│           │       ├── categorie/       

│           │       ├── combo/              

│           │       ├── comment/          

│           │       ├── configuration/   

│           │       ├── price/           

│           │       ├── product/           

│           │       ├── DatabaseSeed.java 

│           │       ├── BackendApplication.java

│           │       ├── FailedValidationException.java

│           │       └── GlobalControllerExceptionHandler.java

│           │

│           └── resources/

│               └── application.properties  

│

├── .idea/                          

├── .gitignore                       

├── package.json                     

├── vite.config.js                   

└── README.md                         

 

│

 

### Mitwirkende
- Baldo Kiara - Frontend & Dokumentation
- Kläy Flurin - Frontend & Backend
- Spychala Mikolaj - Frontend & Backend

### Tests

Funktioniert:


Funktioniert nicht:

- Die Produkte 

### Fazit

