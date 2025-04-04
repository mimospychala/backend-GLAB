package ch.bbcag.backend.comment;

import ch.bbcag.backend.account.AccountMapper;
import ch.bbcag.backend.combo.Combo;
import ch.bbcag.backend.combo.ComboMapper;
import ch.bbcag.backend.combo.ComboService;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.comment.CommentRequestDTO;
import ch.bbcag.backend.comment.CommentResponseDTO;
import ch.bbcag.backend.product.Product;
import ch.bbcag.backend.product.ProductMapper;
import ch.bbcag.backend.product.ProductService;

import java.util.List;

public class CommentMapper {
    public static CommentResponseDTO toResponseDTO(Comment comment) {
        CommentResponseDTO commentResponseDTO = new CommentResponseDTO();

        commentResponseDTO.setId(comment.getId());
        commentResponseDTO.setLikes(comment.getLikes());
        commentResponseDTO.setDislikes(comment.getDislikes());
        commentResponseDTO.setText(comment.getText());
        commentResponseDTO.setAccount(AccountMapper.toDTO(comment.getAccount()));
        if(comment.getProduct() != null) {
            commentResponseDTO.setProductId(comment.getProduct().getId());

        }
        if(comment.getCombo() != null) {
            commentResponseDTO.setComboId(comment.getCombo().getId());
        }



        return commentResponseDTO;
    }
    private ComboService comboService;
    private ProductService productService;

    public static Comment fromRequestDTO(CommentRequestDTO commentRequestDTO, ComboService comboService, ProductService productService) {
        Comment comment = new Comment();

        comment.setText(commentRequestDTO.getText());

        if(commentRequestDTO.getComboId() != null) {
            Combo combo = new Combo();
            combo.setId(commentRequestDTO.getComboId());
            comment.setCombo(combo);
        }

        if(commentRequestDTO.getProductId() != null) {
            Product product = new Product();
            product.setId(commentRequestDTO.getProductId());
            comment.setProduct(product);
        }
        return comment;
    }
}
