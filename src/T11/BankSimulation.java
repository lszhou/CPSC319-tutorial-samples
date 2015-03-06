package T11;

import java.util.Random;

class BankSimulation {
	static Random rd = new Random();

	static int Option(int percents[]) {
		int i = 0, perc, choice = Math.abs(rd.nextInt()) % 100 + 1;
		for (perc = percents[0]; perc < choice; perc += percents[i + 1], i++)
			;
		return i;
	}

	public static void main(String args[]) {
		int[] arrivals = { 15, 20, 25, 10, 30 };
		int[] service = { 0, 0, 0, 10, 5, 10, 10, 0, 15, 25, 10, 15 };
		int[] clerks = { 0, 0, 0, 0 };
		int clerksSize = clerks.length;
		int customers, t, i, numOfMinutes = 100, x;
		double maxWait = 0.0, thereIsLine = 0.0, currWait = 0.0;
		LinkedQueue<Integer> simulQ = new LinkedQueue<>();
		for (t = 1; t <= numOfMinutes; t++) {
			System.out.print(" t = " + t);
			for (i = 0; i < clerksSize; i++)
				// after each minute subtract
				if (clerks[i] < 60) // at most 60 seconds from time
					clerks[i] = 0; // left to service the current
				else
					clerks[i] -= 60; // customer by clerk i;
			customers = Option(arrivals);
			for (i = 0; i < customers; i++) { // enqueue all new customers
				x = Option(service) * 10; // (or rather service time
				simulQ.enqueue(new Integer(x)); // they require);
				currWait += x;
			}
			// dequeue customers when clerks are available:
			for (i = 0; i < clerksSize && !simulQ.isEmpty();)
				if (clerks[i] < 60) {
					x = ((Integer) simulQ.dequeue()).intValue();
					// assign more than one customer
					clerks[i] += x; // to a clerk if service time
					currWait -= x; // is still below 60 sec;
				} else
					i++;
			if (!simulQ.isEmpty()) {
				thereIsLine++;
				System.out.println(" wait = " + ((long) (currWait / 6.0)) / 10.0);
				if (maxWait < currWait)
					maxWait = currWait;
			} else
				System.out.println(" wait = 0;");
		}
		System.out.println("\nFor " + clerksSize + " clerks, there was a line "
				+ thereIsLine / numOfMinutes * 100.0 + "% of the time;\n"
				+ "maximum wait time was " + maxWait / 60.0 + " min.");
	}
}