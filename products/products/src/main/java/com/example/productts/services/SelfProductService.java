package com.example.productts.services;

import com.example.productts.dtos.ProductrequestDto;
import com.example.productts.dtos.ProductresponseDto;
import com.example.productts.exception.InvalidProductIdException;
import com.example.productts.models.Category;
import com.example.productts.models.Product;
import com.example.productts.repositories.CategoryRepository;
import com.example.productts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SelfProductService implements IProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws InvalidProductIdException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductIdException("product with "+id +" not found");
        }
        Product product=optionalProduct.get();
        return product;
    }

    @Override
    public List<ProductresponseDto> getAllproducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, ProductrequestDto productrequestDto) {
        return null;
    }


    @Override
    public Product addProduct(Product product) {
        Optional<Category> categoryOptional=categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
            //why commented because added cascade directly jpa will do this for me it worked verified
           /* Category categoryTosave=new Category();
            categoryTosave.setName(product.getCategory().getName());
            Category savedCategory=categoryRepository.save(categoryTosave);
            product.setCategory(savedCategory);*/
        }else {
            product.setCategory(categoryOptional.get());
        }
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProductTo(Long id, Product product) throws InvalidProductIdException {
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductIdException("product does n't exist with id"+id);
        }
//            productRepository.save(product);
            Product existingProduct=optionalProduct.get();
            Product updateProduct=new Product();
            /*is it like if updateProduct name will get set as product.getName if this not null
else from existing name it will keep*/
            updateProduct.setName(
                    product.getName()!=null ?
                            product.getName() : existingProduct.getName()
            );
            updateProduct.setId(
                    product.getId()!=null ?
                            product.getId() : existingProduct.getId()
            );
            updateProduct.setDescription(
                    product.getDescription()!=null ?
                            product.getDescription() : existingProduct.getDescription()
            );
            updateProduct.setPrice(
                    product.getPrice() >0 ?
                            product.getPrice() : existingProduct.getPrice()
            );
            updateProduct.setImage(
                    product.getImage()!=null ?
                            product.getImage() : existingProduct.getImage()
            );
            Optional<Category> categoryOptional=categoryRepository.findByName(product.getCategory().getName());
            if(categoryOptional.isEmpty()){
                Category categoryTosave=new Category();
                categoryTosave.setName(product.getCategory().getName());
                Category savedCategory=categoryRepository.save(categoryTosave);
                product.setCategory(savedCategory);
            }else {
                product.setCategory(categoryOptional.get());
            }
            Product savedtodbProduct=productRepository.save(updateProduct);


        return savedtodbProduct;
    }
}
