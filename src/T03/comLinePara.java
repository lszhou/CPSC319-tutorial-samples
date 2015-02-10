package T03;

public class comLinePara {

	public static void main(String[] args) {
		if (args[0].equals("-h"))
			System.out.println("hello, ");
		else if (args[0].equals("-g"))
			System.out.println("goodbye, ");
		
		for(int i=1; i<args.length; i++)
			System.out.println(" " + args[i]);
	}

}
