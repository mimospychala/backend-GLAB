package ch.bbcag.backend.comment;

import ch.bbcag.backend.account.AccountMapper;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.comment.CommentRequestDTO;
import ch.bbcag.backend.comment.CommentResponseDTO;
import ch.bbcag.backend.product.Product;

import java.util.List;

public class CommentMapper {
    public static CommentResponseDTO toResponseDTO(Comment comment) {
       CommentResponseDTO commentResponseDTO = new CommentResponseDTO();

        commentResponseDTO.setId(comment.getId());
        commentResponseDTO.setLikes(comment.getLikes());
        commentResponseDTO.setProduct(comment.getProduct());
        commentResponseDTO.setDislikes(comment.getDislikes());
        commentResponseDTO.setText(comment.getText());
        commentResponseDTO.setCombo(comment.getCombo());
        commentResponseDTO.setAccount(AccountMapper.toDTO(comment.getAccount()));


        return commentResponseDTO;
    }


    public static Comment fromRequestDTO(CommentRequestDTO commentRequestDTO) {
        Comment comment = new Comment();
        comment.setText(commentRequestDTO.getText());
        return comment;
    }
}
