package ch.bbcag.backend.price;

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
@RequestMapping(path = PriceController.PATH)
public class PriceController {
    public static final String PATH = "/prices";

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price found",
                    content = @Content(schema = @Schema(implementation = PriceResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Price not found",
                    content = @Content)
    })
    public ResponseEntity<?> findById(
            @Parameter(description = "Id of price to get")
            @PathVariable("id") Integer id
    ) {
        try {
            Price price = priceService.findById(id);
            return ResponseEntity.ok(PriceMapper.toResponseDTO(price));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price was not found");
        }
    }

    @PostMapping
    @Operation(summary = "Add a new price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Price was created successfully",
                    content = @Content(schema = @Schema(implementation = PriceResponseDTO.class))),
            @ApiResponse(responseCode = "409", description = "There was a conflict while creating the price",
                    content = @Content)
    })
    public ResponseEntity<?> insert(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The new price to create")
            @Valid @RequestBody PriceRequestDTO newPriceDTO
    ) {
        try {
            Price newPrice = PriceMapper.fromRequestDTO(newPriceDTO);
            Price savedPrice = priceService.insert(newPrice);
            return ResponseEntity.status(HttpStatus.CREATED).body(PriceMapper.toResponseDTO(savedPrice));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Price could not be created");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Price was deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Price could not be deleted",
                    content = @Content)
    })
    public ResponseEntity<?> delete(
            @Parameter(description = "Id of price to delete")
            @PathVariable("id") Integer id
    ) {
        try {
            priceService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price was not found");
        }
    }

    @GetMapping
    @Operation(summary = "Find prices with a given name. Only not blank inputs are considered, otherwise all prices are returned.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prices found",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = PriceResponseDTO.class))
                    )
            )
    })
    public ResponseEntity<?> findPrices(
            @Parameter(description = "Price name to search, leave empty for all")
            @RequestParam(required = false) String name
    ) {
        List<Price> prices;


        prices = priceService.findAll();


        return ResponseEntity.ok(prices.stream()
                .map(PriceMapper::toResponseDTO)
                .toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price was updated successfully",
                    content = @Content(schema = @Schema(implementation = PriceResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Price not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "There was a conflict while updating the price",
                    content = @Content)
    })
    public ResponseEntity<?> update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The price to update")
            @Valid
            @RequestBody PriceRequestDTO updatePriceDTO,

            @Parameter(description = "Id of price to update")
            @PathVariable Integer id) {
        try {
            Price updatePrice = PriceMapper.fromRequestDTO(updatePriceDTO);
            Price savedPrice = priceService.update(updatePrice, id);
            return ResponseEntity.ok(PriceMapper.toResponseDTO(savedPrice));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Price could not be created");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price was not found");
        }
    }
}
