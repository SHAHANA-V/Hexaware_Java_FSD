package com.ecom.mapper;

import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.model.Vendor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {

    @Nullable
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getInt("product_id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("stock_quantity"),
                new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                ),
                new Vendor(
                        rs.getInt("vendor_id"),
                        rs.getString("vendor_name")
                )
        );
    }
}
