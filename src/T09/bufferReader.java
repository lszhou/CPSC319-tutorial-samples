package T09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class bufferReader {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = null;

		File file = new File("sample.txt"); //sample.txt is located at current workspace.
		reader = new BufferedReader(new FileReader(file));

		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		reader.close();

	}

}
