public class KnightBoard{
    public int[][] board;
    
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
    }
    
    public void solve(){
	if(!solveH(0, 0, 1)){
	    board[0][0] = 0;
	}
    }

    private boolean solveH(int row ,int col, int level){
	if(level == 1){
	    board[0][0] = 1;
	}
	
	if(level == board.length * board[0].length){
	    return true;
	}
	
	for(int i = 1; i < 9; i++){
	    int r = row + transformY(i);
	    int c = col + transformX(i);
		
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
    }

    private void removeKnight(int r, int c){
	board[r][c] = 0;
    }

    public String toString(){
	String s = "";
	
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] <= 9){
		    s += " ";
		}
		
		s += board[r][c] + " ";
	    }
	    
	    s += "\n";
	}

	return s;
    }
}
