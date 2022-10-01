package com.nttdata.nttdatacentersdemoJunit1.services;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CustomMatcher;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nttdata.nttdatacentersdemoJunit1.bbdd.BaseDatosI;
import com.nttdata.nttdatacentersdemoJunit1.model.Articulo;

@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceImplTest {

	@InjectMocks
	private CarritoCompraServiceImpl carrito = new CarritoCompraServiceImpl();
	
	@Mock
	private BaseDatosI baseDatos;
	
	@Test
	void testLimpiarCesta() {
		carrito.limpiarCesta();
		assertTrue(carrito.getArticulos().isEmpty());
	}

	@Test
	void testAddArticulo() {
		assertTrue(carrito.getArticulos().isEmpty());
		carrito.addArticulo(new Articulo("Pantalon", 20D));
		assertFalse(carrito.getArticulos().isEmpty());
	}

	@Test
	void testGetNumArticulo() {
		carrito.addArticulo(new Articulo("Pantalon", 20D));
		carrito.addArticulo(new Articulo("Pantalon", 20D));
		Integer resultado  = carrito.getNumArticulo();
		assertEquals(2, resultado);
	}

	@Test
	void testGetArticulos() {
		carrito.addArticulo(new Articulo("Pantalon", 20D));
		carrito.addArticulo(new Articulo("Camisa", 30D));
		List<Articulo> listado = carrito.getArticulos();
		
		Matcher<List<Articulo>> listMatcher = new CustomMatcher<List<Articulo>>("") {
			
			@Override
			public boolean matches(Object argument) {
				if(argument == null || !List.class.isInstance(argument)) {
					return false;
				}
				boolean equals = true;
				List<Articulo> lista = (List<Articulo>) argument;
				equals &= lista.get(0).getNombre().equals("Pantalon");
				equals &= lista.get(0).getPrecio().equals(20D);
				equals &= lista.get(0).getNombre().equals("Camisa");
				equals &= lista.get(0).getPrecio().equals(30D);
				return equals;
			}
		};
		//assertThat(listado, listMatcher);
		assertEquals(2, listado.size());
		assertEquals("Camisa", listado.get(1).getNombre());
	}

	@Test
	void testGetArticulosBBDD() {
		List<Articulo> listado = new ArrayList<>();
		listado.add(new Articulo("Pantalon", 20D));
		listado.add(new Articulo("Camisa", 30D));
		listado.add(new Articulo("Zapatos", 40D));
		when(baseDatos.getArticulos()).thenReturn(listado);
		List<Articulo> lista = baseDatos.getArticulos();
		assertEquals(3, listado.size());
	}
	
	@Test
	void testTotalPrice() {
		carrito.addArticulo(new Articulo("Pantalon", 20D));
		carrito.addArticulo(new Articulo("Camisa", 30D));
		Double resultado = carrito.totalPrice();
		assertEquals(50, resultado);
	}

	@Test
	void testCalculadorDescuento() {
		Double resultado = carrito.calculadorDescuento(20D, 10D);
		assertEquals(18, resultado);
	}
	
	@Test
	void testAplicarDescuento() {
		
		Articulo articulo = new Articulo("Pantalon", 20D);
		when(baseDatos.getArticuloById(1)).thenReturn(articulo);
		Double resultado = carrito.aplicarDescuento(1, 10D);
		assertEquals(18, resultado);
		verify(baseDatos).getArticuloById(1);
	}

	@Test
	void testInsertarArticuloBBDD() {
		Articulo articulo = new Articulo("Calcetines", 40D);
		
		when(baseDatos.insertarArticulo(articulo)).thenReturn(1);
		//Comprobar que el ID recibido es correcto
		Integer idProductoIsertado = carrito.insertarArticuloBBDD(articulo);
		assertEquals(1, idProductoIsertado);
		//Comprobar que la cesta tiene el producto añadido
		assertEquals(articulo, carrito.cesta.get(0));
		//Comprobar que se ha llamado al método insertar artículo de BaseDatos al menos una vez
		verify(baseDatos, atLeast(1)).insertarArticulo(articulo);
	}
	
}

