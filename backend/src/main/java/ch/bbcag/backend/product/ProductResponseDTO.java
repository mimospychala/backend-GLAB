package ch.bbcag.backend.product;

import java.util.List;
import java.util.Objects;

public class ProductResponseDTO extends ProductRequestDTO{
    private Integer id;
    private List<Integer> linkedCommmentIds;
    private List<Integer> linkedCombosIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductResponseDTO that = (ProductResponseDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getLinkedCommmentIds() {
        return linkedCommmentIds;
    }

    public void setLinkedCommmentIds(List<Integer> linkedCommmentIds) {
        this.linkedCommmentIds = linkedCommmentIds;
    }

    public List<Integer> getLinkedCombosIds() {
        return linkedCombosIds;
    }

    public void setLinkedCombosIds(List<Integer> linkedCombosIds) {
        this.linkedCombosIds = linkedCombosIds;
    }
}
