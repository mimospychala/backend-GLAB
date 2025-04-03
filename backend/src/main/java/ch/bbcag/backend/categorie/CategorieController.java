package ch.bbcag.backend.categorie;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(CategorieController.PATH)
public class CategorieController {
    public static final String PATH = "/categories";

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a categorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorie found",
                    content = @Content(schema = @Schema(implementation = CategorieResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Categorie not found",
                    content = @Content)
    })
    public ResponseEntity<?> findById(
            @Parameter(description = "Id of categorie to get")
            @PathVariable("id") Integer id
    ) {
        try {
            Categorie categorie = categorieService.findById(id);
            return ResponseEntity.ok(CategorieMapper.toResponseDTO(categorie));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categorie was not found");
        }
    }

    @PostMapping
    @Operation(summary = "Create a new categorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categorie was added successfully",
                    content = @Content(schema = @Schema(implementation = CategorieResponseDTO.class))),
            @ApiResponse(responseCode = "409", description = "There was a conflict while creating the categorie",
                    content = @Content)
    })
    public ResponseEntity<?> insert(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The new categorie to create")
            @Valid @RequestBody CategorieRequestDTO newCategorieDTO
    ) {
        try {
            Categorie newCategorie = CategorieMapper.fromRequestDTO(newCategorieDTO);
            Categorie savedCategorie = categorieService.insert(newCategorie);
            return ResponseEntity.status(HttpStatus.CREATED).body(CategorieMapper.toResponseDTO(savedCategorie));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Categorie could not be created");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a categorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categorie was deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Categorie could not be deleted",
                    content = @Content)
    })
    public ResponseEntity<?> delete(
            @Parameter(description = "Id of categorie to delete")
            @PathVariable("id") Integer id
    ) {
        try {
            categorieService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categorie was not found");
        }
    }

    @GetMapping
    @Operation(summary = "Find categories with a given name. If no name given, all categories are returned.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorie(s) found",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = CategorieResponseDTO.class))
                    )
            )
    })
    public ResponseEntity<?> findCategories(
            @Parameter(description = "Categorie name to search")
            @RequestParam(required = false) String name
    ) {

        List<Categorie> categories = name != null
                ? categorieService.findByName(name)
                : categorieService.findAll();

        return ResponseEntity.ok(categories.stream()
                .map(CategorieMapper::toResponseDTO)
                .toList());
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update a categorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorie was updated successfully",
                    content = @Content(schema = @Schema(implementation = CategorieResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Categorie was not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "There was a conflict while updating the categorie",
                    content = @Content)
    })
    public ResponseEntity<?> update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The categorie to update")
            @RequestBody CategorieRequestDTO updateCategorieDTO,

            @Parameter(description = "Id of categorie to update")
            @PathVariable Integer id) {
        try {
            Categorie updateCategorie = CategorieMapper.fromRequestDTO(updateCategorieDTO);
            Categorie savedCategorie = categorieService.update(updateCategorie, id);
            return ResponseEntity.ok(CategorieMapper.toResponseDTO(savedCategorie));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Categorie could not be created");
        }
    }
}
