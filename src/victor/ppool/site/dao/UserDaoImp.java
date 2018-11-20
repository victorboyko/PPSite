package victor.ppool.site.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import victor.ppool.site.model.User;

public class UserDaoImp implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(User user) {

		String sql = "INSERT INTO user (name, password,  email) VALUES (?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getName(), user.getPassword(), user.getEmail() });

	}

	@Override
	public User get(String login, String password) {
		String sql = "SELECT * FROM user WHERE login='" + login + "' and password='" + password + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	static class UserMapper implements RowMapper<User> {
		  public User mapRow(ResultSet rs, int arg1) throws SQLException {
		    User user = new User();
		    user.setId(rs.getInt("id"));
		    user.setName(rs.getString("name"));
		    user.setPassword(rs.getString("password"));
		    user.setEmail(rs.getString("email"));
		    return user;
		  }
	}

}
