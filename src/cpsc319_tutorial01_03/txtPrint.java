package cpsc319_tutorial01_03;

import java.io.IOException;
import java.io.PrintWriter;

public class txtPrint {

	public static void main(String[] args) throws IOException{
		String hw = "hello, world!";	
		String relativePath = "myFile.txt";  
		String absoPath = "C:\\Users\\lszhou\\workspace\\myJava\\src\\cpsc319_tutorial01_03\\yourFile.txt";
		
		PrintWriter out1 = new PrintWriter(relativePath);
		PrintWriter out2 = new PrintWriter(absoPath);
		out1.println(hw);
		out2.println(hw);
		out1.close();
		out2.close();
	}

}
