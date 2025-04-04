package ch.bbcag.backend.comment;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class CommentRequestDTO {
    @NotBlank(message = "text must not be empty")
    private String text;
    private Integer productId;
    private Integer comboId;

    public @NotBlank(message = "text must not be empty") String getText() {
        return text;
    }

    public void setText(@NotBlank(message = "text must not be empty") String text) {
        this.text = text;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getComboId() {
        return comboId;
    }

    public void setComboId(Integer comboId) {
        this.comboId = comboId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentRequestDTO that = (CommentRequestDTO) o;
        return Objects.equals(text, that.text) && Objects.equals(productId, that.productId) && Objects.equals(comboId, that.comboId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, productId, comboId);
    }
}
