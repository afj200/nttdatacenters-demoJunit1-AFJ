package com.nttdata.nttdatacentersdemoJunit1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.nttdatacentersdemoJunit1.bbdd.BaseDatosI;
import com.nttdata.nttdatacentersdemoJunit1.model.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraServiceI{

	List<Articulo> cesta = new ArrayList<Articulo>();
	@Autowired
	private BaseDatosI baseDatos;
	
	@Override
	public void limpiarCesta() {
		
		cesta.clear();
		
	}

	@Override
	public void addArticulo(Articulo a) {
		
		cesta.add(a);
		
	}

	@Override
	public int getNumArticulo() {
		
		return cesta.size();
	}
	
	@Override
	public List<Articulo> getArticulos() {
		
		return cesta;
	}

	public List<Articulo> getArticulosBBDD() {
		baseDatos.iniciarBBDD();
		return baseDatos.getArticulos();
	}

	@Override
	public Double totalPrice() {
		Double precioFinal = 0D;
		for(Articulo articulo : cesta) {
			precioFinal = precioFinal + articulo.getPrecio();
		}
		return precioFinal;
	}

	@Override
	public Double calculadorDescuento(double precio, double porcentajeDescuento) {
		
		Double precioFinal = precio - (precio * (porcentajeDescuento / 100));
		return precioFinal;
	}

	@Override
	public Double aplicarDescuento(Integer id, double descuento) {
		
		Articulo articulo = baseDatos.getArticuloById(id);
		if(articulo != null) {
			
			return articulo.getPrecio() - (articulo.getPrecio() * (descuento / 100));
		}else {
			System.out.println("No se ha encontrado el articulo con ese Id.");
		}
		return null;
		
	}

	@Override
	public Integer insertarArticuloBBDD(Articulo articulo) {
		
		Integer idArticuloInsertado = baseDatos.insertarArticulo(articulo);
		
		cesta.add(articulo);
		
		return idArticuloInsertado;
		
	}
	

}
