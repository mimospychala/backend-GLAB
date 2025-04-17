# Nom Nom Bar

## Inhaltsverzeichnis
1. [Über das Projekt](#über-das-projekt)  
2. [Funktionen](#funktionen)   
4. [Benutzung](#benutzung)  
5. [API Dokumentation](#api-dokumentation)  
6. [Projektstruktur](#projektstruktur)  
7. [Mitwirkende](#mitwirkende)  
8. [Learnings](#learnings)


## Über das Projekt
Unser Ziel war es, einen Online-Shop für Snacks und Getränke zu erstellen. Man kann durch die Produkte scrollen und neue entdecken, und man kann Kommentare sowie eigene Kombinationen (Combos) posten. Das Ganze funktioniert natürlich nur, wenn man eingeloggt ist. Andernfalls kann man die Produkte nur betrachten, aber sie nicht kaufen, dem Warenkorb hinzufügen oder kommentieren.



## Funktionen
- Funktion 1: Man kann sich registrieren.
- Funktion 2: Man kann sich anmelden.
- Funktion 3: Man kann über die Listenansicht zu den Details eines Produktes    kommen und ein Produkt teilen. Wenn man eingeloggt ist, kann Produkte zum Warenkorb hinzufügen und kommentieren.
- Funktion 4: Man kann Combos anschauen und kommentieren (verschiedene Produkte die zusammenpassen).
- Funktion 5: Über die Sidebar kann man zu den verschiedenen Kategorien kommen und jeder Zeit auf andere Proekute wechseln. 

## Benutzung

Backend starten:

Zuerst muss das Backend über IntelliJ gestartet werden (grüner, viereckiger Knopf mit Play-Symbol).

Das Backend läuft auf: localhost:8080

-------------------

Frontend starten:

1. Ein Terminal öffnen (nicht PowerShell).

2. Falls man sich noch nicht im frontend-Ordner befindet, sondern einfach im Hauptordner nom-nom-bar:
cd frontend
→ Es kommt darauf an, wie man das Projekt geöffnet hat – mit Backend und Frontend oder nur das Frontend.

3. Danach diesen Befehl ausführen:
npm run dev

4. Danach sollte das Projekt auf localhost:5173 laufen.



## API Dokumentation
Die API ist mit Swagger dokumentiert.

Swagger UI ist erreichbar unter:
http://localhost:8080/swagger 

## Projektstruktur

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

 

## Mitwirkende
- Baldo Kiara - Frontend & Dokumentation
- Kläy Flurin - Frontend & Backend
- Spychala Mikolaj - Frontend & Backend

## Tests

Funktioniert:

- Wenn man auf die Webseite kommt, werden "Best Drinks", "Best Snacks" und "Best Combos" angezeigt. Diese sind bis jetzt nur hardgecoded und festgelegt. Wenn man auf eine dieser drei Auswahlen drückt, wird man zu dem Produkt weitergeleitet und sieht dort die Details.

- Wenn man auf der Detailansicht von einem Produkt ist, kann man es kommentieren und dem Warenkorb hinzufügen, natürlich nur, wenn man eingeloggt ist.

- Bei den einzelnen Produkten gibt es einen Button, um zu allen Produkten zu gelangen.

- Auf der Seite kann man über die Sidebar zu dem gewünschten Artikelbereich wechseln.

- Im Header gibt es einen Shopping-Cart und Anmelden-Button, die funktionieren.

- Wenn man auf "Anmelden" klickt, kann man sich anmelden. Falls noch kein Konto vorhanden ist, wird man zur Registrierungsseite weitergeleitet.

- Beim erfolgreichen Anmelden wird man zur Index-Seite geleitet.

- Wenn man Fehleingaben eingibt, werden Fehlermeldungen ausgegeben, die den User auf das Problem hinweisen.

- Man kann sich auch oben rechts über einen Button abmelden. Dann hat man Funktionen wie „Zum Shopping-Cart hinzufügen“ und „Kommentare abgeben“ nicht mehr.

- Wenn man auf den Shopping-Cart-Button klickt, wird man zu den Produkten geleitet, die man im LocalStorage gespeichert hat. Man sieht die Menge an Produkten sowie das Volumen der Produkte und das Total.

- Von dort kann man auch wieder zurück, falls man es sich anders überlegt hat oder noch etwas hinzufügen will.

--------------------------------------


####  Funktioniert nicht:

- 



## Fazit

Schlussendlich sind wir mit dem Endergebnis plus/minus zufrieden. Die Webseite war lange nicht komplett, da wir viele einzelne Teile hatten, die wir noch miteinander verknüpfen mussten. Deshalb sah die Webseite lange unfertig und nur angefangen aus. Am Ende haben wir es dann doch zu einer gewissen Seite geschafft, die auch Sinn macht und gut bedienbar ist.
Von der Struktur her ist sie einfach zu bedienen und übersichtlich. Wir haben manchmal unnötig Zeit verloren oder Komplikationen mit Dingen gehabt, die ein anderer ganz einfach lösen konnte. Geplant haben wir eigentlich gut, jedoch wurde es am Ende des Projektes ein bisschen knapp, um eine gute fertige Visualisierung des Projektes zu erkennen.

Die Webseite trifft aber eigentlich unsere Erwartungen und erfüllt auch die meisten Ziele, die wir uns gesetzt haben.
