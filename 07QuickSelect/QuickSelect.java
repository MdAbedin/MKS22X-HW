import java.util.Random;

public class QuickSelect{
    int part(int[] data, int start, int end){
	Random rng = new Random();
	int pivotIndex = start + rng.nextInt(end-start+1);
	int pivot = data[pivotIndex];
	data[pivotIndex] = data[start];
	data[start] = pivot;

	int current = start+1;
	int last = start;

	for(int i = start+1; i <= end; i++){
	    if(data[i] < pivot){
		int high = data[current];
		data[current] = data[i];
		data[i] = high;

		last = current++;
	    }
	}
	
	data[start] = data[last];
	data[last] = pivot;

	return last;
    }

    public static void main(String[] args){
	QuickSelect q = new QuickSelect();
	int[] a = {8,5,3,2,9,6,1,4,3,2};
	System.out.println(q.part(a, 3, 8));
	System.out.println(java.util.Arrays.toString(a));
    }
}
