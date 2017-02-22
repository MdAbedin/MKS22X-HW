public class Driver{
    public static void main(String[] args){
	for(int i = 16; i <= 50; i++){
	    for(int j = 16; j <= 50; j++){
		KnightBoard b = new KnightBoard(i,j);
		b.solveFast();
		System.out.println(i + " " + j);
	    }
	}
    }
}
