public class codingBat{


    public static int bunnyEars(int n){
	if (n==0){return 0;}
	else if (n%2==1){
	    return 2+ bunnyEars(n-1);
	}
	else{
	    return 3+ bunnyEars(n-1);
	}
       
    }

    public static void main(String[] args){
	System.out.println(bunnyEars(2));
	System.out.println(bunnyEars(0));
	System.out.println(bunnyEars(1));
	System.out.println(bunnyEars(3));
    }

}
