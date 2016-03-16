import java.util.Random;
/**
 * The EmpiricalEvaluation class is used to compare the sorting algorithms (Merge sort vs Quick sort vs Insertion Sort)
 * @author  Rohini Yadav 
 */

public class EvalSort {

	//-----------------------------Start of Insertion Sort
	/*
	 * Method to do insertion sort   
	 * @param array[]: input array to sort
	 */
	public void insertionSort(int array[]) { 
		int n = array.length; 
		for (int j = 1; j < n; j++) { 
			int key = array[j]; 
			int i = j-1; 
			while ( (i > -1) && ( array [i] > key ) ) { 
				array [i+1] = array [i]; 
				i--; 
			} 
			array[i+1] = key;  
		}
	} 

	//-------------------------------End of Insertion Sort



	//-----------------------------------Code for Merge Sort


	/*
	 * Merge Sort Entry method
	 * @param   array[]
	 */
	public void mergeSortEntry(int inputArr[]) {
		 int[] array;
		 int[] tempMergArr;
		 int length;
		
		array = inputArr;
		length = inputArr.length;
		tempMergArr = new int[length];
		mergeSort(array,0, length - 1,tempMergArr);
	}
	/*
	 * Method to sort the left and right array recursively
	 * @param lower: start index of the array
	 * @param higher: end index of the array
	 */
	private void mergeSort(int[] array, int lowerIndex, int higherIndex, int []tempMergArr) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Sort left part of array
			mergeSort(array, lowerIndex, middle, tempMergArr);
			//  Sort right part of array
			mergeSort(array, middle + 1, higherIndex, tempMergArr);
			// Now merge both parts
			merge(array, lowerIndex, middle, higherIndex,tempMergArr);
		}
	}
	/*
	 * Method to merge the two sorted array parts
	 * @param lower: start index
	 * @param middle: middle index
	 * @param higher:  last index of the array
	 */
	private void merge(int array[], int lowerIndex, int middle, int higherIndex, int tempMergArr[]) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}

	//---------------------------------------------------End of Merge Sort


	//------------------------------------------------Quick Sort

	/*
	 * Method for calling the Quick sort   
	 * 
	 */
	public void quickSortEntry(int[] inputArr) {
		int array[];
		int length1;
		
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		array = inputArr;
		length1 = inputArr.length;
		quickSort(array, 0, length1 - 1);
	}
	/*
	 * Method to quick sort the input array   
	 * 
	 */
	private void quickSort(int [] array, int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// taking pivot as middle index number
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a number
			 * from right side which is less then the pivot value. Once the search
			 * is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(array, i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		if (lowerIndex < j)
			quickSort(array, lowerIndex, j);
		if (i < higherIndex)
			quickSort(array, i, higherIndex);
	}
	/*
	 * Method to exchange the elements
	 * 
	 */
	private void exchangeNumbers(int [] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	//---------------------------------------------------------End of Quick Sort
}