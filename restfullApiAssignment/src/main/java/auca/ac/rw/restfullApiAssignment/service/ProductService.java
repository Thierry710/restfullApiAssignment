package auca.ac.rw.restfullApiAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.repository.ProductRepository;

@Service
public class ProductService {
        

    
    @Autowired
    private ProductRepository productRepository;


    public String addNewProduct(Product product) {
      Optional<Product> existProduct = productRepository.findById(product.getId());
      if(existProduct.isPresent()) {
        return "Product with id " + product.getId() + " already exists";
      }else{
              productRepository.save(product);

        return "Product added successfully";
      }
    }
    
    public Iterable<Product> viewAllProducts() {
    return productRepository.findAll();
    }


    public Optional<Product> viewProductById(Long id) {
    return productRepository.findById(id);
    }


    public String updateProduct(Long id, Product updatedProduct) {
    Optional<Product> existProduct = productRepository.findById(id);

    if (existProduct.isPresent()) {
        Product product = existProduct.get();
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        product.setStockQuantity(updatedProduct.getStockQuantity());

        productRepository.save(product);
         return "Product updated successfully";
     } else {
        return "Product with id " + id + " not found";
     }
   }


    public String deleteProduct(Long id) {
    Optional<Product> existProduct = productRepository.findById(id);

    if (existProduct.isPresent()) {
        productRepository.deleteById(id);
        return "Product deleted successfully";
    } else {
        return "Product with id " + id + " not found";
    }
  }
      public List<Product> searchByCategory(String category) {
      List<Product> products = productRepository.findByCategory(category);
      if(products != null && !products.isEmpty()) {
        return products;
  } else {
    return null;
  }
 }     public List<Product> searchByPrice(int price) {
      List<Product> products = productRepository.findByPriceAndBrand(price, 0);
      if(products != null && !products.isEmpty()) {
        return products;
  } else {
    return null;
  }
}   
}
