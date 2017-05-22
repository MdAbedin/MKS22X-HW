public class Location implements Comparable<Location>{
    private int row,col;
    private int distToGoal, distToStart;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int compareTo(Location other){
	if(aStar) return distToGoal+distToStart - (other.distToGoal + other.distToStart);
	else return distToGoal - other.distToGoal;
    }

    public static int dist(Location l, int r, int c){
	return Math.abs(l.getRow() - r) + Math.abs(l.getCol() - c);
    }

    public int getRow(){return row;}

    public int getCol(){return col;}

    public int getDistToGoal(){return distToGoal;}

    public int getDistToStart(){return distToStart;}

    public Location getPrevious(){return previous;}
    
    public boolean getAStar(){return aStar;}

    public void setAStar(boolean b){aStar = b;}
}
