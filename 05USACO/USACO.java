import java.util.*;
import java.io.*;

public class USACO{
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
    
    public char[][] field;
    public int time;
    public int solutions = 0;

    public void silverH(int r, int c, int r2, int c2, int t){
	if(t == 0 && r == r2 && c == c2){
	    solutions++;
	}
	
	for(int i = 1; i <= 4; i++){
	    int y = (i%2) * (2-i);
	    int x = ((i+1)%2) * (i-3);

	    if(isInField(r+y, c+x) && isValid(r+y, c+x) && t > 0){
		silverH(r+y, c+x, r2, c2, t-1);
	    }
	}
    }
    
    public boolean isInField(int r, int c){
	return r >= 0 && c >= 0 && r < field.length && c < field[0].length;
    }

    public boolean isValid(int r, int c){
	return field[r][c] == '.';
    }

    public int silver(String filename){
	try{
	    Scanner s = new Scanner(new File(filename));
	    field = new char[s.nextInt()][s.nextInt()];
	    time = s.nextInt();
	    s.nextLine();

	    for(int r = 0; r < field.length; r++){
		String row = s.nextLine();

		for(int c = 0; c < row.length(); c++){
		    field[r][c] = row.charAt(c);
		}
	    }

	    silverH(s.nextInt()-1, s.nextInt()-1, s.nextInt()-1, s.nextInt()-1, time);
	}
	catch(FileNotFoundException e){	    
	}
	
	return solutions;
    }
}
