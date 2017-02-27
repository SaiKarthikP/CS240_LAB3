package cs240_lab3;

public class SelectionSort{
	static int countMove = 0;
	static int countCompare = 0;

	public static <T extends Comparable<? super T>> void sort(T[] a, int n) {
		for (int i = 0; i < n - 1; i++){
			int iSmallest = getiSmallest(a, i, n-1);
			swap (a,i,iSmallest);
		}
	}
	public static <T extends Comparable<? super T>> int getiSmallest(T[] a, int first, int last) {
		int iMin = first;
		for (int i = first + 1; i <= last; i++){
			countCompare++;
			if (a[i].compareTo(a[iMin]) < 0){
				iMin = i;
			}
		}
		return iMin;
	}
		
	public static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		countMove++;
	}
}
