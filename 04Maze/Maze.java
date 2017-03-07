import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;

    public Maze(String filename){
	animate = false;

	try{
	    File infile = new File(filename);
	    Scanner inf = new Scanner(infile);
	    String text = inf.nextLine();
	    int n = text.length();

	    while(inf.hasNextLine()){
		text += inf.nextLine();
	    }

	    maze = new char[text.length()/n][n];
	    
	    for(int i = 0; i < text.length(); i++){
		maze[i/n][i%n] = text.charAt(i);
	    }

	    int Scount = text.length() - text.replace("S", "").length();
	    int Ecount = text.length() - text.replace("E", "").length();

	    if(Scount * Ecount != 1){
		System.out.println("Starts or ends are invalid");
		System.exit(0);
	    }
	}
	catch(FileNotFoundException e){
	    e.printStackTrace();
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

    public boolean solve(){
	int startx = 0, starty = 0;

	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		if(maze[r][c] == 'S'){
		    starty = r;
		    startx = c;
		}
	    }
	}
	
	maze[startx][starty] = ' ';
	return solve(startx, starty);
    }

    private boolean solve(int x, int y){
	if(maze[y][x] == 'E'){
	    return true;
	}
	else{
	    maze[y][x] = 'X';
	}
	
	//display();
	
	for(int i = 1; i <= 4; i++){
	    int r = (i%2) * (2-i);
	    int c = ((i+1)%2) * (i-3);
	    
	    if(isValid(y+r, x+c) && solve(x+c, y+r)){
		maze[y][x] = '@';

		//display();
		
		return true;
	    }
	}

	maze[y][x] = '.';
	display();
	
	return false;
    }

    private boolean isValid(int r, int c){
	return maze[r][c] == ' ' || maze[r][c] == 'E';
    }

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String s = "";
	
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
	        s += maze[r][c];
	    }
	    s += "\n";
	}

	return s;
    }

    public void display(){
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(100);
	}
    }
}
