package ch.bbcag.backend.comment;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountResponseDTO;
import ch.bbcag.backend.combo.Combo;
import ch.bbcag.backend.combo.ComboResponseDTO;
import ch.bbcag.backend.product.Product;
import ch.bbcag.backend.product.ProductResponseDTO;

import java.util.Objects;

public class CommentResponseDTO extends CommentRequestDTO{
    private Integer id;
    private Integer likes;
    private Integer dislikes;
    private AccountResponseDTO account;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommentResponseDTO that = (CommentResponseDTO) o;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public AccountResponseDTO getAccount() {
        return account;
    }

    public void setAccount(AccountResponseDTO account) {
        this.account = account;
    }


}
