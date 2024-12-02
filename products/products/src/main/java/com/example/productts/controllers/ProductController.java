package com.example.productts.controllers;

import com.example.productts.dtos.ErrorResponseDto;
import com.example.productts.dtos.ProductWrapper;
import com.example.productts.dtos.ProductrequestDto;
import com.example.productts.dtos.ProductresponseDto;

import com.example.productts.models.Category;
import com.example.productts.models.Product;
import com.example.productts.services.IProductService;
import com.example.productts.exception.InvalidProductIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    //@Autowired
    private  IProductService productService;//got error because now multiple service present
    @Autowired
    public ProductController(@Qualifier("selfProductService") IProductService productService) {
        this.productService = productService;
    }

    //get all the products
    @GetMapping("/products")
    public List<ProductresponseDto> getAllproducts(){
        return  productService.getAllproducts();
    }

    //get a product with id
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductWrapper> getProductwithid(@PathVariable("id") Long id) throws InvalidProductIdException {

/*        ResponseEntity<ProductWrapper>  response;
        try{
            Product singleProduct =productService.getSingleProduct(id);
            *//* return productService.getSingleProduct(id);*//*//Controller calling service
            ProductWrapper  productWrapper=new ProductWrapper(singleProduct,"successfully retrived data");
            response =new ResponseEntity<>(productWrapper, HttpStatus.OK);
        }catch (InvalidProductIdException e){
            ProductWrapper productWrapper=new ProductWrapper(null,"product is not present. ");
            response=new ResponseEntity<>(productWrapper,HttpStatus.NOT_FOUND);
        }

    return response;*/

        ResponseEntity<ProductWrapper>  response;
        Product singleProduct =productService.getSingleProduct(id);

        ProductWrapper  productWrapper=new ProductWrapper(singleProduct,"successfully retrived data");
        response =new ResponseEntity<>(productWrapper, HttpStatus.OK);
    return response;
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidProduct(){
        ResponseEntity<ErrorResponseDto> response =
                new ResponseEntity<>(new ErrorResponseDto("invalid product id exception handled in local"), HttpStatus.INTERNAL_SERVER_ERROR);
    return response;
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id , @RequestBody ProductrequestDto productrequestDto){
/*        Product product=new Product();
        product.setName(productrequestDto.getTitle());
        product.setImage(productrequestDto.getImage());
        product.setPrice(productrequestDto.getPrice());
        product.setDescription(productrequestDto.getDesc());
        product.setCategory(new Category());
        product.getCategory().setName(productrequestDto.getCategory());*/
      return productService.updateProduct(id,productrequestDto);
    }
    @PostMapping("/products")
    public Product  addProduct(@RequestBody ProductrequestDto productrequestDto){
        Product product=new Product();
        product.setName(productrequestDto.getTitle());
        product.setImage(productrequestDto.getImage());
        product.setPrice(productrequestDto.getPrice());
        product.setDescription(productrequestDto.getDesc());
        product.setCategory(new Category());
        product.getCategory().setName(productrequestDto.getCategory());

        Product savedProduct=productService.addProduct(product);//because of qualifier it will go inside
        //SelfProductService class not FakeStoreProductService class.
        return savedProduct;
    }
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id ){
      return true;
    }
    @PutMapping("/productsto/{id}")
    public Product updateProductTo(@PathVariable("id") Long id ,@RequestBody ProductrequestDto productrequestDto) throws InvalidProductIdException {
        Product product=new Product();
        product.setId(id);
        product.setName(productrequestDto.getTitle());
        product.setImage(productrequestDto.getImage());
        product.setPrice(productrequestDto.getPrice());
        product.setDescription(productrequestDto.getDesc());
        product.setCategory(new Category());
        product.getCategory().setName(productrequestDto.getCategory());
        return productService.updateProductTo(id,product);
    }

}
