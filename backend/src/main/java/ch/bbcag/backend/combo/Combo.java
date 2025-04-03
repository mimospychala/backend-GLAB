package ch.bbcag.backend.combo;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.product.Product;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private String name;
    private String description;
    private double price;
    private double nomNomRating;
    @ManyToMany(mappedBy = "linkedCombos")
    private Set<Product> linkedProducts;
    @OneToMany(mappedBy = "combo")
    private Set<Comment> linkedComments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combo combo = (Combo) o;
        return Objects.equals(id, combo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNomNomRating() {
        return nomNomRating;
    }

    public void setNomNomRating(double nomNomRating) {
        this.nomNomRating = nomNomRating;
    }

    public Set<Product> getLinkedProducts() {
        return linkedProducts;
    }

    public void setLinkedProducts(Set<Product> linkedProducts) {
        this.linkedProducts = linkedProducts;
    }

    public Set<Comment> getLinkedComments() {
        return linkedComments;
    }

    public void setLinkedComments(Set<Comment> linkedComments) {
        this.linkedComments = linkedComments;
    }
}
