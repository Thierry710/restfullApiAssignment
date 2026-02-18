package auca.ac.rw.restfullApiAssignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByPriceAndBrand(int price, float brand);
    //List<product> findByPriceGreaterThan(Double price)
    //List<product> findByPriceLessThan(Double price)
     
}
