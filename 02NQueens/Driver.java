public class Driver{
    public static void main(String[] args){
	QueenBoard Q = new QueenBoard(8);
	//Q.solve();
	//System.out.println(Q);


	Q.countSolutions();
	System.out.println(Q.getSolutionCount());
    }
}
