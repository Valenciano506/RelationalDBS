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
		
		UserDao userDao = new UserDaoImpl();

        // ─────────────────────────────────────────
        // TEST INSERT
        // ─────────────────────────────────────────
        System.out.println("=== TEST INSERT ===");
        User newUser = new User("Carlos", "1234", 1200, 0, 51741555, "valenciano3192006@gmail.com", 19, 669862654, "Calle Santa María 1");
        boolean inserted = userDao.insert(newUser);
        System.out.println("Usuario insertado: " + inserted);

        // ─────────────────────────────────────────
        // TEST FIND POR EMAIL
        // ─────────────────────────────────────────
        System.out.println("\n=== TEST FIND POR EMAIL ===");
        User foundByEmail = userDao.find("valenciano3192006@gmail.com");
        if (foundByEmail != null) {
            System.out.println("Usuario encontrado por email: " + foundByEmail.getName() + " | ID: " + foundByEmail.getId());
        } else {
            System.out.println("No se encontró ningún usuario con ese email.");
        }

        // ─────────────────────────────────────────
        // TEST FIND POR ID
        // (usamos el id del usuario que acabamos de encontrar)
        // ─────────────────────────────────────────
        System.out.println("\n=== TEST FIND POR ID ===");
        if (foundByEmail != null) {
            long userId = foundByEmail.getId();
            User foundById = userDao.find(userId);
            if (foundById != null) {
                System.out.println("Usuario encontrado por ID: " + foundById.getName() + " | Email: " + foundById.getEmail());
            } else {
                System.out.println("No se encontró ningún usuario con ese ID.");
            }

            // ─────────────────────────────────────────
            // TEST UPDATE
            // ─────────────────────────────────────────
            System.out.println("\n=== TEST UPDATE ===");
            foundByEmail.setName("Carlos Actualizado");
            foundByEmail.setBalance(2000.0f);
            foundByEmail.setAdress("Calle Nueva 99");
            userDao.update(foundByEmail);
            
            // Verificamos que el update funcionó buscando de nuevo
            User updatedUser = userDao.find(userId);
            if (updatedUser != null) {
                System.out.println("Nombre actualizado: " + updatedUser.getName());
                System.out.println("Balance actualizado: " + updatedUser.getBalance());
                System.out.println("Dirección actualizada: " + updatedUser.getAdress());
            }

            // ─────────────────────────────────────────
            // TEST FIND ALL
            // ─────────────────────────────────────────
            System.out.println("\n=== TEST FIND ALL ===");
            java.util.List<User> allUsers = userDao.findAll();
            System.out.println("Total de usuarios en la tabla: " + allUsers.size());
            for (User u : allUsers) {
                System.out.println(" - [" + u.getId() + "] " + u.getName() + " | " + u.getEmail());
            }

            // ─────────────────────────────────────────
            // TEST DELETE
            // ─────────────────────────────────────────
            System.out.println("\n=== TEST DELETE ===");
            boolean deleted = userDao.delete(userId);
            System.out.println("Usuario eliminado: " + deleted);

            // Verificamos que el delete funcionó
            User deletedUser = userDao.find(userId);
            System.out.println("Búsqueda tras delete (debe ser null): " + deletedUser);
        }
		
	}

}