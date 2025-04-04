package ch.bbcag.backend.comment;


import ch.bbcag.backend.FailedValidationException;
import ch.bbcag.backend.comment.Comment;
import ch.bbcag.backend.comment.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    private final CommentRepository CommentRepository;
    public CommentService(CommentRepository CommentRepository) {
        this.CommentRepository = CommentRepository;
    }

    public List<Comment> findAll() {
        return CommentRepository.findAll();
    }

    public Comment findById(Integer id) {
        return CommentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public Comment insert(Comment Comment) {
        return CommentRepository.save(Comment);
    }

    public Comment update(Comment changingComment, Integer id) {
        changingComment.setId(id);
        return CommentRepository.save(changingComment);
    }

    public void deleteById(Integer id) {
        findById(id);
        CommentRepository.deleteById(id);
    }

}