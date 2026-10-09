package com.ecom.service;

import com.ecom.exception.InvalidProductIDException;
import com.ecom.exception.InvalidVendorException;
import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product){

        if(!productRepository.vendorexists(product.getVendor().getId()))
            throw new InvalidVendorException("Invalid Vendor id...");
        productRepository.save(product);

    }


    public Product findByID(int id) {

        if(!productRepository.productExists(id))
            throw new InvalidProductIDException("Invalid product Id...");
        return productRepository.findById(id);

    }

    public void updateStock(int id, int newQuantity){

        if(!productRepository.productExists(id))
            throw new InvalidProductIDException("Invalid product Id...");
        productRepository.updateStock(id,newQuantity);
    }


    public Map<String, Integer> countProductsByVendor() {

        return productRepository.countProductsByVendor();
    }
}
