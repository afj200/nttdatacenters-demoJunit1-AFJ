package com.nttdata.nttdatacentersdemoJunit1.services;

import java.util.List;

import com.nttdata.nttdatacentersdemoJunit1.model.Articulo;

public interface CarritoCompraServiceI {

	/**
	 * Método para limpiar la cesta (lista de productos)
	 */
	public void limpiarCesta();
	
	/**
	 * Método para añadir artículo al carrito.
	 * 
	 * @param Articulo
	 */
	public void addArticulo(Articulo a);
	
	/**
	 * Méltodo para obtener el número de productos del carrito.
	 * 
	 * @return Integer
	 */
	public int getNumArticulo();
	
	/**
	 * Método para obtener los artículos del carrito.
	 * 
	 * @return List<Articulo>
	 */
	public List<Articulo> getArticulos();
	
	/**
	 * Método para obtener los artículos del carrito de la BBDD.
	 * 
	 * @return List<Articulo>
	 */
	public List<Articulo> getArticulosBBDD();
	
	/**
	 * Método para calcular el preico total de los productos del carrito.
	 * 
	 * @return Double
	 */
	public Double totalPrice();
	
	/**
	 * Método para calcular un descuento sobre un precio.
	 * 
	 * @param precio
	 * @param porcentajeDescuento
	 * @return Double
	 */
	public Double calculadorDescuento(double precio, double porcentajeDescuento);
	
	/**
	 * Método para obtener el precio descontado de un producto.
	 * 
	 * @param id
	 * @param descuento
	 * @return Double
	 */
	public Double aplicarDescuento(Integer id, double descuento);
	
	/**
	 * Mñetodo para insertar un producto en la BBDD.
	 * 
	 * @param articulo
	 * @return Integer 
	 */
	public Integer insertarArticuloBBDD(Articulo articulo);
}
