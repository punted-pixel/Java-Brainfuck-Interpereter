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
	private DataStateManager dataStateManager;
	
	public CodeExecutionManager(String sourceText) {
		this.sourceText = sourceText;
		this.codePointer = 0;
		this.codePointerStack = new Stack<Integer>();
		this.dataStateManager = new DataStateManager();
	}
	
	public void  stepInstruction() {
		/*
		 * set code pointer to the next instruction
		 */
		codePointer++;
	}
	
	public void executeInstruction() {
		char instruction = sourceText.charAt(codePointer);
		switch (instruction) {
		case '+':
			dataStateManager.increment();
			break;
		case '-':
			dataStateManager.decrement();
			break;
		case '>':
			dataStateManager.shiftPointerRight();
			break;
		case '<':
			dataStateManager.shiftPointerLeft();
			break;
		case '.':
			dataStateManager.printCellValue();
			break;
		case ',':
			dataStateManager.inputCellValue();
			break;
		
			
		}
	}
	
}

