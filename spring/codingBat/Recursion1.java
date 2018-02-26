// from codingbat.com
public class Recursion1{

    /* 1 
      Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).


      factorial(1) → 1
      factorial(2) → 2
      factorial(3) → 6
    */

    public static int factorial(int n) {

	if (n== 0){
	    return 1;
	}

	else if (n==1){
	    return 1;
	}

	else {return n* factorial(n-1);}
		 }

    /* 2
       We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).


       bunnyEars(0) → 0
       bunnyEars(1) → 2
       bunnyEars(2) → 4
    */

    public static int bunnyEars(int n){
	if (n==0){return 0;}
	else if (n==1){return 2;}
	else{return 2+ bunnyEars(n-1);}
    }


    /* 3
      The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.


      fibonacci(0) → 0
      fibonacci(1) → 1
      fibonacci(2) → 1
    */
    public static int fibonacci(int n) {
	if (n<=1){return n;}
	return fibonacci(n-2)+fibonacci(n-1);
    }
    

    /* 4
      We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).


      bunnyEars2(0) → 0
      bunnyEars2(1) → 2
      bunnyEars2(2) → 5
    */
    public static int bunnyEars2(int n){
	if (n==0){return 0;}
	else if (n%2==1){
	    return 2+ bunnyEars2(n-1);
	}
	else{
	    return 3+ bunnyEars2(n-1);
	}}
       
    /* 5
       We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.


       triangle(0) → 0
       triangle(1) → 1
       triangle(2) → 3
    */
    public static int triangle(int rows) {
	if (rows==0){return 0;}
	else if (rows==1){return 1;}
	else{return triangle(rows-1)+ rows;}
    }


    /* 6
       Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).


       sumDigits(126) → 9
       sumDigits(49) → 13
       sumDigits(12) → 3
    */
    public static int sumDigits(int n) {
	if (n%10==n){return n;}
	else {return n%10 + sumDigits(n/10);}
        
    }

    /* 7
       Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).


       count7(717) → 2
       count7(7) → 1
       count7(123) → 0
    */
    public static int count7(int n) {
	if(n%10==n){
	    if (n==7){return 1;}
	    else {return 0;}
	}
	else {
	    if (n%10==7){return 1 + count7(n/10);}
	    else {return count7(n/10);}
	}
    }

    /* 8
       Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).


       count8(8) → 1
       count8(818) → 2
       count8(8818) → 4
    */
    public static int count8(int n) {
	if(n%10==n){
	    if (n==8){return 1;}
	    else {return 0;}
	}
	else{
	    if (n%10==8){
		if ((n/10)%10 == 8){return 2 + count8(n/10);}
		else {return 1 + count8(n/10);}
	    }
	    else {return count8(n/10);}
	    
	}
    }

    /* 9
      Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).


      powerN(3, 1) → 3
      powerN(3, 2) → 9
      powerN(3, 3) → 27
    */
    public static int powerN(int base, int n) {
	if (n==0 || n==1){return base;}
	else {return base * powerN(base,n-1);}
    }

    /* 10
       
       Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.


       countX("xxhixx") → 4
       countX("xhixhix") → 3
       countX("hi") → 0
    */
    public static int countX(String str) {
	if (str.length()==1) {
	    if (str.equals("x")){return 1;}
	    else {return 0;}
	}

	else {
	    if (str.substring(str.length()-1).equals("x")){
		return (1+ countX(str.substring(0,str.length()-1)));
	    }
	    else {return countX(str.substring(0,str.length()-1));}
	}
    }


    /* 11
	   
       Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.


       countHi("xxhixx") → 1
       countHi("xhixhix") → 2
       countHi("hi") → 1
    */
    public static int countHi(String str) {
	if (str.length()< 3){
	    if (str.equals("hi")){return 1;}
	    else {return 0;}}

	else {
	    if(str.substring(str.length()-2).equals("hi")){
		return 1 + countHi(str.substring(0,str.length()-1));
	    }
	    else {return countHi(str.substring(0,str.length()-1));}
	}}

