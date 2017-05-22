import java.util.Stack;

public class FrontierStack implements Frontier{
    public Stack<Location> locations = new Stack<Location>();

    public void add(Location l){
	locations.push(l);
    }

    public Location next(){
	return locations.pop();
    }

    public boolean hasNext(){return locations.size() != 0;}
}
