package com.nttdata.nttdatacentersdemoJunit1.bbdd;

import java.util.List;

import com.nttdata.nttdatacentersdemoJunit1.model.Articulo;

public interface BaseDatosI {

	public void iniciarBBDD();
	
	public List<Articulo> getArticulos();
	
	public Articulo getArticuloById(Integer id);
	
	public Integer insertarArticulo(Articulo articulo);
}
