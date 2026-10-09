package com.ecom.main;

import com.ecom.config.AppConfig;
import com.ecom.exception.InvalidProductIDException;
import com.ecom.exception.InvalidVendorException;
import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.model.Vendor;
import com.ecom.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
         ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
         ProductService productService = context.getBean(ProductService.class);

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("-------E-Commerce App-----------");
            System.out.println("1. Insert product");
            System.out.println("2. Find product by id");
            System.out.println("3. Update stock quantity");
            System.out.println("4. Count products by vendor");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");

            int input = sc.nextInt();

            if(input == 0) {
                System.out.println("Exiting......");
                break;
            }

            switch (input){
                case 1-> {
                    System.out.println("Insert product");
                    Product product = new Product();
                    Category category = new Category();
                    Vendor vendor = new Vendor();
                    sc.nextLine();

                    System.out.println("Enter the Product's name:");
                    product.setName(sc.nextLine());

                    System.out.println("Enter the Product's price:");
                    product.setPrice(sc.nextDouble());

                    System.out.println("Enter the Product's Stock Quantity:");
                    product.setStockQuantity(sc.nextInt());

                    System.out.println("Enter the Product's category id:");
                    System.out.println("1. Electronics");
                    System.out.println("2. Clothing");
                    System.out.println("3. Books");
                    System.out.println("4. Home Appliances");
                    System.out.println("5. Sports");
                    category.setId(sc.nextInt());
                    product.setCategory(category);

                    System.out.println("Enter the Product's vendor id:");
                    vendor.setId(sc.nextInt());
                    product.setVendor(vendor);
                    try{
                        productService.save(product);
                        System.out.println("Product Added Successfully");
                    }
                    catch (InvalidVendorException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                }
                case 2->{
                    System.out.println("Find Product By Id");
                    System.out.println("Enter the ID:");
                    int id =sc.nextInt();

                    try {
                        Product product = productService.findByID(id);
                        System.out.println(product);
                        System.out.println("Product Name: "+product.getName());
                        System.out.println("Product Price: "+product.getPrice());
                        System.out.println("Product Stock: "+product.getStockQuantity());
                        System.out.println("Product Category Name: "+product.getCategory().getName());
                        System.out.println("Product Vendor Name: "+product.getVendor().getName());
                    } catch (InvalidProductIDException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                }
                case 3->{
                    System.out.println("Update Stock Quantity");
                    System.out.println("Enter the product id:");
                    int id= sc.nextInt();
                    System.out.println("Enter the stock_quantity");
                    int newQuantity = sc.nextInt();

                    try {
                        productService.updateStock(id,newQuantity);
                    } catch (InvalidProductIDException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                }
                case 4->{
                    System.out.println("Count Products by Vendor");
                    Map<String,Integer> countProducts = productService.countProductsByVendor();
                    countProducts.forEach((key, value) -> System.out.println(key + ": " + value));

                    break;
                }
                default ->{
                    System.out.println("Invalid Option");
                    return;
                }
            }


        }


    }

}
