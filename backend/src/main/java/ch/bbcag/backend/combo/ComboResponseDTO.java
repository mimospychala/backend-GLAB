package ch.bbcag.backend.combo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ComboResponseDTO extends ComboRequestDTO  {

    private Integer id;
    private List<Integer> linkedProductIds;
    private List<Integer> linkedCommentIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComboResponseDTO that = (ComboResponseDTO) o;
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

    public List<Integer> getLinkedCommentIds() {
        return linkedCommentIds;
    }

    public void setLinkedCommentIds(List<Integer> linkedCommentIds) {
        this.linkedCommentIds = linkedCommentIds;
    }
}
