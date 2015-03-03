package T10;

public class StackTest {
	public static void main(String[] args){
		
		//Test the LinkedList implementation of Stack. 
		System.out.println("-----LinkedList implementation of Stack-----");
		LinkedStack<String> linkedstack = new LinkedStack<>();
		linkedstack.push("This");
		linkedstack.push("is");
		linkedstack.push("CPSC 319!");
		
		System.out.println(linkedstack.peek());
		System.out.println(linkedstack.pop());
		System.out.println(linkedstack.peek());
		
		System.out.println(linkedstack.empty());
		
		//Test the Array implementation of stack;
		System.out.println("-----Array implementation of Stack-----");
		ArrayStack<String> arraystack = new ArrayStack<>();
		arraystack.push("That");
		arraystack.push("is");
		arraystack.push("CPSC 333 !");
		
		System.out.println(arraystack.peek());
		System.out.println(arraystack.pop());
		System.out.println(arraystack.peek());
		
		System.out.println(arraystack.empty());
 		
		
		
	}

}
