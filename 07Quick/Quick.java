import java.util.Random;
import java.util.Arrays;

public class Quick{
    public static void quicksort(int[] a){
	qsh(a, 0, a.length-1);
    }

    public static void qsh(int[] a, int lo, int hi){
	Random rng = new Random();
	
	if(lo >= hi){
	    return;
	}
	
	int pivotIndex = lo + rng.nextInt(hi-lo+1);
	int pivot = a[pivotIndex];
	swap(a, pivotIndex, lo);
	
	int lt = lo;
	int i = lo;
	int gt = hi;
	
	while(i <= gt){
	    if(a[i] == pivot){
		i++;
	    }
	    else if(a[i] < pivot){
		swap(a, i, lt);
		lt++;
		i++;
	    }
	    else{
		swap(a, i, gt);
		gt--;
	    }
	}
	
	qsh(a, lo, lt-1);
	qsh(a, gt+1, hi);
    }

    public static int part(int[] a, int lo, int hi){
	Random rng = new Random();
	
	int pivotIndex = lo + rng.nextInt(hi-lo+1);
	int pivot = a[pivotIndex];
	swap(a, pivotIndex, lo);
	
	int lt = lo;
	int i = lo;
	int gt = hi;
	
	while(i <= gt){
	    if(a[i] == pivot){
		i++;
	    }
	    else if(a[i] < pivot){
		swap(a, i, lt);
		lt++;
		i++;
	    }
	    else{
		swap(a, i, gt);
		gt--;
	    }
	}

	return (lt + gt)/2;
    }
    
    public static int quickselect(int[] a, int k){
	int index = part(a, 0, a.length-1);
	int start = 0;
	int end = a.length-1;
	
	while(index != k){
	    if(index < k){
		start = index+1;
		index = part(a, start, end);
	    }
	    else{
		end = index-1;
		index = part(a, start, end);
	    }
	}

	return a[index];
    }
    
    public static void swap(int[] a, int i, int j){
	int copy = a[i];
	a[i] = a[j];
	a[j] = copy;
    }
    
    public static void main(String[] args){
	Random rng = new Random();

	for(int j = 0; j < 10; j++){
	    int[] a = new int[rng.nextInt(20+1)+1];
	    int[] b = new int[a.length];
	    
	    for(int i = 0; i < a.length; i++){
		a[i] = rng.nextInt(100)-50;
		b[i] = a[i];
	    }
	    
	    int k = rng.nextInt(a.length);
	    int e = Quick.quickselect(a, k);
	    
	    Quick.quicksort(a);
	    Arrays.sort(b);

	    System.out.println(Arrays.toString(a));
	    System.out.println(Arrays.toString(b));
	    System.out.println("");
	    
	    if(!Arrays.equals(a, b) || b[k] != e){
		System.out.println("error");
	    }
	}
    }
}
