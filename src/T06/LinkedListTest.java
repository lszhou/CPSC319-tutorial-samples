package T06;

public class LinkedListTest {

	public static void main(String[] args) {
		SingleLinkedList<String> slist = new SingleLinkedList<String>();
		slist.addFirst("C");
		slist.addFirst("B");
		slist.addFirst("A");

		System.out.println("We construct a brand new linked list:");
		slist.display();

		slist.remove("B");
		System.out.println("After B is removed we get a new one:");
		slist.display();
		
		slist.addLast("D");
		System.out.println("Add D after C we get:");
		slist.display();
		
		slist.insertAfter("C", "Tom");
		System.out.println("Insert Tom after C we get:");
		slist.display();	

	}

}
