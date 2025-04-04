package ch.bbcag.backend.combo;

import ch.bbcag.backend.account.Account;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Objects;

public class ComboRequestDTO {

    @NotBlank(message = "name must not be empty")
    private String name;

    @NotBlank(message = "description must not be empty")
    private String description;

    @Min(0)
    private BigDecimal price;

    @Min(1)
    @Max(5)
    private Double nomNomRating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComboRequestDTO that = (ComboRequestDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public @NotBlank(message = "name must not be empty") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name must not be empty") String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getNomNomRating() {
        return nomNomRating;
    }

    public void setNomNomRating(Double nomNomRating) {
        this.nomNomRating = nomNomRating;
    }
}
