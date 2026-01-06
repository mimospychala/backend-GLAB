package ch.bbcag.backend.bid;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(BidController.PATH)
public class BidController {
    public static final String PATH = "/bids";

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a bid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bid found",
                    content = @Content(schema = @Schema(implementation = BidResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Bid not found",
                    content = @Content)
    })
    public ResponseEntity<?> findById(
            @Parameter(description = "Id of bid to get")
            @PathVariable("id") Integer id
    ) {
        try {
            Bid bid = bidService.findById(id);
            return ResponseEntity.ok(BidMapper.toResponseDTO(bid));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bid was not found");
        }
    }

    @PostMapping
    @Operation(summary = "Create a new bid (place a bid)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bid was added successfully",
                    content = @Content(schema = @Schema(implementation = BidResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Account or Container not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "There was a conflict while creating the bid",
                    content = @Content)
    })
    public ResponseEntity<?> insert(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The new bid to create")
            @Valid @RequestBody BidRequestDTO newBidDTO
    ) {
        try {
            Bid savedBid = bidService.createFromDTO(newBidDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(BidMapper.toResponseDTO(savedBid));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Bid could not be created");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a bid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Bid was deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Bid could not be deleted", content = @Content)
    })
    public ResponseEntity<?> delete(
            @Parameter(description = "Id of bid to delete")
            @PathVariable("id") Integer id
    ) {
        try {
            bidService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bid was not found");
        }
    }

    @GetMapping
    @Operation(summary = "Find bids. If no filter is given, all bids are returned.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bid(s) found",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = BidResponseDTO.class))))
    })
    public ResponseEntity<?> findBids(
            @Parameter(description = "Account id to filter by")
            @RequestParam(required = false) Integer accountId,

            @Parameter(description = "Container id to filter by")
            @RequestParam(required = false) Integer containerId
    ) {
        List<Bid> bids;

        if (accountId != null) {
            bids = bidService.findByAccountId(accountId);
        } else if (containerId != null) {
            bids = bidService.findByContainerId(containerId);
        } else {
            bids = bidService.findAll();
        }

        return ResponseEntity.ok(bids.stream()
                .map(BidMapper::toResponseDTO)
                .toList());
    }
}
