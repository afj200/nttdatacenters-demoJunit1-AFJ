package com.nttdata.nttdatacentersdemoJunit1.model;

public class Articulo {

	//Nombre del articulo
	private String nombre;
	//Precio del articulo
	private Double precio;

	/**
	 * Método constructor de articulos.
	 * @param nombre
	 * @param precio
	 */
	public Articulo(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * Método obtener el nombre de un producto.
	 * 
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Método ewstablecer el nombre de un producto.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método obtener el precio de un producto.
	 * 
	 * @return Double
	 */
	public Double getPrecio() {
		return precio;
	}
	/**
	 * Método establecer el precio de un producto.
	 * @param precio
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
