package ch.bbcag.backend;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountRepository;
import ch.bbcag.backend.account.AccountService;
import ch.bbcag.backend.categorie.Categorie;
import ch.bbcag.backend.categorie.CategorieService;
import ch.bbcag.backend.combo.Combo;
import ch.bbcag.backend.combo.ComboService;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.comment.CommentService;
import ch.bbcag.backend.price.Price;
import ch.bbcag.backend.price.PriceService;
import ch.bbcag.backend.product.Product;
import ch.bbcag.backend.product.ProductRepository;
import ch.bbcag.backend.product.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

@Component
public class DatabaseSeed implements CommandLineRunner {
    private final AccountService accountService;
    private final CategorieService categorieService;
    private final PriceService priceService;
    private final ComboService comboService;
    private final CommentService commentService;
    private final ProductService productService;

    public DatabaseSeed(AccountService accountService, CategorieService categorieService, PriceService priceService, ComboService comboService, ProductService productService, CommentService commentService) {
        this.categorieService = categorieService;
        this.accountService = accountService;
        this.priceService = priceService;
        this.comboService = comboService;
        this.productService = productService;
        this.commentService = commentService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Account admin = new Account();
        admin.setEmail("admin@bbcag.com");
        admin.setPassword("admin1234");
        admin.setUsername("Admin");
        accountService.create(admin);

        // Kategorien
        Categorie drinkCat = new Categorie();
        drinkCat.setName("Drinks");
        categorieService.insert(drinkCat);

        Categorie snackCat = new Categorie();
        snackCat.setName("Snacks");
        categorieService.insert(snackCat);

        // Preise
        Price small = new Price();
        small.setVolume("0.33l");
        small.setPrice(BigDecimal.valueOf(1.20));
        priceService.insert(small);

        Price medium = new Price();
        medium.setVolume("0.5l");
        medium.setPrice(BigDecimal.valueOf(1.50));
        priceService.insert(medium);

        Price large = new Price();
        large.setVolume("1.0l");
        large.setPrice(BigDecimal.valueOf(2.20));
        priceService.insert(large);

        List<Product> products = new ArrayList<>();

        // 20 Produkte (10 Drinks + 10 Snacks)
        Object[][] productData = {
                // DRINKS
                {"Coca-Cola", "Coca-Cola Company", "Erfrischendes Koffein-Getränk.", "https://www.woolworths.com.au/shop/productdetails/38121/coca-cola-bottle", drinkCat},
                {"Fanta", "Coca-Cola Company", "Orangenlimonade mit Fruchtgeschmack.", "https://josannecassar.com/press-launches/fanta-launches-new-look-and-feel-with-its-spiral-bottle/", drinkCat},
                {"Sprite", "Coca-Cola Company", "Zitronenlimonade ohne Koffein.", "https://www.walmart.com/ip/Sprite-Lemon-Lime-Soda-16-fl-oz-Can/47375589", drinkCat},
                {"Lipton Ice Tea", "Lipton", "Pfirsich-Eistee, eiskalt serviert.", "https://www.kff.co.uk/lipton-ice-tea-lemon-bottle/p/278", drinkCat},
                {"Pepsi", "PepsiCo", "Erfrischendes Cola-Getränk mit Koffein.", "https://www.walmart.com/ip/Pepsi-Cola-Soda-12-Fl-Oz-6-Count/17787199", drinkCat},
                {"Red Bull", "Red Bull GmbH", "Energydrink für mehr Fokus und Energie.", "https://www.walmart.com/ip/1-Can-Red-Bull-Energy-Drink-12-Fl-Oz/12018772", drinkCat},
                {"Capri-Sun", "Capri-Sun", "Fruchtiger Multivitamin-Saft im Trinkbeutel.", "https://www.walmart.com/ip/Capri-Sun-Strawberry-Kiwi-Juice-Box-Pouches-10-ct-Box-6-fl-oz-Pouches/10309521", drinkCat},
                {"Vöslauer", "Vöslauer", "Natürliches Mineralwasser – prickelnd.", "https://www.amazon.de/-/en/V%C3%B6slauer-Flavour-Bottles-Including-Disposable/dp/B0CJBXQ9DQ", drinkCat},
                {"Mezzo Mix", "Coca-Cola Company", "Kombination aus Cola & Orange.", "https://www.alamy.com/stock-photo/mezzo-mix.html", drinkCat},
                {"Orangina", "Suntory", "Kohlensäurehaltige Orangenlimonade mit Fruchtfleisch.", "https://monsieurchatte.com/product/orangina/", drinkCat},

                // SNACKS
                {"Lay's Paprika", "Lay's", "Knusprige Paprika-Chips.", "https://drive.carrefour.be/nl/Chips-%26-aperitief/Chips/Paprika/Lay%27s-Paprika-Chips-120-gr/p/06540407", snackCat},
                {"Pringles Original", "Pringles", "Der Klassiker unter den Stapelchips.", "https://www.walmart.com/ip/Pringles-Original-Potato-Crisps-Chips-5-2-oz-can/47217461", snackCat},
                {"Doritos Nacho Cheese", "Doritos", "Würzige Maischips mit Käse.", "https://www.kmart.com/doritos-tortilla-chips-nacho-cheese-11.5-oz-326/p-033W003489409000P", snackCat},
                {"Salted Popcorn", "Popz", "Klassisches Popcorn mit Salz.", "https://www.dreamstime.com/bowl-salted-popcorn-table-selective-focus-image210140697", snackCat},
                {"Oreo Cookies", "Oreo", "Doppelkekse mit Vanillecreme.", "https://www.nepal.ubuy.com/en/product/1F8349OG-oreo-chocolate-sandwich-cookies-14-3-oz", snackCat},
                {"Haribo Goldbären", "Haribo", "Fruchtige Gummibärchen.", "https://www.haribo.com/de-de/produkte/goldbaeren", snackCat},
                {"Kinder Bueno", "Ferrero", "Haselnuss-Waffelriegel mit Milchcremefüllung.", "https://www.ferrero.de/produkte/kinder-bueno/", snackCat},
                {"Snickers", "Mars", "Erdnuss-Karamell-Schokoriegel.", "https://www.snickers.com/products/snickers-bar", snackCat},
                {"Twix", "Mars", "Keksriegel mit Karamell und Schokolade.", "https://www.twix.com/products/twix-bar", snackCat},
                {"Milka Alpenmilch", "Milka", "Zarte Schokoladentafel mit Alpenmilch.", "https://www.milka.de/produkte/alpenmilch", snackCat},
        };

        for (int i = 0; i < productData.length; i++) {
            Product product = new Product();
            product.setName((String) productData[i][0]);
            product.setMarke((String) productData[i][1]);
            product.setDescription((String) productData[i][2]);
            product.setImage((String) productData[i][3]);
            product.setAltText((String) productData[i][3]);
            product.setNomNomRating((int) (Math.random() * 5) + 1);

            Set<Categorie> cats = new HashSet<>();
            cats.add((Categorie) productData[i][4]);
            product.setLinkedCategories(cats);

            Set<Price> prices = new HashSet<>();
            prices.add(medium);
            if (i % 2 == 0) prices.add(small);
            product.setLinkedPrices(prices);

            // Kommentar zum Produkt
            Comment comment = new Comment();
            comment.setAccount(admin);
            comment.setProduct(product);
            comment.setText("Mega lecker: " + product.getName());
            comment.setLikes((int) (Math.random() * 10));
            comment.setDislikes((int) (Math.random() * 3));
            commentService.insert(comment);

            Set<Comment> comments = new HashSet<>();
            comments.add(comment);
            product.setLinkedComments(comments);

            productService.insert(product);
            products.add(product);
        }

        // 5 Combos (Drink + Snack)
        for (int i = 0; i < 5; i++) {
            Combo combo = new Combo();
            combo.setName("Combo " + (i + 1));
            combo.setDescription("Perfekt für den Snack-Abend.");
            combo.setAccount(admin);
            combo.setNomNomRating((int) (Math.random() * 5) + 1);
            combo.setPrice(BigDecimal.valueOf(4.99 + i));

            Set<Product> comboProducts = new HashSet<>();
            comboProducts.add(products.get(i));        // Drink
            comboProducts.add(products.get(i + 10));   // Snack
            combo.setLinkedProducts(comboProducts);

            Comment comboComment = new Comment();
            comboComment.setAccount(admin);
            comboComment.setCombo(combo);
            comboComment.setText("Diese Kombo haut rein!");
            comboComment.setLikes((int) (Math.random() * 8));
            comboComment.setDislikes((int) (Math.random() * 2));
            commentService.insert(comboComment);

            Set<Comment> comboComments = new HashSet<>();
            comboComments.add(comboComment);
            combo.setLinkedComments(comboComments);

            comboService.insert(combo);
        }
    }
}
