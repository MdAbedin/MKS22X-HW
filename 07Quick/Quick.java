import java.util.Random;
import java.util.Arrays;

public class Quick{
    public static int part(int[] data, int start, int end){
	Random rng = new Random();
	int pivotIndex = start + rng.nextInt(end-start+1);
	int pivot = data[pivotIndex];
	data[pivotIndex] = data[start];
	data[start] = pivot;

	int greater = start+1;
	int less = start;
	int equal = end;
	
	for(int i = start+1; i <= end; i++){
	    if(data[i] < pivot){
		int high = data[greater];
		data[greater] = data[i];
		data[i] = high;

	        less = greater++;
	    }
	}
	
	data[start] = data[less];
	data[less] = pivot;

	return less;
    }

    public static int quickselect(int[] data, int k){
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

    public static void quicksort(int[] data){
	qsh(data, 0, data.length-1);
    }

    public static void qsh(int[] data, int start, int end){
	if(start >= end){
	    return;
	}
	
	int pivotIndex = part(data, start, end);

	qsh(data, start, pivotIndex-1);
	qsh(data, pivotIndex+1, end);
    }
    
    public static void main(String[] args){
	Quick q = new Quick();
	Random rng = new Random();
	
	for(int j = 0; j < 10; j++){
	    int[] a = new int[rng.nextInt(20+1)];
	    int[] b = new int[a.length];
	    
	    for(int i = 0; i < a.length; i++){
		a[i] = rng.nextInt(100)-50;
		b[i] = a[i];
	    }

	    q.quicksort(a);
	    Arrays.sort(b);

	    System.out.println(Arrays.toString(a));
	    System.out.println(Arrays.toString(b));
	    System.out.println("");

	    if(!Arrays.equals(a, b)){
		System.out.println("error");
	    }
	}
    }
}
