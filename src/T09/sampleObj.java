package T09;

/*Sample object with two fields, String name and int age;
 * implements Comparable;
 */
public class sampleObj implements Comparable<Object> {
	String name;
	int age;

	public sampleObj(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display() {
		System.out.println(name + " " + age);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		sampleObj s = (sampleObj) o;
		return name.compareTo(s.name);
	}

}
