package ch.bbcag.backend.categorie;

import ch.bbcag.backend.FailedValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public Categorie findById(Integer id) {
        return categorieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Categorie> findByName(String name) {
        return categorieRepository.findByName(name);
    }

    public Categorie insert(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie update(Categorie changingCategorie, Integer id) {
        Categorie existingCategorie = this.findById(id);
        mergeCategories(existingCategorie, changingCategorie);
        return categorieRepository.save(existingCategorie);
    }

    public void deleteById(Integer id) {
        findById(id); // throw exception if not found!
        categorieRepository.deleteById(id);
    }


    private void mergeCategories(Categorie existingCategorie, Categorie changingCategorie) {
        Map<String, List<String>> errors = new HashMap<>();

        if (changingCategorie.getName() != null) {
            if (StringUtils.isNotBlank(changingCategorie.getName())) {
                existingCategorie.setName(changingCategorie.getName());
            } else {
                errors.put("name", List.of("Name must not be empty"));
            }
        }

        if (changingCategorie.getLinkedProducts() != null) {
            existingCategorie.setLinkedProducts(changingCategorie.getLinkedProducts());
        }

        if (!errors.isEmpty()) {
            throw new FailedValidationException(errors);
        }
    }
}

