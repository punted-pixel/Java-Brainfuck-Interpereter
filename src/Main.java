import java.io.File;

/*
 * Created 2016 by Andrew Spano
 * 
 * responsible for initializing class hierarchy and starting the program
 */
public class Main {

	public static void main(String[] args) {
		File sourceFile = new File(args[0]);
		
		TextParser parser = new TextParser(sourceFile);
		CodeExecutionManager executionManager = new CodeExecutionManager(parser.getSourceText());
		
		executionManager.runExecutionLoop();

	}

}
