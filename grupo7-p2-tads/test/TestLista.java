

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.Lista.PosInvalida;


public class TestLista {

	@Test
	public void listaEnlazadaTest() {

		List<String> lista = new LinkedList<>();

		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");

		try {
			String get2 = lista.get(2);
			String get0 = lista.get(0);
			assertEquals(get2, "3");
			assertEquals(get0, "1");
		} catch (PosInvalida e) {
			fail();
		}

	}

	@Test
	public void deleteTest() {
		List<String> lista = new LinkedList<>();

		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");

		try {
			lista.delete(0);
			String get0 = lista.get(0);
			assertEquals(get0, "2");
		} catch (PosInvalida e) {

			fail();
		}

		try {
			lista.delete(0);
			lista.delete(0);
			lista.delete(0);
			
		} catch (PosInvalida e) {
			fail();
		}
		
		try {
			lista.delete(0);
			fail();
		} catch (PosInvalida e) {
			
		}
	}
	
	@Test
	public void testIsOnList() {
		
		List<String> lista = new LinkedList<>();

		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		
		assertTrue(lista.isOnList("2"));
		assertFalse(lista.isOnList("6"));
	}
	
	@Test
	public void addFirstTest() {
		List<String> lista = new LinkedList<>();

		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		
		lista.addFirst("5");
		
		try {
			assertEquals(lista.get(0),"5");
		} catch (PosInvalida e) {
		}
	}
	
	@Test
	public void sizeTest() {
		List<String> lista = new LinkedList<>();

		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		
		assertEquals(lista.size(), 4);
		
		try {
			lista.delete(3);
		} catch (PosInvalida e) {
			
		}
		assertEquals(lista.size(), 3);
	}
	
	
}
