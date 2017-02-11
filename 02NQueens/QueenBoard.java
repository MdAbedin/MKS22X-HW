public class QueenBoard{
    private int[][]board;
    private int solutionCount = -1;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	solveH(0);
    }

    private void wait(int ms){
	try{
	    Thread.sleep(ms);
	}
	catch(Exception e){
	    
	}
    }
    
    private boolean solveH(int col){
	if(col == board.length){
	    return true;
	}

	for(int row = 0; row < board.length; row++){
	    if(isValid(row, col)){
		placeQueen(row, col);
		System.out.println(this);
		wait(100);
		
		if(solveH(col+1)){
		    return true;
		}
		else{
		    removeQueen(row, col);
		}
	    }
	}

	return false;
    }

    private boolean isValid(int row, int col){
	return board[row][col] == 0;
    }
    
    private void placeQueen(int row, int col){
	for(int y = 0; y < board.length; y++){
	    for(int x = 0; x < board.length; x++){
		int xDif = col - x;
		int yDif = row - y;
		if(Math.abs(xDif*yDif) == 0 || Math.abs(xDif*yDif) == xDif * xDif){
		    board[y][x] += 1;
		}
	    }
	}
	
	board[row][col] = -1;
    }

    private void removeQueen(int row, int col){
	for(int y = 0; y < board.length; y++){
	    for(int x = 0; x < board.length; x++){
		int xDif = col - x;
		int yDif = row - y;
		if(Math.abs(xDif*yDif) == 0 || Math.abs(xDif*yDif) == xDif * xDif){
		    board[y][x] -= 1;
		}
	    }
	}
	
	board[row][col] = 0;
    }

    private void clearBoard(){
	for(int y = 0; y < board.length; y++){
	    for(int x = 0; x < board.length; x++){
		board[y][x] = 0;
	    }
	}
    }

    private void countH(int col){
	if(col == board.length){
	    solutionCount++;
	    return;
	}

	for(int row = 0; row < board.length; row++){
	    if(isValid(row, col)){
		placeQueen(row, col);
		countH(col+1);
		removeQueen(row, col);
	    }
	}
    }
    
    public void countSolutions(){
	solutionCount = 0;

	countH(0);
    }
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	clearBoard();
	return solutionCount;
    }
    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	System.out.print("\033[2J");
    	String b = "";
	for(int[] r: board){
	    for(int c: r){
		if(c == -1){
		    System.out.print("Q");
		}
		else{
		    System.out.print("_");
		}
	    }
	    System.out.print("\n");
	}

	return b;
    }
}
