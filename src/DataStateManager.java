import java.util.ArrayList;
import java.util.Scanner;
/*
 * Created 2016 Andrew Spano
 * Handles the manipulation of data in the actual program
 */

public class DataStateManager {
	private static final int INITIAL_DATA_SIZE = 30000;
	
	private ArrayList<Integer> data; //represents brainfuck data array
	private int dataPointer;  //points to the index of the data array that all operations will manipulate until the pointer changes index
	private Scanner sc; //for getting input from user instruction
	
	public DataStateManager() {
		this.data = new ArrayList<Integer>(INITIAL_DATA_SIZE);  //All brainfuck programs must have access to a byte array of at least 30,000
		
		//Need to initialize, since I discovered that array list of integers does not initialize to zero by default 
		for(int i = 0; i < INITIAL_DATA_SIZE; i++) {
			data.add(new Integer(0));
		}
		this.dataPointer = 0;
	}
	
	public void increment() {
		/*
		 * Add one to the value of the active cell
		 */
		//Integer value = data.get(dataPointer);
		//value = value + 1;  doesn't work because value is auto casted to primitive int instead of reference
		
		data.set(dataPointer, data.get(dataPointer) + 1);
		System.out.println("Value " + data.get(dataPointer));
	}
	
	public void decrement() {
		/*
		 * subtract one from the value of the active cell
		 */
		
		data.set(dataPointer, data.get(dataPointer) - 1);
	}
	public void shiftPointerRight() {
		/*
		 * shift the data pointer right one cell
		 */
		dataPointer += 1;
	}
	
	public void shiftPointerLeft() {
		/*
		 * shift the data pointer left one cell
		 */
		dataPointer -= 1;
	}
	public void printCellValue() {
		/*
		 * print value of cell to stdout.  MUST BE CHAR
		 */
		
		//System.out.println((char) data.get(dataPointer));  can't do direct cast from Integer type to char, have to use int
		
		int value = data.get(dataPointer);
		
		System.out.println((char) value); 
	}
	
	public void inputCellValue() {
		/*
		 * get user input from stdin and input that value into the current cell as an integer 
		 */
		Scanner sc = new Scanner(System.in);
		String inputLine = sc.nextLine();
		sc.close();
		//ignore all input except for first character
		char input = inputLine.charAt(0);
		data.set(dataPointer, (int) input);
		
	}
	
	public static void main(String[] args) {
		/*
		 * main method for testing purposes, not for actual execution of program.
		 */
		DataStateManager dataManager = new DataStateManager();
		dataManager.increment();
		dataManager.printCellValue();
		
		dataManager.inputCellValue();
		dataManager.printCellValue();
	}

}
