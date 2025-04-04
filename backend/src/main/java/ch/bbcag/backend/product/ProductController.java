package ch.bbcag.backend.product;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = ProductController.PATH)
public class ProductController {
    public static final String PATH = "/products";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found",
                    content = @Content(schema = @Schema(implementation = ProductResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content)
    })
    public ResponseEntity<?> findById(
            @Parameter(description = "Id of product to get")
            @PathVariable("id") Integer id
    ) {
        try {
            Product product = productService.findById(id);
            return ResponseEntity.ok(ProductMapper.toResponseDTO(product));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product was not found");
        }
    }

    @PostMapping
    @Operation(summary = "Add a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product was created successfully",
                    content = @Content(schema = @Schema(implementation = ProductResponseDTO.class))),
            @ApiResponse(responseCode = "409", description = "There was a conflict while creating the product",
                    content = @Content)
    })
    public ResponseEntity<?> insert(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The new product to create")
            @Valid @RequestBody ProductRequestDTO newProductDTO
    ) {
        try {
            Product newProduct = ProductMapper.fromRequestDTO(newProductDTO);
            Product savedProduct = productService.insert(newProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.toResponseDTO(savedProduct));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product could not be created");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product was deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product could not be deleted",
                    content = @Content)
    })
    public ResponseEntity<?> delete(
            @Parameter(description = "Id of product to delete")
            @PathVariable("id") Integer id
    ) {
        try {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product was not found");
        }
    }

    @GetMapping
    @Operation(summary = "Find products with a given name. Only not blank inputs are considered, otherwise all products are returned.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductResponseDTO.class))
                    )
            )
    })
    public ResponseEntity<?> findProducts(
            @Parameter(description = "Product name to search, leave empty for all")
            @RequestParam(required = false) String name
    ) {
        List<Product> products;

        if (StringUtils.isNotBlank(name)) {
            products = productService.findByName(name);
        } else {
            products = productService.findAll();
        }

        return ResponseEntity.ok(products.stream()
                .map(ProductMapper::toResponseDTO)
                .toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product was updated successfully",
                    content = @Content(schema = @Schema(implementation = ProductResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "There was a conflict while updating the product",
                    content = @Content)
    })
    public ResponseEntity<?> update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The product to update")
            @Valid
            @RequestBody ProductRequestDTO updateProductDTO,

            @Parameter(description = "Id of product to update")
            @PathVariable Integer id) {
        try {
            Product updateProduct = ProductMapper.fromRequestDTO(updateProductDTO);
            Product savedProduct = productService.update(updateProduct, id);
            return ResponseEntity.ok(ProductMapper.toResponseDTO(savedProduct));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product could not be created");
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product was not found");
        }
    }
}