	/* 12
	   Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.


changeXY("codex") → "codey"
changeXY("xxhixx") → "yyhiyy"
changeXY("xhixhix") → "yhiyhiy"
     */
    public static String changeXY(String str) {
	if (str.length()<2) {
	    if (str.equals("x")){return "y";}
	    else {return str;}
	}

	else {
	    if (str.substring(str.length()-1).equals("x")){
		return (changeXY(str.substring(0,str.length()-1)) + "y");
	    }
	    else {return changeXY(str.substring(0,str.length()-1))+str.substring(str.length()-1);}
	}
    }

    /* 13
       Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".


       changePi("xpix") → "x3.14x"
       changePi("pipi") → "3.143.14"
       changePi("pip") → "3.14p"
    */
    public static String changePi(String str) {
	if (str.length()< 3){
	    if (str.equals("pi")){return "3.14";}
	    else {return str;}}

	else {
	    if(str.substring(str.length()-2).equals("pi")){
		return changePi(str.substring(0,str.length()-1)) + "3.14" ;
	    }
	    else {return changePi(str.substring(0,str.length()-1))+ str.substring(str.length()-1);}
	}
    }

    /* 14
       Given a string, compute recursively a new string where all the 'x' chars have been removed.


       noX("xaxb") → "ab"
       noX("abc") → "abc"
       noX("xx") → ""
    */
    public static String noX(String str) {
	if (str.length()<2) {
	    if (str.equals("x")){return "";}
	    else {return str;}
	}

	else {
	    if (str.substring(str.length()-1).equals("x")){
		return (noX(str.substring(0,str.length()-1))+ "");
	    }
	    else {return noX(str.substring(0,str.length()-1)) + str.substring(str.length()-1);}
	}
    }
    /* 15
       Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.


       array6([1, 6, 4], 0) → true
       array6([1, 4], 0) → false
       array6([6], 0) → true
    */
    public static boolean array6(int[] nums, int index) {
    	if(nums.length==0) {return false;}
    	else if (index>=nums.length-1){
  	    if (nums[index]== 6){return true;}
  	    else {return false;}
  	}
  
  	else {
  	    if (nums[index]==6){return true;}
  	    else {return array6(nums, index+1);}
  	}
    }

    /* 16
       Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.


       array11([1, 2, 11], 0) → 1
       array11([11, 11], 0) → 2
       array11([1, 2, 3, 4], 0) → 0
    */
    public static int array11(int[] nums, int index) {
	if (index==nums.length-1){
	    if (nums[index]== 11){return 1;}
	    else {return 0;}
	}

	else {
	    if (nums[index]==11){return 1+ array11(nums, index+1);}
	    else {return array11(nums, index+1);}
	}
    }

    /* 17
      
      Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.


      array220([1, 2, 20], 0) → true
      array220([3, 30], 0) → true
      array220([3], 0) → false
    */
    public static boolean array220(int[] nums, int index) {
	if (index==nums.length-1){
	    //for array size 1
	    if (nums.length==1){return false;}
	    
	    else if (nums[index]== (nums[index-1]*10)){return true;}
	    else {return false;}
	}
	else {
	    //if (index==0){return array220(nums, index+1);}
	    if (index > 0 && nums[index]== nums[index-1]*10){return true;}
	    else {return array220(nums, index+1);}
	}
    }

    /* 18
       Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".


      allStar("hello") → "h*e*l*l*o"
      allStar("abc") → "a*b*c"
      allStar("ab") → "a*b"
    */
    public static String allStar(String str) {
	if(str.length() < 2)
	    {return str;}
	return str.charAt(0) + "*" + allStar(str.substring(1));
	    
    
    }

