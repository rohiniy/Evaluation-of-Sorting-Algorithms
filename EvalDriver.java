import java.util.Random;


public class EvalDriver {

	public static int size = 100000;
	private static int phase = 0;
	private static long startTime, endTime, elapsedTime;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[size];
		Random rand = new Random();

		for(int i=0;i<size;i++){
			arr[i] = rand.nextInt(size*100);
		}
		//Sort on random elements array
		
		int[] arr1 = (int[]) arr.clone(); 
		int[] arr2 = (int[]) arr.clone(); 
		int[] arr3 = (int[]) arr.clone(); 
		
		
		EvalSort e = new EvalSort();
		System.out.println("\n-------------------Time required by Sorting algorithms to sort random array:");
		System.out.println("**Time required by Insertion Sort:");
		timer();
		e.insertionSort(arr1);
		timer();
		System.out.println("**Time required by Merge Sort:");
		timer();
		e.mergeSortEntry(arr2);
		timer();
		System.out.println("**Time required by Quick Sort:");
		timer();
		e.quickSortEntry(arr3);
		timer();

		//Sort already sorted arrays
		int[] sortedArr = new int[size];
		for(int i=0;i<size;i++){
			sortedArr[i] = i;
		}
		
		
		int[] arr4 = (int[]) sortedArr.clone(); 
		int[] arr5 = (int[]) sortedArr.clone(); 
		int[] arr6 = (int[]) sortedArr.clone(); 

		System.out.println("\n-------------------Time required by Sorting algorithms to sort a sorted array:");
		System.out.println("**Time required by Insertion Sort:");
		timer();
		e.insertionSort(arr4);
		timer();		
		System.out.println("**Time required by Merge Sort:");
		timer();
		e.mergeSortEntry(arr5);
		timer();
		System.out.println("**Time required by Quick Sort:");
		timer();
		e.quickSortEntry(arr6);
		timer();
		
		//Calling sort methods on reverse sorted array
		int[] reverseArr = new int[size];
		for(int i=0;i<size;i++){
			reverseArr[i] = size-i;
		}
		int[] arr7 = (int[]) reverseArr.clone(); 
		int[] arr8 = (int[]) reverseArr.clone(); 
		int[] arr9 = (int[]) reverseArr.clone(); 
		
		System.out.println("\n-------------------Time required by Sorting algorithms to sort sorted array which is reversed:");
		System.out.println("**Time required by Insertion Sort:");
		timer();
		e.insertionSort(arr7);
		timer();
		System.out.println("**Time required by Merge Sort:");
		timer();
		e.mergeSortEntry(arr8);
		timer();
		System.out.println("**Time required by Quick Sort:");
		timer();
		e.quickSortEntry(arr9);
		timer();

		//Calling sort methods on partially sorted array
		int[] partiallySortedArr = new int[size];
		for(int i=0;i<size;i++){
			partiallySortedArr[i] = i;
		}
		for(int i=2;i<size;i++){
			//Swapping 3rd and 4th position to make the array almost sorted 
			if(i%3==0){
				int temp=partiallySortedArr[i];
				partiallySortedArr[i-2]=partiallySortedArr[i];
				partiallySortedArr[i]=temp;
			}
		}
		int[] arr10 = (int[]) partiallySortedArr.clone(); 
		int[] arr11 = (int[]) partiallySortedArr.clone(); 
		int[] arr12 = (int[]) partiallySortedArr.clone(); 
		
		System.out.println("\n-------------------Time required by Sorting algorithms to sort partially sorted array:");
		System.out.println("**Time required by Insertion Sort:");
		timer();
		e.insertionSort(arr10);
		timer();
		System.out.println("**Time required by Merge Sort:");
		timer();
		e.mergeSortEntry(arr11);
		timer();
		System.out.println("**Time required by Quick Sort:");
		timer();
		e.quickSortEntry(arr12);
		timer();
	}
	
	//Method to calculate the time for sorting algorithms
		public static void timer()
		{
			if(phase == 0) {
				startTime = System.currentTimeMillis();
				phase = 1;
			} else {
				endTime = System.currentTimeMillis();
				elapsedTime = endTime-startTime;
				System.out.println("Time taken: " + elapsedTime + " msec.");
				phase = 0;
			}
		}
}
