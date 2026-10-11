package com.helpdesk.mapper;

import com.helpdesk.enums.Role;
import com.helpdesk.model.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<Users> {
    @Nullable
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Users(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                Role.valueOf(rs.getString("role")),
                rs.getBoolean("is_active")
        );
    }
}
