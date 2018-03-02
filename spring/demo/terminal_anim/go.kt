Aleksandra Koroza
APCS2 pd2 
HW #12: __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-02-29

	Q0: What do you make of the multiple class definitions in a single .java file?
	I was surprised to see both class Demo and Boardasaurus defined in a single .java file. Neither of the class definitions feature the key word public, so that may be why several classes can be found. The code compiles, so this is a valid thing to do.  What is the purpose of a separate class for the driver method as opposed to the board setup/moves? Does the reason have to do with easier manipulation of code? 

	Q1: How are the command line arguments processed?
	Command line arguments are processed using try and catch exceptions. Command line arguments are used to set the size of the board, and to set a default size if none provided. They are also used to set the delay time of the board. The code accesses a specific value from the command line using args[0] or args[1]. Helper method delay also helps with try/catch. Thread.sleep() delays execution by given n ms.

	Q2: What happens if no command line arguments are given?
	If no arguments are given, default values are used to prevent crashing. Board size is set to 8 and timeDelay is given to be 500.
	
        Q3: What is the nature/purpose of the recursion? Is it necessary for the animation?
	The purpose of the recursion is to facilitate the go method. Moves are incremented at each succesive and assigned to a random spot on the board. Although I am unsure whether the animation can be achieved without recursion, in this case it proves very useful as the values for row and column must be re-assigned repeatedly and set to the moves value.

	Q4: What do you expect to see when you run it?
	I expect to see a 2D array populated with -1 on the outer rim and zeroes on an inner square. The zeroes would change values to match moves in the go method.
        Q5: How long do you expect it to run?
	Default timeDelay is 500, which means that 500 ms pass in between each change to the board. Depending on the size of the board, the program will run for different times.

	Q6: What does ANSI stand for? (You are permitted some intertubes searching here…). What is it good for?
	It stands for American National Standards Institute. The organization develops technology standards in the U.S. As used in this code, ANSI is used for manipulations of the terminal space (such as clearing screen, moving a cursor, etc.)

	Q7: How did your expectations compare to your observations?
	My expectations were similar to my observations, however I did not expect the smooth change of the board space. Clearing screen and time delay relays makes the board seem alive. 

	Q8: How might you adapt this framework to animate a probing for a Knight’s Tour?
	This framework would be very useful in animating a Knight's Tour. The go method can be modified as to use my algorithm for the journey. It would be very useful to see the animation play out with my algorithm, rather than drawing tons of chessboards on paper. This would allow for an easier catching of mistakes/ getting a better idea of what's going on.

Algo:

After starting at upper-leftmost corner, placing first knight (although any spot would be fine):

if the number of moves reached the size limit of the board {
       	      exit out of the program
	      }

else {
1. Scan the area around the current knight and place at first possible spot.
2. Repeat Step 1 until
   a) Move limit reached and Knight's Tour completed
   b) no more spots are available. In this case, remove current knight and place at different possible spot (Step 1) until Knight's Tour completed. (recursively finding the solution)
}