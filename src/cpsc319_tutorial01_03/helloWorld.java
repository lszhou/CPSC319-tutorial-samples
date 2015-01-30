package cpsc319_tutorial01_03;

public class helloWorld {
	
	public static void main(String args[]) {
		String name = "world";
		int x = 3;
/*-------------------------------------------------*/		
		System.out.println("hello, world!");
		System.out.println();
		System.out.println("hello, " + "world~");
		System.out.println(x);
		/*void	println() 
	void	println(boolean x) 
	void	println(char x) 
	void	println(char[] x) 
	void	println(double x) 
	void	println(float x) 
	void	println(int x) 
	void	println(long x) 
	void	println(Object x) 
	void	println(String x) */
/*-------------------------------------------------*/			
		System.out.printf("hello, %s. ", name);	
		System.out.printf("Value of x is %d.",  x);
		System.out.printf("hello, %s. \n", name);
		System.out.printf("The line was teminated.\n");
/*%s, %c is called the conversion for printf.*/
/*-------------------------------------------------*/			
		System.out.print(x);
		System.out.print(name + "\n");
		System.out.print("*hello, world*");
  /*void	print(boolean b) 
	void	print(char c)
	void	print(char[] s) 
	void	print(double d) 
	void	print(float f) 
	void	print(int i) 
	void	print(long l) 
	void	print(Object obj)
	void	print(String s) */
	}
}
