package com.example.productts;

import com.example.productts.models.Product;
import com.example.productts.repositories.CategoryRepository;
import com.example.productts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;  //junit
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProducttsApplicationTests {
	@Autowired
    ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void getSomeData(){
	Optional<Product> optionalProduct=productRepository.findByName("oneplus");
		if(optionalProduct.isEmpty()){
			return;
		}
		Product product= optionalProduct.get();
		System.out.println(product.getId()+" "+product.getPrice());

	}

	@Test
	public  void checkFetchType(){
     categoryRepository.findById(52l);

	}

}
