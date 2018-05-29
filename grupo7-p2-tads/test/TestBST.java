

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import uy.edu.um.prog2.adt.Lista.PosInvalida;
import uy.edu.um.prog2.adt.SearchTree.BinaryTree;
import uy.edu.um.prog2.adt.SearchTree.InvalidKey;
import uy.edu.um.prog2.adt.SearchTree.MyBinarySearchTree;



public class TestBST {

	
	@Test
	public void SearchAndDelete() {
		MyBinarySearchTree<Integer, String> myTree = new BinaryTree<Integer, String>();
		
		myTree.insert(5, "5");
		myTree.insert(2, "2");
		myTree.insert(10, "10");
		myTree.insert(3, "3");
		myTree.insert(1, "1");
		myTree.insert(7, "7");
		myTree.insert(11, "11");
		
		assertEquals(myTree.find(5),"5");
		assertEquals(myTree.find(11),"11");
	
		
	
		
		
		try {
		System.out.println(myTree.inOrder().get(0));
		System.out.println(myTree.inOrder().get(1));
		System.out.println(myTree.inOrder().get(2));
		System.out.println(myTree.inOrder().get(3));
		System.out.println(myTree.inOrder().get(4));
		System.out.println(myTree.inOrder().get(5));
		System.out.println(myTree.inOrder().get(6));

		
		}catch(PosInvalida e) {
			fail("Hubo un error");
		}
		
		try {
			myTree.delete(10);
		} catch (InvalidKey e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(myTree.inOrder().get(0));
			System.out.println(myTree.inOrder().get(1));
			System.out.println(myTree.inOrder().get(2));
			System.out.println(myTree.inOrder().get(3));
			System.out.println(myTree.inOrder().get(4));
			System.out.println(myTree.inOrder().get(5));
		
          try {
			myTree.delete(6);
			fail();
		} catch (InvalidKey e) {
			
		}
			
			}catch(PosInvalida e) {
				fail("Hubo un error");
			}
	}
	
	
	//Prueba
	
	
}
