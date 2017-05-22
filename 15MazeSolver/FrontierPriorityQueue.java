public class FrontierPriorityQueue implements Frontier{
    public MyPriorityQueue locations = new MyPriorityQueue(false);
    
    public void add(Location l){
	locations.add(l);
    }

    public Location next(){
	return locations.remove();
    }

    public boolean hasNext(){return locations.size() != 0;}
}
