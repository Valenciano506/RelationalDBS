package relationaldbs.dao;

import java.util.List;

import relationaldbs.model.User;

/*
 *
 * @author Valenciano
 * 10 abr 2026
 */
public class UserDaoImpl implements UserDao{

	@Override
	public boolean insert(User User) {
		String insertSQL = "insert into users (name, password, balance, dni, email, age, tlf, adress)" + "values (?, ?, ?, ?, ?, ?, ?, ?)";
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
