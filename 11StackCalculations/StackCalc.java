import java.util.Stack;

public class StackCalc{
    public static double eval(String input){
	Stack<String> s = new Stack<String>();
        String[] vals = input.split(" ");

	for(String v: vals){
	    if(isOp(v)){
		s.push((String)apply(s.pop(), s.pop(), v));
	    }
	    else{
		s.push(v);
	    }
	}
	
	return Double.parseDouble(s.pop());
    }

    private static String apply(String B, String A, String op){
        double b = Double.parseDouble(B);
        double a = Double.parseDouble(A);
	
	switch(op){
	case "+":
	    return a + b + "";
	case "-":
	    return a - b + "";
	case "*":
	    return a * b + "";
	case "/":
	    return a / b + "";
	case "%":
	    return a % b + "";
	default:
	    return "";
	}
    }
    
    private static boolean isOp(String s){
	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
    }
}
