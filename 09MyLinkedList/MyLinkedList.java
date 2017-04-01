import java.lang.IndexOutOfBoundsException;

public class MyLinkedList{
    public LNode start;
    public int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public boolean add(int value){
	if(size == 0){
	    start = new LNode(value);
	}
	else{
	    LNode current = start;

	    while(current.next != null){
		current = current.next();
	    }
	
	    current.next = new LNode(value);	
	}

	size++;
	return true;
    }

    public String toString(){
	String s = "";
	
	if(size == 0){
	    s = "[]";
	}
	else{
	    LNode current = start;
	    s = "[" + current.getValue();
	    current = current.next();
	    
	    for(int i = 1; i < size; i++){
		s += ", " + current.getValue();
		current = current.next();
	    }

	    s += "]";
	}

	return s;
    }

    public int get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	LNode current = start;
	for(int i = 0; i < index; i++){
	    current = current.next();
	}

	return current.getValue();
    }

    public int set(int index, int newValue){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	LNode current = start;
	for(int i = 0; i < index; i++){
	    current = current.next();
	}

	int old = current.getValue();
	current.setValue(newValue);

	return old;

    }

    public int indexOf(int value){
	LNode current = start; 
	
	for(int i = 0; i < size; i++){
	    if(current.getValue() == value){
		return i;
	    }

	    current = current.next();
	}

	return -1;
    }

    public void add(int index, int value){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	if(index == size){
	    add(value);
	}
	else if(index == 0){
	    LNode n = new LNode(value);
	    n.setNext(start);
	    start = n;
	    size++;
	}
	else{
	    LNode current = start;
	    LNode n = new LNode(value);
	    LNode old = new LNode(0);
	
	    for(int i = 0; i < index; i++){
		if(i == index-1){
		    old = current;
		}

		current = current.next();
	    }

	    n.setNext(current);
	    old.setNext(n);
	    size++;
	}
    }

    public int remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	LNode current = start;
	int old = start.getValue();
	
	if(index == 0){
	    start = start.next();
	}
	
	for(int i = 0; i < index; i++){
	    if(i == index-1){
		old = current.next().getValue();
		current.setNext(current.next().next());
	    }

	    current = current.next();
	}

	size--;
	return old;
    }
    
    public int size(){
	return size;
    }
}
