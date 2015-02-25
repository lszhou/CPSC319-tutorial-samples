package T09;

public class compareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sampleObj[] arrT09 = new sampleObj[3];
		arrT09[0] = new sampleObj("Alice", 15);
		arrT09[1] = new sampleObj("Tom", 17);
		arrT09[2] = new sampleObj("Bob", 19);

		quickSort.quick(arrT09, 0, 2);
		for (int i = 0; i < 3; i++)
			arrT09[i].display();

	}
}
