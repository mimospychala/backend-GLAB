package ch.bbcag.backend.combo;

import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.product.Product;

import java.util.List;

public class ComboMapper {
    public static ComboResponseDTO toResponseDTO(Combo combo) {
        ComboResponseDTO comboResponseDTO = new ComboResponseDTO();

        comboResponseDTO.setId(combo.getId());
        comboResponseDTO.setName(combo.getName());
        comboResponseDTO.setDescription(combo.getDescription());
        comboResponseDTO.setPrice(combo.getPrice());
        comboResponseDTO.setNomNomRating(combo.getNomNomRating());
        if(combo.getLinkedComments() != null){
            List<Integer> combosIds = combo
                    .getLinkedComments()
                    .stream()
                    .map(Comment::getId)
                    .toList();

            comboResponseDTO.setLinkedCommentIds(combosIds);
        }
        if(combo.getLinkedProducts() != null){
            List<Integer> productIds = combo
                    .getLinkedProducts()
                    .stream()
                    .map(Product::getId)
                    .toList();

            comboResponseDTO.setLinkedProductIds(productIds);
        }

        return comboResponseDTO;
    }

    public static Combo fromRequestDTO(ComboRequestDTO comboRequestDTO) {
        Combo combo = new Combo();
        combo.setName(comboRequestDTO.getName());
        combo.setDescription(comboRequestDTO.getDescription());
        combo.setPrice(comboRequestDTO.getPrice());
        combo.setNomNomRating(comboRequestDTO.getNomNomRating());
        return combo;
    }
}
