package ch.bbcag.backend.price;

import ch.bbcag.backend.product.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String volume;
    private BigDecimal price;

    @ManyToMany(mappedBy = "linkedPrices")
    private Set<Product> linkedProducts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(id, price.id);
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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Product> getLinkedProducts() {
        return linkedProducts;
    }

    public void setLinkedProducts(Set<Product> linkedProducts) {
        this.linkedProducts = linkedProducts;
    }
}
