package T10;

public class StackTest {
	public static void main(String[] args){
		
		//Test the LinkedList implementation of Stack. 
		LinkedStack<String> linkedstack = new LinkedStack<>();
		linkedstack.push("This");
		linkedstack.push("is");
		linkedstack.push("CPSC 319!");
		
		System.err.println(linkedstack.peek());
		System.out.println(linkedstack.pop());
		System.out.println(linkedstack.peek());
		
		System.out.println(linkedstack.empty());
		
		
		
	}

}
