package ch.bbcag.backend.comment;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class CommentRequestDTO {
    @NotBlank(message = "text must not be empty")
    private String text;

    public @NotBlank(message = "text must not be empty") String getText() {
        return text;
    }

    public void setText(@NotBlank(message = "text must not be empty") String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentRequestDTO that = (CommentRequestDTO) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }
}
