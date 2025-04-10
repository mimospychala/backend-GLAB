package ch.bbcag.backend.price;

import ch.bbcag.backend.combo.Combo;
import ch.bbcag.backend.combo.ComboRequestDTO;
import ch.bbcag.backend.combo.ComboResponseDTO;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.product.Product;

import java.util.List;

public class PriceMapper {

    public static PriceResponseDTO toResponseDTO(Price price) {
        PriceResponseDTO priceResponseDTO = new PriceResponseDTO();
        priceResponseDTO.setVolume(price.getVolume());
        priceResponseDTO.setPrice(price.getPrice());
        priceResponseDTO.setId(price.getId());
        if(price.getLinkedProducts() != null){
            List<Integer> combosIds = price
                    .getLinkedProducts()
                    .stream()
                    .map(Product::getId)
                    .toList();

            priceResponseDTO.setLinkedProductIds(combosIds);
        }

        return priceResponseDTO;
    }

    public static Price fromRequestDTO(PriceRequestDTO priceRequestDTO) {
        Price price = new Price();
        price.setPrice(priceRequestDTO.getPrice());
        price.setVolume(priceRequestDTO.getVolume());
        return price;
    }
}
