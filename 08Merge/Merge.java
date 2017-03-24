import java.util.Arrays;
import java.util.Random;

public class Merge{
    public static void mergesort(int[] a){
	if(a.length <= 1){
	    return;
	}

	int mid = a.length/2;
	int[] l = copy(a, 0, mid);;
	int[] r = copy(a, mid, a.length);

	mergesort(l);
	mergesort(r);

	merge(l, r, a);
    }

    public static int[] copy(int[] a, int lo, int hi){
	int[] ans = new int[hi-lo];

	for(int i = lo; i < hi; i++){
	    ans[i-lo] = a[i];
	}

	return ans;
    }
    
    public static void merge(int[] l, int[] r, int[] a){
	int i = 0;
	int j = 0;
	
	for(int k = 0; k < a.length; k++){
	    if(i != l.length && (j == r.length || l[i] <= r[j])){
		a[k] = l[i];
		i++;
	    }
	    else{
		a[k] = r[j];
		j++;
	    }
	}
    }

    public static void main(String[] args){
	Random rng = new Random();

	for(int i = 0; i < 10; i++){
	    int[] a = new int[rng.nextInt(20)];
	    int[] b = new int[a.length];

	    for(int j = 0; j < a.length; j++){
		a[j] = rng.nextInt(100) - 50;
		b[j] = a[j];
	    }

	    Merge.mergesort(a);
	    Arrays.sort(b);

	    System.out.println(Arrays.toString(a));
	    System.out.println(Arrays.toString(b));
	    System.out.println("");
	    
	    if(!Arrays.equals(a, b)){
		System.out.println("Error");
	    }
	}
    }
}
