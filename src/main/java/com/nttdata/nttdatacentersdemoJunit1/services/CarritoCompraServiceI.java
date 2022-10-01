package com.nttdata.nttdatacentersdemoJunit1.services;

import java.util.List;

import com.nttdata.nttdatacentersdemoJunit1.model.Articulo;

public interface CarritoCompraServiceI {

	public void limpiarCesta();
	
	public void addArticulo(Articulo a);
	
	public int getNumArticulo();
	
	public List<Articulo> getArticulos();
	
	public List<Articulo> getArticulosBBDD();
	
	public Double totalPrice();
	
	public Double calculadorDescuento(double precio, double porcentajeDescuento);
	
	public Double aplicarDescuento(Integer id, double descuento);
	
	public Integer insertarArticuloBBDD(Articulo articulo);
}
