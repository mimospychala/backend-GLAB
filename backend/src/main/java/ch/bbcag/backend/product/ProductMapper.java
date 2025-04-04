package ch.bbcag.backend.product;

import ch.bbcag.backend.categorie.Categorie;
import ch.bbcag.backend.combo.Combo;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.price.Price;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductResponseDTO toResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setNomNomRating(product.getNomNomRating());

        if(product.getLinkedPrices() != null){
            List<Integer> priceIds = product
                    .getLinkedPrices()
                    .stream()
                    .map(Price::getId)
                    .toList();

            productResponseDTO.setLinkedPricesIds(priceIds);
        }

        if(product.getLinkedCategories() != null){
            List<Integer> categorieIds = product
                    .getLinkedCategories()
                    .stream()
                    .map(Categorie::getId)
                    .toList();

            productResponseDTO.setLinkedCategoriesIds(categorieIds);
        }

        if(product.getLinkedComments() != null){
            List<Integer> commentIds = product
                    .getLinkedComments()
                    .stream()
                    .map(Comment::getId)
                    .toList();

            productResponseDTO.setLinkedCommmentIds(commentIds);
        }

        if(product.getLinkedCombos() != null){
            List<Integer> comboIds = product
                    .getLinkedCombos()
                    .stream()
                    .map(Combo::getId)
                    .toList();

            productResponseDTO.setLinkedCombosIds(comboIds);
        }
        return productResponseDTO;
    }
    public static Product fromRequestDTO(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setNomNomRating(productRequestDTO.getNomNomRating());
        product.setLinkedPrices(productRequestDTO.getLinkedPricesIds().stream().map(id -> {
            Price price = new Price();
            price.setId(id);
            return price;
        }).collect(Collectors.toSet()));
        product.setLinkedCategories(productRequestDTO.getLinkedCategoriesIds().stream().map(id ->{
            Categorie categorie = new Categorie();
            categorie.setId(id);
            return categorie;
        }).collect(Collectors.toSet()));
        return product;
    }
}
