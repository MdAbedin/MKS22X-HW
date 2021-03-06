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
	if(n == 0){
	    return 0;
	}
	
	if(isCloseEnough(guess * guess, n)){
	    return guess;
	}
	else{
	    return helper(n, (n/guess + guess)/2);
	}
    }

    public static boolean isCloseEnough(double a, double b){
	if(a == 0.0){
	    return b < 0.00000000001;
	}
	if(b == 0.0){
	    return a < 0.00000000001;
	}

	return Math.abs(a - b)/a < 10e-9;
    }
}
