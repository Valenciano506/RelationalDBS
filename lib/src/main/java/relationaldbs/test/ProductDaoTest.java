package relationaldbs.test;

import relationaldbs.dao.ProductDao;
import relationaldbs.dao.ProductDaoImpl;
import relationaldbs.model.Productos;

public class ProductDaoTest {

    public static void main(String[] args) {

        ProductDao productDao = new ProductDaoImpl();

        // ─────────────────────────────────────────
        // TEST INSERT
        // ─────────────────────────────────────────
        System.out.println("=== TEST INSERT ===");
        Productos newProducto = new Productos("Toyota Corolla", 15000L, 2020, 80000L, 122, "Rojo", 0);
        boolean inserted = productDao.insert(newProducto);
        System.out.println("Producto insertado: " + inserted);

        // ─────────────────────────────────────────
        // TEST FIND POR ID
        // Buscamos por el id que PostgreSQL ha asignado (ajusta el id si es necesario)
        // ─────────────────────────────────────────
        System.out.println("\n=== TEST FIND POR ID ===");
        Productos foundProducto = productDao.find(1L); // cambia el 1L por el id real asignado
        if (foundProducto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(" - ID: "     + foundProducto.getId());
            System.out.println(" - Modelo: " + foundProducto.getModel());
            System.out.println(" - Precio: " + foundProducto.getPrice());
            System.out.println(" - Año: "    + foundProducto.getYear());
            System.out.println(" - Kms: "    + foundProducto.getKms());
            System.out.println(" - CV: "     + foundProducto.getCv());
            System.out.println(" - Color: "  + foundProducto.getColor());
        } else {
            System.out.println("No se encontró ningún producto con ese ID.");
        }

        // ─────────────────────────────────────────
        // TEST UPDATE
        // ─────────────────────────────────────────
        System.out.println("\n=== TEST UPDATE ===");
        if (foundProducto != null) {
            foundProducto.setModel("Toyota Corolla GR");
            foundProducto.setPrice(18000L);
            foundProducto.setColor("Negro");
            productDao.update(foundProducto);

            // Verificamos que el update funcionó buscando de nuevo
            Productos updatedProducto = productDao.find(foundProducto.getId());
            if (updatedProducto != null) {
                System.out.println("Producto actualizado:");
                System.out.println(" - Modelo actualizado: " + updatedProducto.getModel());
                System.out.println(" - Precio actualizado: " + updatedProducto.getPrice());
                System.out.println(" - Color actualizado: "  + updatedProducto.getColor());
            }

            // ─────────────────────────────────────────
            // TEST DELETE
            // ─────────────────────────────────────────
            System.out.println("\n=== TEST DELETE ===");
            boolean deleted = productDao.delete(foundProducto.getId());
            System.out.println("Producto eliminado: " + deleted);

            // Verificamos que el delete funcionó
            Productos deletedProducto = productDao.find(foundProducto.getId());
            System.out.println("Búsqueda tras delete (debe ser null): " + deletedProducto);
        }
    }
}