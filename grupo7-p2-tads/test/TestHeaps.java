

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import uy.edu.um.prog2.adt.Heap.HeapImpl;
import uy.edu.um.prog2.adt.Heap.HeapVacio;
import uy.edu.um.prog2.adt.Heap.MyHeap;



public class TestHeaps {

	@Test
	public void insertHeap() {
		MyHeap<Integer, String> heap = new HeapImpl<>(10, 1);
		heap.insert(50, "50");
		heap.insert(18, "18");
		heap.insert(20, "20");

		assertEquals(heap.get(), "50");
		heap.insert(55, "55");

		assertEquals(heap.get(), "55");
	}

	@Test
	public void deteleHeap() {
		MyHeap<Integer, String> heap = new HeapImpl<>(10, 1);
		heap.insert(50, "50");
		heap.insert(18, "18");
		heap.insert(20, "20");
		heap.insert(55, "55");
		try {
		heap.findAndDelete();

		assertEquals(heap.get(), "50");
		heap.findAndDelete();
		assertEquals(heap.get(), "20");
		heap.findAndDelete();
		assertEquals(heap.get(), "18");
		heap.findAndDelete();
		assertEquals(heap.get(),null);
		heap.findAndDelete();// lanzará la exepción ya que no quedan elementos en el heap
		fail();
		}catch(HeapVacio e){
			
			
		}
	}

}
