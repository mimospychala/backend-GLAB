package ch.bbcag.backend.categorie;

import ch.bbcag.backend.product.Product;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "linkedCategories")
    private Set<Product> linkedProducts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(id, categorie.id);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getLinkedProducts() {
        return linkedProducts;
    }

    public void setLinkedProducts(Set<Product> linkedProducts) {
        this.linkedProducts = linkedProducts;
    }
}
