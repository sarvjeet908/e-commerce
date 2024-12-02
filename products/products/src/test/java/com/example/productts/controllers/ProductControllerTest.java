package com.example.productts.controllers;

import com.example.productts.dtos.ProductresponseDto;
import com.example.productts.models.Product;
import com.example.productts.services.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductControllerTest {
     @MockBean
     private IProductService productService;
    @Test
    void getAllproducts() {
      ProductresponseDto p1=new ProductresponseDto();
      ProductresponseDto p2=new ProductresponseDto();
      ProductresponseDto p3=new ProductresponseDto();
      ProductresponseDto p4=new ProductresponseDto();
      ProductresponseDto p5=new ProductresponseDto();

        List<ProductresponseDto> mockedResponse= Arrays.asList(p1,p2,p3,p4,p5);

        Mockito.when(productService.getAllproducts())
                .thenReturn(mockedResponse);

        List<ProductresponseDto> allProducts=productService.getAllproducts();
        Assertions.assertEquals(6,allProducts.size());

    }
}