    /* 19
       
       Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".


       pairStar("hello") → "hel*lo"
       pairStar("xxyy") → "x*xy*y"
       pairStar("aaaa") → "a*a*a*a"
    */
    public static String pairStar(String str) {
	if(str.length() < 2)
	    {return str;}
	else if(str.charAt(0) == str.charAt(1))
	    { return str.charAt(0) + "*" + pairStar(str.substring(1));}
	else {return str.charAt(0) + pairStar(str.substring(1));}
    }
    //10 more to go~~~~
    /* 20
       Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.


       endX("xxre") → "rexx"
       endX("xxhixx") → "hixxxx"
       endX("xhixhix") → "hihixxx"
 
    */
    public static String endX(String str) {
	if (str.length()== 1){return str;}
	else if (str.charAt(0)=='x'){
	    return endX(str.substring(1))+ "x";
	}
	else {return str.charAt(0)+endX(str.substring(1));}
    }
    /* 21
       We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair. Pairs can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string.


       countPairs("axa") → 1
       countPairs("axax") → 2
       countPairs("axbx") → 1
    */
    public static int countPairs(String str) {
	if (str.length()<4){
	    if (str.charAt(0)== str.charAt(2)){
		return 1;
	    }
	    else {return 0;}
	}

	else {
	    if (str.charAt(str.length()-1)== str.charAt(str.length()-3)){
		return 1 + countPairs(str.substring(0,str.length()-1));
		
	    }
	    else {return countPairs(str.substring(0, str.length()-1));}
	}
    }

    /* 22
       Count recursively the total number of "abc" and "aba" substrings that appear in the given string.


       countAbc("abc") → 1
       countAbc("abcxxabc") → 2
       countAbc("abaxxaba") → 2
    */
    public static int countAbc(String str) {
	if (str.length()<4){
	    if (str.equals("abc") || str.equals("aba")){
		return 1;
	    }
	    else {return 0;}
	}
	else {
	    if (str.substring(str.length()-4,str.length()-1).equals("abc") || str.substring(str.length()-4,str.length()-1).equals("aba")){
		return 1 + countAbc(str.substring(0,str.length()-1));
		
	    }
	    else {return countAbc(str.substring(0, str.length()-1));}
	}
    }
    /* 23
      Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.


      count11("11abc11") → 2
      count11("abc11x11x11") → 3
      count11("111") → 1
    */
    public static int count11(String str) {
	if (str.length()<3){
	    if (str.equals("11")){return 1;}
	    else {return 0;}
	}

	else {
	    if (str.substring(str.length()-2).equals("11"))
		{return 1+ count11(str.substring(0,str.length()-2));}
	    else {return count11(str.substring(0,str.length()-1));}
	}
    }

    /* 24
      Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".


      stringClean("yyzzza") → "yza"
      stringClean("abbbcdd") → "abcd"
      stringClean("Hello") → "Helo"
    */
    public static String stringClean(String str) {
	if (str.length()<3){
	    if (str.charAt(0) == str.charAt(1)){return str.substring(0,1);}
	    else {return str;}
	}
	else {
	    if (str.charAt(str.length()-1) == str.charAt(str.length()-2)){
		return stringClean(str.substring(0,str.length()-1)+ str.charAt(str.length()-1));}
	    else {return stringClean(str.substring(0,str.length()-1));}}}
				   
		    
				   
				   

	/* 25
	   Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them.


	   countHi2("ahixhi") → 1
	   countHi2("ahibhi") → 2
	   countHi2("xhixhi") → 0
	*/
	public int countHi2(String str) {
	    return 1;
	}

	/* 26
	   Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".


	   parenBit("xyz(abc)123") → "(abc)"
	   parenBit("x(hello)") → "(hello)"
	   parenBit("(xy)1") → "(xy)"
    */
    public String parenBit(String str) {
	return "";
}
    /* 27
       Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.


       nestParen("(())") → true
       nestParen("((()))") → true
       nestParen("(((x))") → false
    */
    public boolean nestParen(String str) {
	return false;
    }

    /* 28
      Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.


      strCount("catcowcat", "cat") → 2
      strCount("catcowcat", "cow") → 1
      strCount("catcowcat", "dog") → 0
    */
    public int strCount(String str, String sub) {
	return 1;
}

    /* 29
       Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.


       strCopies("catcowcat", "cat", 2) → true
       strCopies("catcowcat", "cow", 2) → false
       strCopies("catcowcat", "cow", 1) → true
    */
    public boolean strCopies(String str, String sub, int n) {
	return false;
    }

    /* 30
       Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.


       strDist("catcowcat", "cat") → 9
       strDist("catcowcat", "cow") → 3
       strDist("cccatcowcatxx", "cat") → 9
    */
    public int strDist(String str, String sub) {
	return 1;
    }

    //you made it!





