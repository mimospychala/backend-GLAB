package ch.bbcag.backend.comment;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(CommentController.PATH)
public class CommentController {
    public static final String PATH = "/comments";

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment found",
                    content = @Content(schema = @Schema(implementation = CommentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Comment not found",
                    content = @Content)
    })
    public ResponseEntity<?> findById(
            @Parameter(description = "Id of comment to get")
            @PathVariable("id") Integer id
    ) {
        try {
            Comment comment = commentService.findById(id);
            return ResponseEntity.ok(CommentMapper.toResponseDTO(comment));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment was not found");
        }
    }

    @PostMapping
    @Operation(summary = "Create a new comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Comment was added successfully",
                    content = @Content(schema = @Schema(implementation = CommentResponseDTO.class))),
            @ApiResponse(responseCode = "409", description = "There was a conflict while creating the comment",
                    content = @Content)
    })
    public ResponseEntity<?> insert(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The new comment to create")
            @Valid @RequestBody CommentRequestDTO newCommentDTO,
            @AuthenticationPrincipal Account account
    ) {
        try {
            Comment newComment = CommentMapper.fromRequestDTO(newCommentDTO);
            newComment.setAccount(account);
            Comment savedComment = commentService.insert(newComment);
            return ResponseEntity.status(HttpStatus.CREATED).body(CommentMapper.toResponseDTO(savedComment));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Comment could not be created");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Comment was deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Comment could not be deleted",
                    content = @Content)
    })
    public ResponseEntity<?> delete(
            @Parameter(description = "Id of comment to delete")
            @PathVariable("id") Integer id
    ) {
        try {
            commentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment was not found");
        }
    }

    @GetMapping
    @Operation(summary = "find all comments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment(s) found",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = CommentResponseDTO.class))
                    )
            )
    })
    public ResponseEntity<?> findComments(
            @Parameter(description = "Comment name to search")
            @RequestParam(required = false) String name
    ) {

        List<Comment> comments = commentService.findAll();

        return ResponseEntity.ok(comments.stream()
                .map(CommentMapper::toResponseDTO)
                .toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment was updated successfully",
                    content = @Content(schema = @Schema(implementation = CommentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Comment was not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "There was a conflict while updating the comment",
                    content = @Content)
    })
    public ResponseEntity<?> update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The comment to update")
            @RequestBody CommentRequestDTO updateCommentDTO,

            @Parameter(description = "Id of comment to update")
            @PathVariable Integer id) {
        try {
            Comment updateComment = CommentMapper.fromRequestDTO(updateCommentDTO);
            Comment savedComment = commentService.update(updateComment, id);
            return ResponseEntity.ok(CommentMapper.toResponseDTO(savedComment));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Comment could not be created");
        }
    }
}