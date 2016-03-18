/*
 * Created by Andrew Spano, 2016
 * Parses the text in the brain fuck source file and translates it into brain fuck instruction
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextParser {

	//private File file;
	
	private Scanner scanner;
	private String sourceText; //string containing the text in the brain fuck program
	
	
	public TextParser(File file) {
		this.sourceText = "";
		try {
			FileReader inputReader = new FileReader(file);
			this.scanner = new Scanner(inputReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		while(scanner.hasNextLine()) {
			this.sourceText += scanner.nextLine();
		}
	}
	
	public String getSourceText() {
		return sourceText;
	}
	
}
