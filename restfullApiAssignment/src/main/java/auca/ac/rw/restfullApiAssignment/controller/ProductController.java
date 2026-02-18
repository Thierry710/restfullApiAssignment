package auca.ac.rw.restfullApiAssignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @PostMapping(value = "/addProduct",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {

        String saveProduct = productService.addNewProduct(product);

        if (saveProduct.equals("Product added successfully")) {
            return new ResponseEntity<>(saveProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(saveProduct, HttpStatus.CONFLICT);
        }
    }

    
    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllProducts() {
        return new ResponseEntity<>(productService.viewAllProducts(), HttpStatus.OK);
    }

    
    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewProductById(@PathVariable Long id) {

        Optional<Product> product = productService.viewProductById(id);

        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product with id " + id + " not found",
                    HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@PathVariable Long id,
                                           @RequestBody Product product) {

        String response = productService.updateProduct(id, product);

        if (response.equals("Product updated successfully")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        String response = productService.deleteProduct(id);

        if (response.equals("Product deleted successfully")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchProductsByCategory(@RequestParam String category) {
        List<Product> getproducts = productService.searchByCategory(category);
        if(getproducts != null && !getproducts.isEmpty()) {
            return new ResponseEntity<>(getproducts, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("Products with that category not found", HttpStatus.NOT_FOUND);
        }
    }  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchProductsByPrice(@RequestParam int price) {
        List<Product> getproducts = productService.searchByPrice(price);
        if(getproducts != null && !getproducts.isEmpty()) {
            return new ResponseEntity<>(getproducts, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("Products with that price not found", HttpStatus.NOT_FOUND);
        }
    }
}
