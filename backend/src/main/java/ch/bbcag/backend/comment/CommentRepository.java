package ch.bbcag.backend.comment;

import ch.bbcag.backend.categorie.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
}
