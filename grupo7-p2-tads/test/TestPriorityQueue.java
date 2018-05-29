

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.Queue.EmptyQueueException;
import uy.edu.um.prog2.adt.Queue.MyPriotityQueue;
import uy.edu.um.prog2.adt.Queue.PriorityQueue;




public class TestPriorityQueue {

	@Test
	public void EqueueAndGetTest() {
		
		MyPriotityQueue<Integer> priorityQueue= new PriorityQueue<>();
		
		
		priorityQueue.enqueue(1);
		priorityQueue.insert(2,20);
		priorityQueue.insert(5, 1);
		priorityQueue.insert(3, 7);
		priorityQueue.enqueue(6);
		
		int first;
		try {
			first = priorityQueue.getFirst();
			assertEquals(first, 2);
		} catch (EmptyQueueException e) {
			fail();
		}
		
		try {
			priorityQueue.dequeue();
			int first2= priorityQueue.getFirst();
			assertEquals(first2,3);
			priorityQueue.dequeue();
			int first3=priorityQueue.getFirst();
			assertEquals(first3,5);
			priorityQueue.dequeue();
			int first4= priorityQueue.getFirst();
			assertEquals(first4,1);
		} catch (EmptyQueueException e) {
			fail();
		}
		
	}
	
	@Test
	public void sizeTest() {
		MyPriotityQueue<Integer> priorityQueue= new PriorityQueue<>();
		
		
		priorityQueue.enqueue(1);
		priorityQueue.insert(2,20);
		priorityQueue.insert(3, 1);
		priorityQueue.insert(3, 7);
		priorityQueue.enqueue(6);
		
		int size= priorityQueue.size();
		assertEquals(size, 5);
		
		//priorityQueue.dequeue();
		
	}

}
