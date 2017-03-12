import java.util.*;
import java.io.*;

public class USACO{

    public USACO(){

    }
    
    public int[][] pasture;
    public int lakeLevel;

    public void stomp(int r, int c, int d){
	r--;
	c--;

	int[] max = findMax(r, c);
	pasture[max[0]][max[1]] -= d;
	if(pasture[max[0]][max[1]] < 0){
	    pasture[max[0]][max[1]] = 0;
	}
	
	for(int y = r; y < r+3; y++){
	    for(int x = c; x < c+3; x++){
		if(isInPasture(y, x) && pasture[y][x] > pasture[max[0]][max[1]]){
		    pasture[y][x] = pasture[max[0]][max[1]];
		}
	    }
	}
    }

    public boolean isInPasture(int r, int c){
	return r >= 0 && c >= 0 && r < pasture.length && c < pasture[0].length;
    }

    public int[] findMax(int r, int c){
	int max = pasture[r][c];
	int row = r;
	int col = c;
	
	for(int y = r; y < r+3; y++){
	    for(int x = c; x < c+3; x++){
		if(isInPasture(y, x) && pasture[y][x] > max){
		    max = pasture[y][x];
		    row = y;
		    col = x;
		}
	    }
	}

	int[] ans = {row, col};
	return ans;
    }
    
    public int bronze(String filename){
	try{
	    Scanner s = new Scanner(new File(filename));
	    pasture = new int[s.nextInt()][s.nextInt()];
	    lakeLevel = s.nextInt();
	    s.nextInt();

	    for(int r = 0; r < pasture.length; r++){
		for(int c = 0; c < pasture[0].length; c++){
		    pasture[r][c] = s.nextInt();
		}
	    }
	    
	    while(s.hasNextInt()){
		stomp(s.nextInt(), s.nextInt(), s.nextInt());
	    }

	    int water = 0;
	    
	    for(int r = 0; r < pasture.length; r++){
		for(int c = 0; c < pasture[0].length; c++){
		    if(pasture[r][c] < lakeLevel){
			water += lakeLevel - pasture[r][c];
		    }
		}
	    }
	    
	    return water * 72 * 72;
	}
	catch(FileNotFoundException e){
	}

	return 0;

    }

    /////////////////////////////////////////////////////////////////////////////////////
    
    public int[][] field;
    public int solutions = 0;
    
    public void silverH(int r, int c, int r2, int c2, int t){
	field[r][c] = 1;

	for(int i = 0; i < t; i++){
	    travel();
	}

	solutions = field[r2][c2];
    }

    public void travel(){
	int[][] next = new int[field.length][field[0].length];
	
	for(int r = 0; r < field.length; r++){
	    for(int c = 0; c < field[0].length; c++){
		if(field[r][c] == 0){
		    for(int i = 1; i <= 4; i++){
			int y = r + (i%2) * (2-i);
			int x = c + ((i+1)%2) * (i-3);
			
			if(isInField(y, x) && isValid(y, x)){
			    next[r][c] += field[y][x];
			}
		    }
		}
		else if(field[r][c] == -1){
		    next[r][c] = -1;
		}
	    }
	}

	field = next;
    }
    
    public boolean isInField(int r, int c){
	return r >= 0 && c >= 0 && r < field.length && c < field[0].length;
    }

    public boolean isValid(int r, int c){
	return field[r][c] != -1;
    }

    public int silver(String filename){
	try{
	    Scanner s = new Scanner(new File(filename));
	    field = new int[s.nextInt()][s.nextInt()];
	    int time = s.nextInt();
	    s.nextLine();

	    for(int r = 0; r < field.length; r++){
		String row = s.nextLine();

		for(int c = 0; c < row.length(); c++){
		    if(row.charAt(c) == '*'){
			field[r][c] = -1;
		    }
		}
	    }

	    silverH(s.nextInt()-1, s.nextInt()-1, s.nextInt()-1, s.nextInt()-1, time);
	}
	catch(FileNotFoundException e){	    
	}
	
	return solutions;
    }
}
