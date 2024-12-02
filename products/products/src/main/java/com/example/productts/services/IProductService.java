package com.example.productts.services;

import com.example.productts.dtos.ProductrequestDto;
import com.example.productts.dtos.ProductresponseDto;
import com.example.productts.exception.InvalidProductIdException;
import com.example.productts.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id) throws InvalidProductIdException;
    public List<ProductresponseDto> getAllproducts();

   public Product updateProduct(Long id, ProductrequestDto productrequestDto);
    Product addProduct(Product product);
    public Product updateProductTo(Long id, Product product) throws InvalidProductIdException;
}
