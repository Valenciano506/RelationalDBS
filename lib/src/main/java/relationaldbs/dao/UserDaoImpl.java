package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		return false;
	}

	@Override
	public void update(User User) {
		
	}

	@Override
	public User find(long id) {
		return null;
	}

	@Override
	public User find(String email) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}
	
}
