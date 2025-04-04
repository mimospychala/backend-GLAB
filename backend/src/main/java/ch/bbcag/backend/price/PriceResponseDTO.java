package ch.bbcag.backend.price;

import java.util.List;
import java.util.Objects;

public class PriceResponseDTO extends PriceRequestDTO {
    private Integer id;
    private List<Integer> linkedProductIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceResponseDTO that = (PriceResponseDTO) o;
        return Objects.equals(id, that.id);
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

    public List<Integer> getLinkedProductIds() {
        return linkedProductIds;
    }

    public void setLinkedProductIds(List<Integer> linkedProductIds) {
        this.linkedProductIds = linkedProductIds;
    }
}
