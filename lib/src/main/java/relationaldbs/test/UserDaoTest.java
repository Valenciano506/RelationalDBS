package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImpl;
import relationaldbs.model.User;

/*
 *
 * @author Valenciano
 * 14 abr 2026
 */
public class UserDaoTest {
	
	public static void main(String[] args) {
		//insert test
		UserDao userDao = new UserDaoImpl();
		userDao.insert(new User(null, null, 0, 0, 0, null, 0, 0, null));
	}

}
