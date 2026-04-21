package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import relationaldbs.model.User;

/*
 *
 * @author Valenciano
 * 10 abr 2026
 */
public class UserDaoImpl implements UserDao{
	
	private final static String dbURL = "jdbc:postgresql://localhost:5432/postgres";
	private final static String username = "postgres";
	private final static String password = "admin";

	@Override
	public boolean insert(User user) {
		//the ingredients that we need to do the task
		//insert sql
		String insertSQL = "insert into users (name, password, balance, dni, email, age, tlf, adress)" + "values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (
			//create an object of Connection to establish a network connection with the database used in our program
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			//create an object of PreparedStatement which allows us to prepare, send and execute sqls
			PreparedStatement ps = conn.prepareStatement(insertSQL)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setFloat(3, user.getBalance());
			ps.setLong(4, user.getDni());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getAge());
			ps.setLong(7, user.getTlf());
			ps.setString(8, user.getAdress());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(long id) {
	    String deleteSQL = "DELETE FROM users WHERE id = ?";

	    try (
	        Connection conn = DriverManager.getConnection(dbURL, username, password);
	        PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

	        ps.setLong(1, id);
	        int rowsAffected = ps.executeUpdate();
	        return rowsAffected > 0; // true si se eliminó al menos 1 fila

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public void update(User user) {
		String updateSQL = "UPDATE users SET name = ?, password = ?, balance = ?, dni = ?, " +
                "email = ?, age = ?, tlf = ?, adress = ? WHERE id = ?";

try (
 Connection conn = DriverManager.getConnection(dbURL, username, password);
 PreparedStatement ps = conn.prepareStatement(updateSQL)) {

 ps.setString(1, user.getName());
 ps.setString(2, user.getPassword());
 ps.setFloat(3, user.getBalance());
 ps.setLong(4, user.getDni());
 ps.setString(5, user.getEmail());
 ps.setInt(6, user.getAge());
 ps.setLong(7, user.getTlf());
 ps.setString(8, user.getAdress());
 ps.setLong(9, user.getId()); // WHERE id = ?
 ps.executeUpdate();

} catch (SQLException e) {
 e.printStackTrace();
}
	}

	@Override
	public User find(long id) {
		String findSQL = "SELECT * FROM users WHERE id = ?";
	    User user = null;

	    try (
	        Connection conn = DriverManager.getConnection(dbURL, username, password);
	        PreparedStatement ps = conn.prepareStatement(findSQL)) {

	        ps.setLong(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            user = mapResultSetToUser(rs);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}

	@Override
	public User find(String email) {
		String findSQL = "SELECT * FROM users WHERE email = ?";
	    User user = null;

	    try (
	        Connection conn = DriverManager.getConnection(dbURL, username, password);
	        PreparedStatement ps = conn.prepareStatement(findSQL)) {

	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            user = mapResultSetToUser(rs);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}

	@Override
	public List<User> findAll() {
		String findAllSQL = "SELECT * FROM users";
	    List<User> users = new ArrayList<>();

	    try (
	        Connection conn = DriverManager.getConnection(dbURL, username, password);
	        PreparedStatement ps = conn.prepareStatement(findAllSQL);
	        ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            users.add(mapResultSetToUser(rs));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return users;
	}
	
	private User mapResultSetToUser(ResultSet rs) throws SQLException {
	    User user = new User(null, null, 0, 0, 0, null, 0, 0, null);
	    user.setId(rs.getLong("id"));
	    user.setName(rs.getString("name"));
	    user.setPassword(rs.getString("password"));
	    user.setBalance(rs.getFloat("balance"));
	    user.setDni(rs.getLong("dni"));
	    user.setEmail(rs.getString("email"));
	    user.setAge(rs.getInt("age"));
	    user.setTlf(rs.getLong("tlf"));
	    user.setAdress(rs.getString("adress"));
	    return user;
	}
	
}
