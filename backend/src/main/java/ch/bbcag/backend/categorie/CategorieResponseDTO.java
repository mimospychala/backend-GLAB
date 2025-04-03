package ch.bbcag.backend.categorie;

import java.util.List;
import java.util.Objects;
;

public class CategorieResponseDTO extends  CategorieRequestDTO{
    private Integer id;

    private List<Integer> productsIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CategorieResponseDTO that = (CategorieResponseDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    public List<Integer> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<Integer> productsIds) {
        this.productsIds = productsIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
