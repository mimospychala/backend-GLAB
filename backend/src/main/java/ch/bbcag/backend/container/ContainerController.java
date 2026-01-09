package ch.bbcag.backend.container;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.bid.BidService;
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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(ContainerController.PATH)
public class ContainerController {
    public static final String PATH = "/containers";

    private final ContainerService containerService;
    private final BidService bidService;

    public ContainerController(ContainerService containerService, BidService bidService) {
        this.containerService = containerService;
        this.bidService = bidService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Container found",
                    content = @Content(schema = @Schema(implementation = ContainerResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Container not found",
                    content = @Content)
    })
    public ResponseEntity<?> findById(
            @Parameter(description = "Id of container to get")
            @PathVariable("id") Integer id
    ) {
        try {
            Container container = containerService.findById(id);
            BigDecimal highestBid = bidService.getHighestBidAmountForContainer(id);
            Long bidCount = bidService.countBidsForContainer(id);
            return ResponseEntity.ok(ContainerMapper.toResponseDTO(container, highestBid, bidCount));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Container was not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody ContainerRequestDTO dto,
            @AuthenticationPrincipal Account currentUser
    ) {
        Container saved = containerService.insertFromDTO(dto, currentUser);
        // falls du highestBid/bidCount im Response brauchst:
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ContainerMapper.toResponseDTO(saved, null, 0L));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Container was deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Container could not be deleted", content = @Content)
    })
    public ResponseEntity<?> delete(
            @Parameter(description = "Id of container to delete")
            @PathVariable("id") Integer id,
            @AuthenticationPrincipal Account account
    ) {
        try {
            containerService.deleteById(id, account);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Container was not found");
        }
    }

    @GetMapping
    @Operation(summary = "Find containers. If no filter is given, all containers are returned.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Container(s) found",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ContainerResponseDTO.class))))
    })
    public ResponseEntity<?> findContainers(
            @Parameter(description = "Container name to search")
            @RequestParam(required = false) String name,

            @Parameter(description = "Owner id to filter by")
            @RequestParam(required = false) Integer ownerId
    ) {
        List<Container> containers;

        if (ownerId != null) {
            containers = containerService.findByOwnerId(ownerId);
        } else if (name != null) {
            containers = containerService.findByName(name);
        } else {
            containers = containerService.findAll();
        }

        List<ContainerResponseDTO> dtos = containers.stream().map(c -> {
            BigDecimal highestBid = bidService.getHighestBidAmountForContainer(c.getId());
            Long bidCount = bidService.countBidsForContainer(c.getId());
            return ContainerMapper.toResponseDTO(c, highestBid, bidCount);
        }).toList();

        return ResponseEntity.ok(dtos);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update a container")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Container was updated successfully",
                    content = @Content(schema = @Schema(implementation = ContainerResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Container or owner was not found", content = @Content),
            @ApiResponse(responseCode = "409", description = "There was a conflict while updating the container", content = @Content)
    })
    public ResponseEntity<?> update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The container to update")
            @RequestBody ContainerRequestDTO updateDTO,
            @Parameter(description = "Id of container to update")
            @PathVariable Integer id
    ) {
        try {
            Container saved = containerService.updateFromDTO(id, updateDTO);
            BigDecimal highestBid = bidService.getHighestBidAmountForContainer(id);
            Long bidCount = bidService.countBidsForContainer(id);
            return ResponseEntity.ok(ContainerMapper.toResponseDTO(saved, highestBid, bidCount));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Container could not be updated");
        }
    }
}
