/*==================================================
 Aleksandra Koroza 
APCS1 Pd 8
hw 48 Keep Guessing
2017-12-6

class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
        _lo= a;
	_hi= b;
	_guessCtr= 1;
	_target= (int) (Math.random()*(_hi-_lo) + _lo);
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
        if (_guessCtr==1){
	    System.out.println("Welcome to the Recursive Version of this game!");
	}


	System.out.println("Guess a number between " + _lo + " and "+ _hi +": ");
	int input = Keyboard.readInt();

	if (input > _target){
	    System.out.println("Too high my guy");
	    _hi=input-1;
	    _guessCtr+=1;

	    playRec();
	}

	if (input < _target){
	    System.out.println("Too low  my bro");
	    _lo= input+1;
	    _guessCtr+=1;

	    playRec();

	}
		

	if (input== _target){
	    System.out.println("Good job! The answer is "+ _target+". ");
	    System.out.println("It took you "+ _guessCtr+ " guesses to get it right!");
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	System.out.println("Welcome to the Iterative Version of this game!");
	System.out.println("Guess a number between " + _lo + " and "+ _hi +": ");

	int input = Keyboard.readInt();

	
	while(input!= _target){
	    if (input > _target){
		System.out.println("Too high my guy");
		_hi=input-1;

	        System.out.println("Guess a number between " + _lo + " and "+ _hi +": ");
		input = Keyboard.readInt();
	    }

	    if (input < _target){
		System.out.println("Too low  my bro");
		_lo= input+1;

	        System.out.println("Guess a number between " + _lo + " and "+ _hi +": ");
		input = Keyboard.readInt();
	    }
		

	    _guessCtr+=1;
	    }

	System.out.println("Good job! The answer is "+ _target+". ");
	System.out.println("It took you "+ _guessCtr+ " guesses to get it right!");
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	playRec();
	//playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
        
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
        
    }//end main

}//end class
