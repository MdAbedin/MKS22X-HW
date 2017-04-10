import java.util.NoSuchElementException;

public class MyDeque{
    String[] data = new String[10];
    int front = 5, back = 4;

    private boolean isFull(){
	return (back+1)%data.length == front && !isEmpty();
    }

    private boolean isEmpty(){
	return data[front] == null;
    }
    
    public void addFirst(String s){
	if(s == null){
	    throw new NullPointerException();
	}

	if(isFull()){
	    grow();
	}
	
	if(front == 0){
	    front = data.length;
	}

	front--;
	data[front] = s;
    }

    public void addLast(String s){
	if(s == null){
	    throw new NullPointerException();
	}

	if(isFull()){
	    grow();
	}
	
	if(back == data.length-1){
	    back = -1;
	}

	back++;
	data[back] = s;
    }

    public String removeFirst(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}

	String old = data[front];
	data[front] = null;
	front++;

	if(front == data.length){
	    front = 0;
	}
	
	return old;
    }

    public String removeLast(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	
	String old = data[back];
	data[back] = null;
        back--;

	if(back == -1){
	    back = data.length-1;
	}
	
	return old;
    }

    public String getFirst(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	
	return data[front];
    }

    public String getLast(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}

	return data[back];
    }

    public String toString(){
	if(front - back == 1){
	    return "[]";
	}
	
	String s = "[" + data[front];
	for(int i = front+1; i != back+1; i++){
	    if(i == data.length){
		i = 0;
	    }

	    s += ", " + data[i];
	}

	return s + "]";
    }

    private void grow(){
	int j = front;
	String[] copy = new String[data.length*2];
	
	for(int i = 0; i < data.length; i++){
	    if(j == data.length){
		j = 0;
	    }

	    copy[i] = data[j];
	    j++;
	}

	data = copy;
	front = 0;
	back = data.length/2-1;
    }
}