    public static void main(String[] args){
	System.out.println("-----------factorial------------");
	/*      factorial(1) → 1
		factorial(2) → 2
		factorial(3) → 6
	*/
	System.out.println(factorial(1));
	System.out.println(factorial(2));
	System.out.println(factorial(3));
	System.out.println("--------------------------------");
	
	System.out.println("-----------bunnyEars------------");
	/*
	  
	  bunnyEars(0) → 0
	  bunnyEars(1) → 2
	  bunnyEars(2) → 4
	*/
	System.out.println(bunnyEars(0));
	System.out.println(bunnyEars(1));
	System.out.println(bunnyEars(2));
	System.out.println("--------------------------------");

	System.out.println("-----------fibonacci------------");
	/*fibonacci(0) → 0
	  fibonacci(1) → 1
	  fibonacci(2) → 1*/
	System.out.println(fibonacci(0));
	System.out.println(fibonacci(1));
	System.out.println(fibonacci(2));
	System.out.println("--------------------------------");

	System.out.println("-----------bunnyEars2------------");
	System.out.println(bunnyEars2(2));
	System.out.println(bunnyEars2(0));
	System.out.println(bunnyEars2(1));
	System.out.println(bunnyEars2(3));
	System.out.println("--------------------------------");

	System.out.println("-----------triangle------------");
	/*
	  triangle(0) → 0
	  triangle(1) → 1
	  triangle(2) → 3
	*/
	System.out.println(triangle(0));
	System.out.println(triangle(1));
	System.out.println(triangle(2));
	System.out.println(triangle(3));
	System.out.println("--------------------------------");

	System.out.println("-----------sumDigits------------");
	/*
	  sumDigits(126) → 9
	  sumDigits(49) → 13
	  sumDigits(12) → 3
	*/
	System.out.println(sumDigits(126));
	System.out.println(sumDigits(49));
	System.out.println(sumDigits(12));
	//System.out.println(triangle(3));
	System.out.println("--------------------------------");

	System.out.println("-----------count7------------");
	/*
	  count7(717) → 2
	  count7(7) → 1
	  count7(123) → 0
	*/

	System.out.println(count7(717));
	System.out.println(count7(7));
	System.out.println(count7(123));
	System.out.println("--------------------------------");

	System.out.println("-----------count8------------");
	/*
	  count8(8) → 1
	  count8(818) → 2
	  count8(8818) → 4
	*/

	System.out.println(count8(8));
	System.out.println(count8(818));
	System.out.println(count8(8818));
	System.out.println("--------------------------------");

	System.out.println("-----------powerN------------");
	/*
	  powerN(3, 1) → 3
	  powerN(3, 2) → 9
	  powerN(3, 3) → 27
	*/

	System.out.println(powerN(3,1));
        System.out.println(powerN(3,2));
        System.out.println(powerN(3,3));
	System.out.println("--------------------------------");

	System.out.println("-----------countX------------");
	/*
	  countX("xxhixx") → 4
	  countX("xhixhix") → 3
	  countX("hi") → 0
	*/

	System.out.println(countX("xxhixx"));
        System.out.println(countX("xhixhix"));
        System.out.println(countX("hi"));
	System.out.println("--------------------------------");

	System.out.println("-----------countHi------------");
	/*
	  countHi("xxhixx") → 1
	  countHi("xhixhix") → 2
	  countHi("hi") → 1
	*/

	System.out.println(countHi("xxhixx"));
        System.out.println(countHi("xhixhix"));
        System.out.println(countHi("hi"));
	System.out.println("--------------------------------");

	System.out.println("-----------changeXY------------");
	/*

	  changeXY("codex") → "codey"
	  changeXY("xxhixx") → "yyhiyy"
	  changeXY("xhixhix") → "yhiyhiy"
	*/

	System.out.println(changeXY("codex"));
        System.out.println(changeXY("xxhixx"));
        System.out.println(changeXY("xhixhix"));
	System.out.println("--------------------------------");

	System.out.println("-----------changePi------------");
	/*
	  changePi("xpix") → "x3.14x"
	  changePi("pipi") → "3.143.14"
	  changePi("pip") → "3.14p"
	*/

	System.out.println(changePi("xpix"));
        System.out.println(changePi("pipi"));
        System.out.println(changePi("pip"));
	System.out.println("--------------------------------");

	System.out.println("-----------noX------------");
	/*
	  noX("xaxb") → "ab"
	  noX("abc") → "abc"
	  noX("xx") → ""
	*/

	System.out.println(noX("xaxb"));
        System.out.println(noX("abc"));
        System.out.println(noX("xx"));
	System.out.println("--------------------------------");

	System.out.println("-----------noX------------");
	/*
	  noX("xaxb") → "ab"
	  noX("abc") → "abc"
	  noX("xx") → ""
	*/

	System.out.println(noX("xaxb"));
        System.out.println(noX("abc"));
        System.out.println(noX("xx"));
	System.out.println("--------------------------------");

	System.out.println("-----------array6------------");
	/*
       array6([1, 6, 4], 0) → true
       array6([1, 4], 0) → false
       array6([6], 0) → true
	*/
	int[] a = {1,6,4};
	int[] b = {1,4};
	int[] c = {6};
	System.out.println(array6(a, 0));
        System.out.println(array6(b, 0));
        System.out.println(array6(c, 0));
	System.out.println("--------------------------------");

	System.out.println("-----------array11------------");
	/*
       array11([1, 2, 11], 0) → 1
       array11([11, 11], 0) → 2
       array11([1, 2, 3, 4], 0) → 0
	*/
	int[] d = {1,2,11};
	int[] e = {11,11};
	int[] f = {1,2,3,4};
	System.out.println(array11(d, 0));
        System.out.println(array11(e, 0));
        System.out.println(array11(f, 0));
	System.out.println("--------------------------------");

	System.out.println("-----------array220------------");
	/*
      array220([1, 2, 20], 0) → true
      array220([3, 30], 0) → true
      array220([3], 0) → false
	*/
	int[] x = {1,2,20};
	int[] y = {3,30};
	int[] z = {3};
	System.out.println(array220(x, 0));
        System.out.println(array220(y, 0));
        System.out.println(array220(z, 0));
	System.out.println("--------------------------------");

	System.out.println("-----------allStar------------");
	/*
	  allStar("hello") → "h*e*l*l*o"
	  allStar("abc") → "a*b*c"
	  allStar("ab") → "a*b"
	*/

	System.out.println(allStar("hello"));
        System.out.println(allStar("abc"));
        System.out.println(allStar("ab"));
	System.out.println("--------------------------------");

	System.out.println("-----------pairStar------------");
	/*
	  pairStar("hello") → "hel*lo"
	  pairStar("xxyy") → "x*xy*y"
	  pairStar("aaaa") → "a*a*a*a"
	*/

	System.out.println(pairStar("hello"));
        System.out.println(pairStar("xxyy"));
        System.out.println(pairStar("aaaa"));
	System.out.println("--------------------------------");

	System.out.println("-----------endX------------");
	/*
       endX("xxre") → "rexx"
       endX("xxhixx") → "hixxxx"
       endX("xhixhix") → "hihixxx"
	*/

	System.out.println(endX("xxre"));
        System.out.println(endX("xxhixx"));
        System.out.println(endX("xhixhix"));
	System.out.println("--------------------------------");

	System.out.println("-----------countPairs------------");
	/*
	  countPairs("axa") → 1
	  countPairs("axax") → 2
	  countPairs("axbx") → 1
	*/

	System.out.println(countPairs("axa"));
        System.out.println(countPairs("axax"));
        System.out.println(countPairs("axbx"));
	System.out.println("--------------------------------");

	System.out.println("-----------count11------------");
	/*
      count11("11abc11") → 2
      count11("abc11x11x11") → 3
      count11("111") → 1
	*/

	System.out.println(count11("11abc11"));
        System.out.println(count11("abc11x11x11"));
        System.out.println(count11("111"));
	System.out.println("--------------------------------");

	System.out.println("-----------stringClean------------");
	/*
	stringClean("yyzzza") → "yza"
	    stringClean("abbbcdd") → "abcd"
	    stringClean("Hello") → "Helo"
	*/

	System.out.println(stringClean("yyzzza"));
        System.out.println(stringClean("abbbcdd"));
        System.out.println(stringClean("Hello"));
	System.out.println("--------------------------------");



    }

}
