package com.ecom.repository;

import com.ecom.mapper.ProductMapper;
import com.ecom.mapper.VendorProductCountMapper;
import com.ecom.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;

    public ProductRepository(JdbcTemplate jdbcTemplate, ProductMapper productMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
    }

    public void save(Product product) {
        String sql="insert into product(name,price,stock_quantity,category_id,vendor_id) values(?,?,?,?,?)";
        Object[] values =  new Object[]{product.getName(),product.getPrice(),product.getStockQuantity(),product.getCategory().getId(),product.getVendor().getId()};
        jdbcTemplate.update(sql,values);
    }

    public boolean vendorexists(int id) {
        String sql = "SELECT EXISTS(SELECT 1 FROM vendor WHERE id = ?)";
        Boolean exists = jdbcTemplate.queryForObject(sql, Boolean.class,id);
        return Boolean.TRUE.equals(exists);
    }

    public Product findById(int id) {
        String sql = """
                select p.id as product_id,
                p.name,p.price,p.stock_quantity,
                c.id as category_id,c.name as category_name,
                v.id as vendor_id,v.name as vendor_name
                from product p
                join category c on p.category_id =c.id
                join vendor v on p.vendor_id = v.id
                where p.id=?
                """;

        return jdbcTemplate.queryForObject(sql, productMapper,id);

    }

    public boolean productExists(int id) {
        String sql = "SELECT EXISTS(SELECT 1 FROM product WHERE id = ?)";
        Boolean exists = jdbcTemplate.queryForObject(sql, Boolean.class,id);
        return Boolean.TRUE.equals(exists);
    }

    public void updateStock(int id, int newQuantity) {
        String sql = """
                update product
                set stock_quantity = stock_quantity + ?
                where id = ?
                """;
        jdbcTemplate.update(sql,newQuantity,id);
    }

    public Map<String, Integer> countProductsByVendor() {

        String sql= """
                select v.name as vendor_name,
                count(v.id) as product_count
                from product p
                join vendor v on p.vendor_id = v.id
                group by v.id
                """;

        return jdbcTemplate.query(sql,new VendorProductCountMapper())
                .stream().collect(Collectors.toMap(
                        Map.Entry:: getKey,
                        Map.Entry::getValue
                ));

    }
}
