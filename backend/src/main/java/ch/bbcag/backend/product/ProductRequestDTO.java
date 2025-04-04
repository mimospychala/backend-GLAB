package ch.bbcag.backend.product;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;

public class ProductRequestDTO {
    @NotBlank
    private  String name;
    @NotBlank
    private String marke;
    private String description;
    private String image;
    private String altText;
    private List<Integer> linkedPricesIds;
    private List<Integer> linkedCategoriesIds;

    @Min(value = 1, message = "must be bigger or same than 1")
    @Max(value = 5, message = "must be smaller or same than 5")
    private double nomNomRating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequestDTO that = (ProductRequestDTO) o;
        return Double.compare(nomNomRating, that.nomNomRating) == 0 && Objects.equals(name, that.name) && Objects.equals(marke, that.marke) && Objects.equals(description, that.description) && Objects.equals(linkedPricesIds, that.linkedPricesIds) && Objects.equals(linkedCategoriesIds, that.linkedCategoriesIds);
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getMarke() {
        return marke;
    }

    public void setMarke(@NotBlank String marke) {
        this.marke = marke;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getLinkedPricesIds() {
        return linkedPricesIds;
    }

    public void setLinkedPricesIds(List<Integer> linkedPricesIds) {
        this.linkedPricesIds = linkedPricesIds;
    }

    public List<Integer> getLinkedCategoriesIds() {
        return linkedCategoriesIds;
    }

    public void setLinkedCategoriesIds(List<Integer> linkedCategoriesIds) {
        this.linkedCategoriesIds = linkedCategoriesIds;
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

    @Min(value = 1, message = "must be bigger or same than 1")
    @Max(value = 5, message = "must be smaller or same than 5")
    public double getNomNomRating() {
        return nomNomRating;
    }

    public void setNomNomRating(@Min(value = 1, message = "must be bigger or same than 1") @Max(value = 5, message = "must be smaller or same than 5") double nomNomRating) {
        this.nomNomRating = nomNomRating;
    }
}
