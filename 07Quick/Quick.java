import java.util.Random;
import java.util.Arrays;

public class Quick{
    public static int part(int[] data, int start, int end){
	Random rng = new Random();
	int pivotIndex = start + rng.nextInt(end-start+1);
	int pivot = data[pivotIndex];
	data[pivotIndex] = data[end];
	data[end] = pivot;

	int current = start;
	int equal = end-1;
	
	for(int i = start; i <= equal; i++){
	    if(data[i] < pivot){
		if(current != i){
		    int next = data[current];
		    data[current] = data[i];
		    data[i] = next;
		}

		current++;
	    }
	    if(data[i] == pivot){
		if(data[equal] != data[i]){
		    data[i] = data[equal];
		    data[equal] = pivot;
		}

		equal--;
		i--;
	    }
	}

	pivotIndex = current + (end - equal)/2;

	for(int i = end; i > equal; i--){
	    if(data[current] == pivot){
	        break;
	    }
	    
	    data[i] = data[current];
	    data[current] = pivot;
	    current++;
	}

	return pivotIndex;
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
