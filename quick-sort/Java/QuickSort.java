public class QuickSort{

public static int partition(Comparable[] li,int low_idx,int high_idx){
	int length = high_idx-low_idx+1;
	if (length==1){
		return low_idx;
	}
	else{
	Comparable pivot = li[high_idx];
	int thresh_idx = low_idx;
	for(int current_idx = low_idx;current_idx<=high_idx;current_idx++){
		if( (li[current_idx].compareTo(pivot) <=0 )){
			Comparable tmp = li[thresh_idx];
			li[thresh_idx] = li[current_idx];
			li[current_idx] = tmp;
			thresh_idx = thresh_idx+1;
		}
	}
	return thresh_idx-1;

}
}
public static void qsort(Comparable[] li,int low_idx,int high_idx){
	if(high_idx<=low_idx) return;
	int thresh_idx = partition( li,low_idx,high_idx);
	qsort(li,low_idx,thresh_idx-1);
	qsort(li,thresh_idx+1,high_idx);
}



public static void main(String[] args){
	Integer[] li = {1,5,6,17,12,3,5,2,19,14};
	QuickSort.qsort(li,0,li.length-1);
	for(int i:li){
		System.out.println(i);
	}
	String[] si = {"va","ka","pv","ad","ch","ma"};
	QuickSort.qsort(si,0,si.length-1);
	for(String i:si){
		System.out.println(i);
	}
}

}
