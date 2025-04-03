package ch.bbcag.backend.combo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComboRepository extends JpaRepository<Combo, Integer> {
    List<Combo> findByName(String name);
}
