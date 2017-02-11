public class Driver{
    public static void main(String[] args){
	QueenBoard Q = new QueenBoard(7);
	Q.solve();
	//Q.countSolutions();
	
	System.out.println(Q);	
	System.out.println(Q.getSolutionCount());
    }
}
