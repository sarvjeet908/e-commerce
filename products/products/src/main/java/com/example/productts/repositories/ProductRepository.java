package com.example.productts.repositories;

import com.example.productts.models.FakeStoreProduct;
import com.example.productts.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
     Optional<Product> findByName(String name);
     Optional<Product> findById(Long id);

     List<Product> findByNameAndDescriptionAndPriceGreaterThan(String name,String description,int price);
     Product save(Product product);
     @Query("select p from Product p where p.id=: sarvjeet")//hql query
     List<Product> something(@Param("sarvjeet") Long id);
}
