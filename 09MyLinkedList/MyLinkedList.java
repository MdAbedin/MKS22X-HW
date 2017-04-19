import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    private class LNode{
	LNode next = null, prev = null;
	int value;
	
	public LNode(int value){
	    this.value = value;
	}
	
	public String toString(){
	    return value + "";
	}
    }

    private class MyLinkedListIterator implements Iterator<Integer>{
	LNode current = head;

	public boolean hasNext(){
	    return current != null;
	}

	public Integer next(){
	    if(hasNext()){
		LNode old = current;
		current = current.next;
	    
		return new Integer(old.value);
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
    LNode head = null, tail = null;
    int size = 0;
    
    public MyLinkedList(){
	
    }

    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator();
    }
    
    public int size(){
	return size;
    }
    
    private LNode getNthNode(int n){
	if(n < 0 || n > size){
	    throw new IndexOutOfBoundsException();
	}
	
	LNode current;

	if(n <= size/2){
	    current = head;

	    for(int i = 0; i < n; i++){
		current = current.next;
	    }
	}
	else{
	    current = tail;

	    for(int i = size-1; i > n; i--){
		current = current.prev;
	    }
	}

	return current;
    }

    public String toString(){
	String s = "";
	
	if(size == 0){
	    s = "[";
	}
	else{
	    LNode current = head;
	    s = "[" + current.value;
	    current = current.next;
	    
	    for(int i = 1; i < size; i++){
		s += ", " + current.value;
		current = current.next;
	    }
	}

	return s + "]";
    }

    public boolean add(int value){
	return add(size, value);
    }

    public boolean add(int index, int value){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	LNode L = new LNode(value);

	if(size == 0){
	    head = L;
	    tail = L;
	}
	else if(index == 0){
	    head.prev = L;
	    L.next = head;
	    head = L;
	}
	else if(index == size){
	    tail.next = L;
	    L.prev = tail;
	    tail = L;
	}
	else{
	    LNode N = getNthNode(index-1);
	    L.prev = N;
	    L.next = N.next;
	    N.next.prev = L;
	    N.next = L;
	}

	size++;
	return true;
    }
    
    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int value){
	if(index == size){
	    throw new IndexOutOfBoundsException();
	}

	LNode L = getNthNode(index);
	int old = L.value;
	L.value = value;
	
	return old;
    }

    public int indexOf(int value){	
	LNode current = head; 
	
	for(int i = 0; i < size; i++){
	    if(current.value == value){
		return i;
	    }

	    current = current.next;
	}

	return -1;
    }

    public int remove(int index){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	int old;

	if(size == 1){
	    old = head.value;
	    head = null;
	    tail = null;
	}
	else if(index == 0){
	    old = head.value;
	    head = head.next;
	    head.prev = null;
	}
	else if(index == size-1){
	    old = tail.value;
	    tail = tail.prev;
	    tail.next = null;
	}
	else{
	    LNode L = getNthNode(index);
	    old = L.value;
	    L.prev.next = L.next;
	    L.next.prev = L.prev;
	}

	size--;
	return old;
    }
}
