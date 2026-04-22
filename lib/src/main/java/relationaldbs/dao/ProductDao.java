/**
 * 
 */
package relationaldbs.dao;

import relationaldbs.model.Productos;

/*
 *
 * @author Valenciano
 * 20 abr 2026
 */
public interface ProductDao {
	
	/**
	 * Inserta un producto en la tabla de la base de datos
	 * @param producto
	 * @return
	 */
	public boolean insert(Productos producto);
	
	/**
	 * elimina un producto de la tabla de la base de datos
	 * @param id
	 * @return
	 */
	public boolean delete(long id);
	
	/**
	 * actualiza la información de un producto ya existente en la tabla de la base de datos
	 * @param producto
	 */
	public void update(Productos producto);
	
	/**
	 * localiza un producto de la tabla de la base de datos buscándolo por su id
	 * @param id
	 * @return
	 */
	public Productos find(long id);

}
