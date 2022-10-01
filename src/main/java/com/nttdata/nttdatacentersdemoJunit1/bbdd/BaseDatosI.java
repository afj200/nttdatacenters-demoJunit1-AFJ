package com.nttdata.nttdatacentersdemoJunit1.bbdd;

import java.util.List;

import com.nttdata.nttdatacentersdemoJunit1.model.Articulo;

public interface BaseDatosI {

	/**
	 * Método para inicializar la BBDD.
	 */
	public void iniciarBBDD();
	
	/**
	 * Método que devuelve los articulos de la BBDD.
	 * 
	 * @return List<Articulo>
	 */
	public List<Articulo> getArticulos();
	
	/**
	 * Método obtener un articulo de la BBDD por su ID.
	 * 
	 * @param id
	 * @return Articulo
	 */
	public Articulo getArticuloById(Integer id);
	
	/**
	 * Método para insertar un articulo en la BBDD.
	 * 
	 * @param articulo
	 * @return Integer
	 */
	public Integer insertarArticulo(Articulo articulo);
}
