/*Aleksandra Koroza
APCS2 pd2
HW #21b: We Got a Little Ol’ Convoy...
2018-03-19
*/
/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 * If placed in current working dir, will be consulted instead of 
 * built-in Java library interface.
 *****************************************************/

public interface List
{ 

    //add node to list, containing input String as its data
    public boolean add( String x ); 

    //return data in element at position i
    public String get( int i ); 

    //overwrite data in element at position i
    public String set( int i, String x ); 

    //return length of list
    public int size(); 

}//end interface
