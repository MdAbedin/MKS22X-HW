public class Driver{
    public static void main(String[] args){
	USACO u = new USACO();

	if(args[0].equals("bronze")){
	    System.out.println(u.bronze(args[1]));
	}
	else if(args[0].equals("silver")){
	    System.out.println(u.silver(args[1]));
	}
    }
}
