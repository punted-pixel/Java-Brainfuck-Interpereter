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
		case '[':
			openBracket();
			break;
			
		case ']':
			closeBracket();
			break;
		}
	
	}

	public void openBracket() {  //TODO:  I need to think of a better name for this method
		/*
		 * Handles behavior for beginning of loop
		 */
		if(!dataStateManager.testLoop()) {
			codePointerStack.push(codePointer);
			
		}
		else {
			boolean isInInnerLoop = false;
			for(int i = codePointer+1; i < sourceText.length(); i++) {
				/*
				 * search for closing brace, ignoring any inner loops
				 */
			
				if(sourceText.charAt(i) == '[') {
					isInInnerLoop = true;
				}
				if(!isInInnerLoop) {
					if(sourceText.charAt(i) == ']') {
						codePointer = i;
						break;
					}
				}
				else if(sourceText.charAt(i) == ']') {
					isInInnerLoop = false;
					
				}
			}
		}
	}
	
	public void closeBracket() {
		/*
		 * Handles closed brackets signifying end of loop block
		 * if the memory cell is equal to 0 (false) jump to the position of the corresponding opening bracket.
		 * otherwise, forget that position and continue sequential execution of code at the next instruction
		 */
		if(!dataStateManager.testLoop()) {
			codePointer = codePointerStack.peek();
		}
		else {
			codePointerStack.pop();
		}
	}
	
	public void runExecutionLoop() {
		/*
		 * main loop for iterating through every brainfuck instruction and executing them
		 */
		while(codePointer < sourceText.length()) {
			System.out.println(dataStateManager.toString());
			executeInstruction();  //not sure if it would be better to make this method parameterized 
			stepInstruction();
		}
	}
	
	public static void main(String[] args) {
		/*
		 * For testing purposes only--not for actual execution of program
		 */
		CodeExecutionManager manager = new CodeExecutionManager("++++.");
		//manager.runExecutionLoop();
		
		manager = new CodeExecutionManager("[->+<]");
		manager.runExecutionLoop();
		manager = new CodeExecutionManager("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");
		//manager.runExecutionLoop();
	}
	
	
}

