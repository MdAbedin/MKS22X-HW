public class Recursion{
    public static String name(){
	return "Abedin,Md";
    }
    
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	else{
	    return helper(n, 1);
	}
    }

    public static double helper(double n, double guess){
	if(isCloseEnough(guess * guess, n)){
	    return guess;
	}
	else{
	    return helper(n, (n/guess + guess)/2);
	}
    }

    public static boolean isCloseEnough(double a, double b){
	return Math.abs(a - b) < 10e-9;
    }
}
