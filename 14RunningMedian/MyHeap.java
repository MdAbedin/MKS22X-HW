import java.util.NoSuchElementException;
import java.util.Random;

public class MyHeap{
    private Integer[] data =  new Integer[10];
    private int n = 1, size = 0;

    public MyHeap(){
	
    }

    public MyHeap(boolean b){
	if(!b) n = -1;
    }

    public void add(Integer s){
	if(size+1 == data.length) grow();
	
	data[size+1] = s;
	size++;
	pushUp();
    }

    public Integer remove(){
	if(size == 0) throw new NoSuchElementException();
	
	Integer old = data[1];
	data[1] = data[size];
	size--;
	pushDown();

	return old;
    }

    public Integer peek(){
	if(size == 0) throw new NoSuchElementException();
	
	return data[1];
    }

    private void pushUp(){
	int i = size;

	while(i != 1 && data[i].compareTo(data[findParent(i)]) * n > 0){
	    int p = findParent(i);
	    Integer temp = data[p];
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
		    Integer temp = data[c2];
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
		    Integer temp = data[c1];
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
        Integer[] grown = new Integer[size*2];

	for(int i = 1; i <= size; i++) grown[i] = data[i];
	
	data = grown;
    }

    public boolean check(){
	int i = size;

	while(i > 1){
	    if(data[i].compareTo(data[findParent(i)]) * n > 0) return false;
	    i--;
	}

	return true;
    }

    public int size(){
	return size;
    }
    
    public static void main(String[] args){
	MyHeap m = new MyHeap(false);
	Random rng = new Random();

	for(int i = 1; i < 100; i++) m.add(new Integer(rng.nextInt(i)));
	for(int i = 1; i < 10; i++) m.remove();
	for(int i = 1; i < 100; i++) m.add(new Integer(rng.nextInt(i)));
	
	System.out.println(m);
	System.out.println(m.check());
    }
}
