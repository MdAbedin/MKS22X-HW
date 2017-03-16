import java.util.Random;

public class Quick{
    public static int part(int[] data, int start, int end){
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

    public static int quickselect(int []data, int k){
	int index = part(data, 0 , data.length-1);
	int start = 0;
	int end = data.length-1;
	
	while(index != k){
	    if(index < k){
		start = index+1;
		index = part(data, start, end);
	    }
	    else{
		end = index-1;
		index = part(data, start, end);
	    }
	}

	return data[index];
    }
    
    public static void main(String[] args){
	Quick q = new Quick();
	int[] a = {8,5,3,2,9,6,1,4,3,2};
	System.out.println(q.quickselect(a, 0));
	System.out.println(java.util.Arrays.toString(a));
    }
}
