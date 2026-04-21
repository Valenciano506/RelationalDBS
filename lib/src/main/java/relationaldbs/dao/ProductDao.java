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
	 * 
	 * @param producto
	 * @return
	 */
	public boolean insert(Productos producto);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(long id);
	
	/**
	 * 
	 * @param producto
	 */
	public void update(Productos producto);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Productos find(long id);

}
