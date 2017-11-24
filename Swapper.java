// Aleksandra Koroza
//APCS1 pd8
//HW #38: Put It Together
//2017-11-21


import cs1.Keyboard;

public class Swapper{

	// Instance variable for created 2D array and String creation
	private String [][] arr;
	private String alphabet;
	private String used;


	// Default constructor; preset size of array (3x3)
	public Swapper(){
		arr= new String[3][3];
		alphabet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		used= "";


	}

	//populate 2D array with unique 3 character Strings
	public void populate(){
		for (int r=0; r< arr.length; r++){
			for(int c=0; c< arr[0].length; c++){
				String input = makeStr();

				arr[r][c]= makeStr();
			}
		}
	}

	//method for creating three character strings, and storing in comparison array
	public  String  makeStr(){
		String result="";
		int cnt = 0;

		while(cnt<3){
			int indexUsed= (int)((Math.random())*51);//wanted loss of precision
			result+= alphabet.substring(indexUsed,indexUsed+1);
			cnt+=1;
		}

		if (checkU(result)){
			makeStr();
		}

		used+=result;
		return result;

	}

	//method checks if three character string is unique
	public  boolean checkU(String s){
		if (used.indexOf(s)!= -1){
			return true;
		}
		return false;
	}

	//postcond: prints each row of 2D int array a on its own line uses a FOREACH loop
	public void print( ) {
		for(String[] r: arr){
			String row= "";
			for (String num: r){
				row+= num+ " ";
			}
			System.out.println(row);
		}
	}

	//method to swap items at user-specified locations
	public void swap(int r, int c, int r1, int c1){
		String oldValue = arr[r][c];
		arr[r][c] = arr[r1][c1];
		arr[r1][c1] = oldValue;
	}

	public static void main(String[] args){
		System.out.println("This application will swap values in the array based on your input.");

		Swapper swapperInstance = new Swapper();
		swapperInstance.populate();
		System.out.println("Original array:");
		System.out.println();
		swapperInstance.print();
		System.out.println();

		String input="";
		while( !input.equals("quit") ){
			System.out.print("Enter x: ");
			int x = Keyboard.readInt();
			System.out.print("Enter y: ");
			int y = Keyboard.readInt();
			System.out.print("Enter new x: ");
			int x1 = Keyboard.readInt();
			System.out.print("Enter new y: ");
			int y1 = Keyboard.readInt();

			swapperInstance.swap(x,y,x1,y1);

			System.out.println("New array:");
			System.out.println();
			swapperInstance.print();
			System.out.println();

			System.out.print("Press Space+Enter to repeat or 'quit' to terminate: ");
			input = Keyboard.readString();
		}
	}
}
