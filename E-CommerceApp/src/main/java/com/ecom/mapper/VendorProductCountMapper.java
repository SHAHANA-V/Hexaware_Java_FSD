package com.ecom.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Component
public class VendorProductCountMapper implements RowMapper<Map.Entry<String ,Integer>> {
    @Nullable
    @Override
    public Map.Entry<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Map.entry(
                rs.getString("vendor_name"),
                rs.getInt("product_count")
        );
    }
}
