

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.Stack.EmptyStackException;
import uy.edu.um.prog2.adt.Stack.MyStack;
import uy.edu.um.prog2.adt.Stack.Stack;
import uy.edu.um.prog2.adt.Stack.StackWArray;




public class TestStackWArray {

	@Test
	public void PushAndPopTest() {
		
		MyStack<Integer> stack =new  StackWArray <Integer>(10);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		try {
			int top1= stack.top();
			assertEquals(top1, 3);
			stack.pop();
			int top2=stack.top();
			assertEquals(top2,2);
			
		} catch (EmptyStackException e) {
		}
	}
		@Test
		public void makeAndIsEmptyTest() {
			
			MyStack<Integer> stack =new  Stack<>();
			
			stack.push(1);
			stack.push(2);
			stack.push(3);
			
			assertFalse(stack.isEmpty());
			stack.makeEmpty();
			assertTrue(stack.isEmpty());
			
		}
		
	

}


