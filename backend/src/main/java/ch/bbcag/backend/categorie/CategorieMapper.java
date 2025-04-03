package ch.bbcag.backend.categorie;

import ch.bbcag.backend.product.Product;

import java.util.List;

public class CategorieMapper {

    public static CategorieResponseDTO toResponseDTO(Categorie categorie) {
        CategorieResponseDTO categorieResponseDTO = new CategorieResponseDTO();

        categorieResponseDTO.setId(categorie.getId());
        categorieResponseDTO.setName(categorie.getName());
        if (categorie.getLinkedProducts() != null) {
            List<Integer> productIds = categorie.getLinkedProducts().stream().map(Product::getId).toList();
            categorieResponseDTO.setProductsIds(productIds);
        }


        return categorieResponseDTO;
    }


    public static Categorie fromRequestDTO(CategorieRequestDTO categorieRequestDTO) {
        Categorie categorie = new Categorie();

        categorie.setName(categorieRequestDTO.getName());

        return categorie;
    }
}
