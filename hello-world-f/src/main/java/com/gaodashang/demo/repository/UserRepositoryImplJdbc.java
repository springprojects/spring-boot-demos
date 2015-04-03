package com.gaodashang.demo.repository;

import com.gaodashang.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * comments.
 *
 * @author eva
 */
@Profile("jdbc")
@Component("userRepositoryImpl")
class UserRepositoryImplJdbc extends JdbcDaoSupport implements UserRepositoryCustom {

    private static final String COMPLICATED_SQL = "SELECT * FROM User";

    @Autowired
    public UserRepositoryImplJdbc(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public List<User> myCustomBatchOperation() {
        return getJdbcTemplate().query(COMPLICATED_SQL, new UserRowMapper());
    }

    private static class UserRowMapper implements ParameterizedRowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {

            User user = new User(rs.getLong("ID"));
            user.setUserName(rs.getString("USER_NAME"));
            user.setLastName(rs.getString("LAST_NAME"));
            user.setFirstName(rs.getString("FIRST_NAME"));
            return user;
        }
    }
}