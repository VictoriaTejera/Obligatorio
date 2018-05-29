

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.Queue.EmptyQueueException;
import uy.edu.um.prog2.adt.Queue.MyQueue;
import uy.edu.um.prog2.adt.Queue.Queue;



public class TestQueue {

	@Test
	public void testEnqueueAndGetFirst() {

		MyQueue<Integer> queue = new Queue<>();

		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(6);

		try {
			int first = queue.getFirst();
			 assertEquals(first,2);
		} catch (EmptyQueueException e) {
			fail();
		}
		

	}
	
	@Test
	public void testDequeueAndIsEmpty() {
		MyQueue<Integer> queue = new Queue<>();

		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(6);

		assertFalse(queue.isEmpty());
		
		try {
			queue.dequeue();
			queue.dequeue();
			
		} catch (EmptyQueueException e) {
			fail();
		
		}
		
		assertFalse(queue.isEmpty());
		
		
		try {
			queue.dequeue();
		} catch (EmptyQueueException e) {
			fail();
		}
		
		assertTrue(queue.isEmpty());
		
	}

}
