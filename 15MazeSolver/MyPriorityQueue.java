import java.util.NoSuchElementException;

public class MyPriorityQueue{
    private Location[] data =  new Location[10];
    private int n = 1, size = 0;
    
    public MyPriorityQueue(){
	
    }

    public MyPriorityQueue(boolean b){
	if(!b) n = -1;
    }

    public void add(Location s){
	if(size+1 == data.length) grow();
	
	data[size+1] = s;
	size++;
	pushUp();
    }

    public Location remove(){
	if(size == 0) throw new NoSuchElementException();
	    
	Location old = data[1];
	data[1] = data[size];
	size--;
	pushDown();

	return old;
    }

    public Location peek(){
	if(size == 0) throw new NoSuchElementException();
	
	return data[1];
    }

    private void pushUp(){
	int i = size;

	while(i != 1 && data[i].compareTo(data[findParent(i)]) * n > 0){
	    int p = findParent(i);
	    Location temp = data[p];
	    data[p] = data[i];
	    data[i] = temp;
	    i = p;
	}
    }

    private void pushDown(){
	int i = 1;

	while(findChildOne(i) <= size){
	    if(findChildTwo(i) <= size && data[findChildTwo(i)].compareTo(data[findChildOne(i)]) * n > 0){
		if(data[i].compareTo(data[findChildTwo(i)]) * n < 0){
		    int c2 = findChildTwo(i);
		    Location temp = data[c2];
		    data[c2] = data[i];
		    data[i] = temp;
		    i = c2;
		}
		else{
		    break;
		}
	    }
	    else{
		if(data[i].compareTo(data[findChildOne(i)]) * n < 0){
		    int c1 = findChildOne(i);
		    Location temp = data[c1];
		    data[c1] = data[i];
		    data[i] = temp;
		    i = c1;
		}
		else{
		    break;
		}
	    }
	}
    }

    private int findParent(int i){
	return i/2;
    }

    private int findChildOne(int i){
	return 2*i;
    }

    private int findChildTwo(int i){
	return 2*i + 1;
    }

    public String toString(){
	return java.util.Arrays.toString(data);
    }

    private void grow(){
	Location[] grown = new Location[size*2];

	for(int i = 1; i <= size; i++) grown[i] = data[i];
	
	data = grown;
    }

    public boolean check(){
	int i = size;

	while(i > 1){
	    if(data[i].compareTo(data[findParent(i)]) * n > 0) return false;;
	    i--;
	}

	return true;
    }

    public int size(){return size;}
}
