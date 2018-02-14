/*
Aleksandra Koroza
APCS2 pd2
HW07 -- A Man, A Plan, A Canal: Panama!
2018-02-13
*/

public class Reverser{

    /*reverse a String...
e.g., "stressed"  ->  "desserts"
in
a) O(n) time
b) O(log2n) time
     */

    //a) O(n) time
    public static String linearRev(String str){
	String result= "";
	for (int i = str.length()-1; i>=0; i--){
	    result+= Character.toString(str.charAt(i));
	}
	return result;
    }

    //b) O(log2n) time
    //similar to mergesort; adapted for String type
    public static String logRev(String str){

	//if string length is 1, then can be concatenated
	if ( str.length() <= 1 )
	    return str;

	//else, halve str and recurse on each half
	int leftLen = str.length() / 2;
	String leftHalf = str.substring(0,leftLen);
	String rightHalf = str.substring(leftLen);

	return logRev(rightHalf)+ logRev(leftHalf);
    }
    



    public static void main (String[] args){

	//testing linear reverser
	String s1= "doggy";
	String s2= "ala kazam";
	String s3= "stressed";
	String s4= "rof lol";

	System.out.println("---------testing O(n) reverser ---------");
	System.out.println(linearRev(s1));
	System.out.println(linearRev(s2));
	System.out.println("---------                      ---------");

	//testing log(n) reverser

	System.out.println("---------testing O(log2n) reverser ---------");
	System.out.println(logRev(s3));
	System.out.println(logRev(s4));
	System.out.println("---------                      ---------");

    }

}
