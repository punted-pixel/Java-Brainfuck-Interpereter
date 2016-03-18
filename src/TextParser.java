import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextParser {

	//private File file;
	
	private Scanner scanner;
	
	
	public TextParser(File file) {
		try {
			FileReader inputReader = new FileReader(file);
			scanner = new Scanner(inputReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
