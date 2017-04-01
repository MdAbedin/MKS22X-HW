public class LNode{
    public int value;
    public LNode next;

    public LNode(int value){
	this.value = value;
	next = null;
    }
    
    public void setValue(int value){
	this.value = value;
    }

    public int getValue(){
	return value;
    }

    public LNode next(){
	return next;
    }

    public void setNext(LNode l){
	next = l;
    }
}
