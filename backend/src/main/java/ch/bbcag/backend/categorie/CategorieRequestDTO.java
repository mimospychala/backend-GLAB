package ch.bbcag.backend.categorie;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class CategorieRequestDTO {

    @NotBlank(message = "name must not be empty")

    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieRequestDTO that = (CategorieRequestDTO) o;
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
}
