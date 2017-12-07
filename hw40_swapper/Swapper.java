// Aleksandra Koroza
//APCS1 pd8
//HW #40: Make it better
//2017-11-21

/*
This short program creates a 2D array of a specified size and populates it with 3 character strings, which are generated randomly. The three character strings are generated through the use of the Math.random() method to choose a random index in a string full of both lowercase and uppercase letters. Each generated string is also checked for uniqueness. This is done by concatenating a string with all the used combinations of letters and checking whether a newly generated string is part of the 'used' string.

The interactive portion of the program prompts the user to specify the size of the array, as well as the two locations. The elements at these two locations are then swapped and a message is printed to signify a switch. Color is used as a cool feature~~. The program stops if the user inputs 'quit'. If not, the user may keep swapping values.

Next steps: creating strings of length 3 or 4.
             applying color to indicate swap

Version 2: Added message to indicate swap. Added row and column numbers. Made sure user inputs only valid indices. Added overloaded contructor to create any size arrays.
 */
import cs1.Keyboard;

public class Swapper{

	// Instance variable for created 2D array and String creation
    static String [][] arr;
    private String alphabet;
    private String used;
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";



    // Default constructor; preset size of array (3x3)
    public Swapper(){
	arr= new String[4][4];
	alphabet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	used= "";


    }

    // overloaded constructor to specify size of array
    public Swapper(int r, int c){
	this();
	arr= new String[r+1][c+1];
    }

    //populate 2D array with unique 3 character Strings
    public void populate(){
	for (int r=1; r< arr.length; r++){
	    for(int c=1; c< arr[0].length; c++){
		String input = makeStr();

		arr[r][c]= makeStr();
	    }
	}
	for (int r=1; r<arr[0].length;r++){
	    arr[0][r]= " "+ ANSI_CYAN +Integer.toString(r)+ANSI_RESET+" ";
	}

	for (int c=0; c<arr.length;c++){
	    arr[c][0]= ANSI_CYAN+Integer.toString(c)+ANSI_RESET;
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

		used+=result+",";//necessary to separate individual entries
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
				row+=  num+ " ";
				
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
		System.out.println("--------");
		//indicating dimensions of array
		System.out.println("Please specify array size:");
		System.out.println("Number of rows (a value > 1):");
		int r= Keyboard.readInt();
		
		while (r<=1){
	          System.out.println("Please input a value greater than 1");
		  r= Keyboard.readInt(); 
		    }
		    
		System.out.println("Number of columns (a value > 1):");
		int c= Keyboard.readInt();

		while (c<=1){
		    System.out.println("Please input a value greater than 1");
		    c= Keyboard.readInt();
		}

		//creating swapper instance based on user input

		Swapper swapperInstance = new Swapper(r,c);
		swapperInstance.populate();

		System.out.println("Original array:");
		System.out.println();
		swapperInstance.print();
		System.out.println();

		String input="";
		while( !input.equals("quit") ){
		    System.out.print("Enter row (of value to swap): ");
		    int x = Keyboard.readInt();
		    while (x<1 || x>arr.length-1){
			System.out.println("Please enter a valid index");
			x= Keyboard.readInt();
		    }

		    System.out.print("Enter column (of value to swap): ");
		    int y = Keyboard.readInt();
		      while (y<1 || y>arr[0].length-1){
			System.out.println("Please enter a valid index");
			y= Keyboard.readInt();
		    }

		    System.out.print("Enter row (of target location): ");
		    int x1 = Keyboard.readInt();
		     while (x1<1 || x1>arr.length-1){
			System.out.println("Please enter a valid index");
			x1= Keyboard.readInt();
		    }

		     System.out.print("Enter column (of target location): ");
		    int y1 = Keyboard.readInt();
		     while (y1<1 || y1>arr[0].length-1){
			System.out.println("Please enter a valid index");
			y1= Keyboard.readInt();
		    }

		    swapperInstance.swap(x,y,x1,y1);

		    System.out.println();
		    System.out.println("Here is your new array:");
		    System.out.println();
		    swapperInstance.print();
		    System.out.println();
		    System.out.println("Characters at locations "+x+","+y+" and "+x1+","+y1+" were switched!");
		    System.out.println();
		    System.out.print("Press Space+Enter to repeat or 'quit' to terminate: ");
		    input = Keyboard.readString();
		}
	}
}
