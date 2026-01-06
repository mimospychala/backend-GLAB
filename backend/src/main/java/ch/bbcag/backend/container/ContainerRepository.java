package ch.bbcag.backend.container;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainerRepository extends JpaRepository<Container, Integer> {
    List<Container> findByNameContainingIgnoreCase(String name);
    List<Container> findByOwnerId(Integer ownerId);
}

