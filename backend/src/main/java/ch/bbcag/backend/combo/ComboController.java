package ch.bbcag.backend.combo;

import ch.bbcag.backend.account.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = ComboController.PATH)
public class ComboController {
    public static final String PATH = "/combos";

    private final ComboService comboService;

    public ComboController(ComboService comboService) {
        this.comboService = comboService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an combo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Combo found",
                    content = @Content(schema = @Schema(implementation = ComboResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Combo not found",
                    content = @Content)
    })
    public ResponseEntity<?> findById(
            @Parameter(description = "Id of combo to get")
            @PathVariable("id") Integer id
    ) {
        try {
            Combo combo = comboService.findById(id);
            return ResponseEntity.ok(ComboMapper.toResponseDTO(combo));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Combo was not found");
        }
    }

    @PostMapping
    @Operation(summary = "Add a new combo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Combo was created successfully",
                    content = @Content(schema = @Schema(implementation = ComboResponseDTO.class))),
            @ApiResponse(responseCode = "409", description = "There was a conflict while creating the combo",
                    content = @Content)
    })
    public ResponseEntity<?> insert(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The new combo to create")
            @Valid @RequestBody ComboRequestDTO newComboDTO,
            @AuthenticationPrincipal Account account
            ) {
        try {
            Combo newCombo = ComboMapper.fromRequestDTO(newComboDTO);
            newCombo.setAccount(account);
            Combo savedCombo = comboService.insert(newCombo);
            return ResponseEntity.status(HttpStatus.CREATED).body(ComboMapper.toResponseDTO(savedCombo));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Combo could not be created");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an combo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Combo was deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Combo could not be deleted",
                    content = @Content)
    })
    public ResponseEntity<?> delete(
            @Parameter(description = "Id of combo to delete")
            @PathVariable("id") Integer id
    ) {
        try {
            comboService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Combo was not found");
        }
    }

    @GetMapping
    @Operation(summary = "Find combos with a given name. Only not blank inputs are considered, otherwise all combos are returned.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Combos found",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ComboResponseDTO.class))
                    )
            )
    })
    public ResponseEntity<?> findCombos(
            @Parameter(description = "Combo name to search, leave empty for all")
            @RequestParam(required = false) String name
    ) {
        List<Combo> combos;

        if (StringUtils.isNotBlank(name)) {
            combos = comboService.findByName(name);
        } else {
            combos = comboService.findAll();
        }

        return ResponseEntity.ok(combos.stream()
                .map(ComboMapper::toResponseDTO)
                .toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an combo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Combo was updated successfully",
                    content = @Content(schema = @Schema(implementation = ComboResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Combo not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "There was a conflict while updating the combo",
                    content = @Content)
    })
    public ResponseEntity<?> update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The combo to update")
            @Valid
            @RequestBody ComboRequestDTO updateComboDTO,

            @Parameter(description = "Id of combo to update")
            @PathVariable Integer id) {
        try {
            Combo updateCombo = ComboMapper.fromRequestDTO(updateComboDTO);
            Combo savedCombo = comboService.update(updateCombo, id);
            return ResponseEntity.ok(ComboMapper.toResponseDTO(savedCombo));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Combo could not be created");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Combo was not found");
        }
    }
}
