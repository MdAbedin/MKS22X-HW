public class RunningMedian{
    MyHeap max = new MyHeap(), min = new MyHeap(false);
    double median = 0;
    
    public RunningMedian(){
	
    }

    public void add(int n){
	if(n < getMedian()) max.add(new Integer(n));
	else min.add(new Integer(n));

	if(max.size() - min.size() == 2) min.add(max.remove());
	if(min.size() - max.size() == 2) max.add(min.remove());

	if(max.size() > min.size()) median = max.peek();
	else if(min.size() > max.size()) median = min.peek();
	else median = (max.peek() + min.peek())/2.0;
    }

    public double getMedian(){
	return median;
    }

    public static void main(String[] args){
	RunningMedian r = new RunningMedian();
	r.add(1);
	r.add(3);
	r.add(4);
	r.add(5);
	System.out.println(r.getMedian());
    }
}
