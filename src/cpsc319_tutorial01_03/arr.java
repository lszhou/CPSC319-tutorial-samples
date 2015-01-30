package cpsc319_tutorial01_03;

public class arr {
	public static void main(String[] args) {

		long startTime = System.nanoTime();

		double x = Math.random() * Integer.MAX_VALUE;
		System.out.println(x);
		System.out.println((int) x);

		long endtime = System.nanoTime();
		long estimatedTime = endtime - startTime;
		System.out.println(estimatedTime);
	}
}
