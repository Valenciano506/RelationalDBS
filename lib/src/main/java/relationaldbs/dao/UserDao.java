package relationaldbs.dao;

import java.util.List;
import relationaldbs.model.User;

/*
 * the interface that defines the functionalities to interact with the database
 * @author Valenciano
 * 10 abr 2026
 */
public interface UserDao {

	/**
	 * Insert an user object to database
	 * @param user
	 * @return true if inserted successfully, otherwise false
	 */
	public boolean insert(User User);
	
	/**
	 * delete an user by id
	 * @param id
	 * @return if the user is deleted successfully, return true
	 */
	public boolean delete(long id);
	
	/**
	 * update user data
	 * @param User
	 */
	public void update(User User);
	
	/**
	 * find an user by his id
	 * @param id
	 * @return
	 */
	public User find(long id);
	
	/**
	 * find an user by his email
	 * @param id
	 * @return
	 */
	public User find(String email);
	
	/**
	 * retrieve all users
	 * @return a list of users
	 */
	public List<User> findAll();
	
}
