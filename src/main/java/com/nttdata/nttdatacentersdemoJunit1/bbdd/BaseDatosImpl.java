package com.nttdata.nttdatacentersdemoJunit1.bbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nttdata.nttdatacentersdemoJunit1.model.Articulo;

@Service
public class BaseDatosImpl implements BaseDatosI{

	private Map<Integer, Articulo> baseDatos;
	@Override
	public void iniciarBBDD() {
		
		baseDatos = new HashMap<>();
		baseDatos.put(1, new Articulo("Pantalon", 20D));
		baseDatos.put(2, new Articulo("Camisa", 30D));
		baseDatos.put(3, new Articulo("Zapatos", 50D));
		baseDatos.put(4, new Articulo("Gorra", 10D));
		
	}
	
	public List<Articulo> getArticulos(){
		List<Articulo> listaArticulos = new ArrayList<>();
		for(Map.Entry<Integer, Articulo> entry : baseDatos.entrySet()) {
			listaArticulos.add(entry.getValue());
		}
		return listaArticulos;
		
	}

	public Articulo getArticuloById(Integer id) {
		return baseDatos.get(id);
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		
		baseDatos.put(baseDatos.size() + 1, articulo);
		return baseDatos.size();
	}
}
