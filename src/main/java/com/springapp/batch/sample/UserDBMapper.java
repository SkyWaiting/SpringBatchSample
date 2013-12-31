package com.springapp.batch.sample;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-30
 * Time: 上午9:55
 */
public class UserDBMapper implements RowMapper {
    /**
     * Implementations must implement this method to map each row of data
     * in the ResultSet. This method should not call <code>next()</code> on
     * the ResultSet; it is only supposed to map values of the current row.
     *
     * @param rs     the ResultSet to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return the result object for the current row
     * @throws java.sql.SQLException if a SQLException is encountered getting
     *                               column values (that is, there's no need to catch SQLException)
     */
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("ID"));
        user.setName(rs.getString("NAME"));
        user.setAge(rs.getInt("AGE"));
        user.setBalance(rs.getDouble("BALANCE"));
        return user;
    }
}
