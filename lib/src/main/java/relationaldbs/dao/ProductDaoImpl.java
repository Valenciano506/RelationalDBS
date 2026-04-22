package relationaldbs.dao;

import relationaldbs.model.Productos;
import java.sql.*;


public class ProductDaoImpl implements ProductDao {

    private final static String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String username = "postgres";
    private final static String password = "admin";

    @Override
    public boolean insert(Productos producto) {
        String insertSQL = "INSERT INTO productos (modelo, precio, año, kms, cv, color) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps = conn.prepareStatement(insertSQL)) {

            ps.setString(1, producto.getModel());
            ps.setLong(2, producto.getPrice());
            ps.setInt(3, producto.getYear());
            ps.setLong(4, producto.getKms());
            ps.setInt(5, producto.getCv());
            ps.setString(6, producto.getColor());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String deleteSQL = "DELETE FROM productos WHERE id = ?";

        try (
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

            ps.setLong(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(Productos producto) {
        String updateSQL = "UPDATE productos SET model = ?, price = ?, year = ?, " +
                           "kms = ?, cv = ?, color = ? WHERE id = ?";

        try (
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps = conn.prepareStatement(updateSQL)) {

            ps.setString(1, producto.getModel());
            ps.setLong(2, producto.getPrice());
            ps.setInt(3, producto.getYear());
            ps.setLong(4, producto.getKms());
            ps.setInt(5, producto.getCv());
            ps.setString(6, producto.getColor());
            ps.setLong(7, producto.getId()); // WHERE id = ?
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Productos find(long id) {
        String findSQL = "SELECT * FROM productos WHERE id = ?";
        Productos producto = null;

        try (
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps = conn.prepareStatement(findSQL)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = mapResultSetToProducto(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    // Método auxiliar privado para mapear el ResultSet a un objeto Productos
    private Productos mapResultSetToProducto(ResultSet rs) throws SQLException {
        return new Productos(
            rs.getString("model"),
            rs.getLong("price"),
            rs.getInt("year"),
            rs.getLong("kms"),
            rs.getInt("cv"),
            rs.getString("color"),
            rs.getLong("id")
        );
    }
}