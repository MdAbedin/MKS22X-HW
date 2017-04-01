import java.util.LinkedList;

public class Driver{
    public static void main(String[] args){
	MyLinkedList m = new MyLinkedList();
	
	for(int i = 0; i < 20; i++){
	    m.add(i,i);
	}

	System.out.println(m);
	m.add(0);
	System.out.println(m);
	System.out.println(m.get(4));
	m.set(4,5);
	System.out.println(m.get(4));
	System.out.println(m.indexOf(5));
	m.remove(m.size()-1);
	System.out.println(m.toString());
    }
}
