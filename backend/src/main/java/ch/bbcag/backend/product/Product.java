package ch.bbcag.backend.product;

import ch.bbcag.backend.categorie.Categorie;
import ch.bbcag.backend.combo.Combo;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.price.Price;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String marke;
    private String description;
    private String image;
    private String altText;
    @ManyToMany
    @JoinTable(
            name = "price_product",
            joinColumns = @JoinColumn(name = "price_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Price> linkedPrices;

    @ManyToMany
    @JoinTable(
            name = "categorie_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private Set<Categorie> linkedCategories;
    private double nomNomRating;
    @OneToMany(mappedBy = "product")
    private Set<Comment> linkedComments;


    @ManyToMany
    @JoinTable(
            name = "combo_product",
            joinColumns = @JoinColumn(name = "combo_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Combo> linkedCombos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Price> getLinkedPrices() {
        return linkedPrices;
    }

    public void setLinkedPrices(Set<Price> linkedPrices) {
        this.linkedPrices = linkedPrices;
    }

    public Set<Categorie> getLinkedCategories() {
        return linkedCategories;
    }

    public void setLinkedCategories(Set<Categorie> linkedCategories) {
        this.linkedCategories = linkedCategories;
    }

    public double getNomNomRating() {
        return nomNomRating;
    }

    public void setNomNomRating(double nomNomRating) {
        this.nomNomRating = nomNomRating;
    }

    public Set<Comment> getLinkedComments() {
        return linkedComments;
    }

    public void setLinkedComments(Set<Comment> linkedComments) {
        this.linkedComments = linkedComments;
    }

    public Set<Combo> getLinkedCombos() {
        return linkedCombos;
    }

    public void setLinkedCombos(Set<Combo> linkedCombos) {
        this.linkedCombos = linkedCombos;
    }


}
