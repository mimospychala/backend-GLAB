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
}
