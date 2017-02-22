import java.util.ArrayList;

public class KnightBoard{
    public int[][] board;
    public int[][] moves;
    
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	moves = new int[startingRows][startingCols];

	for(int r = 0; r < moves.length; r++){
	    for(int c = 0; c < moves[0].length; c++){
		for(int i = 1; i < 9; i++){
		    int y = r + transformY(i);
		    int x = c + transformX(i);
		    
		    if(isInBounds(y, x)){
			moves[r][c]++;
		    }
		}
	    }
	}
    }
    
    public void solveFast(){
	if(!solveH(0, 0, 1)){
	    board[0][0] = 0;
	}
    }

    private boolean solveH(int row ,int col, int level){
	if(level == 1){
	    placeKnight(0, 0, 1);
	}
	
	if(level == board.length * board[0].length){
	    return true;
	}

	ArrayList<Integer> m = bestMoves(row, col);
	for(int i = 0; i < m.size(); i++){
	    int r = row + transformY(m.get(i));
	    int c = col + transformX(m.get(i));

	    if(isValid(r, c)){
		placeKnight(r, c, level+1);
		if(solveH(r, c, level+1)){
		    return true;
		}
		else{
		    removeKnight(r, c);
		}
	    }
	}
	
	return false;
    }

    public ArrayList<Integer> bestMoves(int r, int c){
	ArrayList<Integer> m = new ArrayList<Integer>();

	for(int i = 0; i < 9; i++){
	    for(int j = 1; j < 9; j++){
		int y = r + transformY(j);
		int x = c + transformX(j);

		if(isInBounds(y, x) && moves[y][x] == i){
		    m.add(j);
		}
	    }
	}

	return m;
    }
    
    private int transformX(int n){
	return (n%2 + 1) * (-2 * (n/5) + 1);
    }

    private int transformY(int n){
	return (3 - (n%2 + 1)) * (-2 * (((n-1)%4)/2) + 1);
    }

    private boolean isInBounds(int r, int c){
	return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }
    
    private boolean isValid(int r, int c){
	return isInBounds(r, c) && board[r][c] == 0;
    }

    private void placeKnight(int r, int c, int level){
	board[r][c] = level;

	for(int i = 1; i < 9; i++){
	    int y = r + transformY(i);
	    int x = c + transformX(i);

	    if(isInBounds(y, x)){
		moves[y][x]--;
	    }
	}
    }

    private void removeKnight(int r, int c){
	board[r][c] = 0;
	
	for(int i = 1; i < 9; i++){
	    int y = r + transformY(i);
	    int x = c + transformX(i);

	    if(isInBounds(y, x)){
		moves[y][x]++;
	    }
	}
    }

    public String toString(){
	String s = "";
	
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		for(int i = 0; 1000 / Math.pow(10, i) > board[r][c]; i++){
		    s += " ";
		}
		
		s += board[r][c] + " ";
	    }
	    
	    s += "\n";
	}

	return s;
    }
}
