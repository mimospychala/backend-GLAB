package ch.bbcag.backend.combo;


import ch.bbcag.backend.FailedValidationException;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComboService {
    private final ComboRepository comboRepository;

    public ComboService(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    public List<Combo> findAll() {
        return comboRepository.findAll();
    }

    public Combo findById(Integer id) {
        return comboRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Combo> findByName(String name) {
        return comboRepository.findByName(name);
    }

    public Combo insert(Combo combo) {
        return comboRepository.save(combo);
    }

    public Combo update(Combo changingCombo, Integer id) {
        Combo existingCombo = this.findById(id);
        changingCombo.setId(id);
        return comboRepository.save(changingCombo);
    }

    public void deleteById(Integer id) {
        findById(id); // throw exception if not found
        comboRepository.deleteById(id);
    }


    private void mergeCombos(Combo existingCombo, Combo changingCombo) {
        Map<String, List<String>> errors = new HashMap<>();

        if (changingCombo.getName() != null) {
            if (StringUtils.isNotBlank(changingCombo.getName())) {
                existingCombo.setName(changingCombo.getName());
            } else {
                errors.put("name", List.of("Name must not be empty."));
            }
        }

        if (changingCombo.getDescription() != null) {
            if (StringUtils.isNotBlank(changingCombo.getDescription())) {
                existingCombo.setDescription(changingCombo.getDescription());
            } else {
                errors.put("name", List.of("Beschreibung must not be empty."));
            }
        }

        if (changingCombo.getLinkedProducts() != null) {
            existingCombo.setLinkedProducts(changingCombo.getLinkedProducts());
        }

        if (changingCombo.getLinkedProducts() != null) {
            existingCombo.setLinkedProducts(changingCombo.getLinkedProducts());
        }
        if (changingCombo.getLinkedComments() != null) {
            existingCombo.setLinkedComments(changingCombo.getLinkedComments());
        }
        if (changingCombo.getLinkedProducts() != null) {
            existingCombo.setLinkedProducts(changingCombo.getLinkedProducts());
        }
        if (changingCombo.getPrice() != null) {
            if (changingCombo.getPrice().compareTo(BigDecimal.ZERO) >  0) {
            existingCombo.setPrice(changingCombo.getPrice());
        } else {
            errors.put("name", List.of("Preis darf nicht kleiner Nul sein"));
        }
        }
        if (changingCombo.getNomNomRating() != null) {
            if (changingCombo.getNomNomRating() >=  1 && changingCombo.getNomNomRating() <=  5) {
                existingCombo.setPrice(changingCombo.getPrice());
            } else {
                errors.put("name", List.of("Nom Nom Rating must be between 1 and 5"));
            }
        }
        if (!errors.isEmpty()) {
            throw new FailedValidationException(errors);
        }
    }
}
