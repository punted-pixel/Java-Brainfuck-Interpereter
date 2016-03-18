import java.util.Stack;

/*
 * Created by Andrew Spano, 2016
 * Handles the execution of the brain fuck program
 * including the location of the code pointer, and which instruction to execute next
 */
public class CodeExecutionManager {
	private String sourceText;
	private int codePointer; //keeps track of where in the code the program is
	private Stack<Integer> codePointerStack;
	
	public CodeExecutionManager(String sourceText) {
		this.sourceText = sourceText;
		this.codePointer = 0;
		this.codePointerStack = new Stack<Integer>();
	}
}
