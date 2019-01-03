import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.Math;

public class Proj1 {

	public static void main(String args[]) throws FileNotFoundException  {
		  
	
		System.out.println("Please enter size of array");
        Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		System.out.println("The size you entered is " + size);
		int[] array = new int[size];
		System.out.println("Enter the array: ");
		 
		int j = 0;
		while (j < size) {
		    System.out.print("Enter "+ (j+1) + ": ");
		    array[j] = in.nextInt();     // getting input array
		    ++j;
		}
		
		in.close();
	        
		int n = array.length; 
		if(n==1) { //if single element
			System.out.println("Theres only one Element");

		}
		if(n==2) // if there are two numbers
		{
			System.out.println("Theres only one difference");
			System.out.println(Math.abs(array[1]- array[0]));
			
		}
		
		if(n!=1 && n!=2)
		{
		
		RandomizedQuickSort(array, 0, array.length - 1); // Randomized Quick sort- O(nlogn) regardless of the input
															// distribution
		print2Smallestdiff(array, n);
		}


	}

	public static void RandomizedQuickSort(int[] array, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivot = randomizedPartition(array, startIndex, endIndex); // randomized pivot element
			RandomizedQuickSort(array, startIndex, pivot - 1); // between 0(usually) till pivot-1
			RandomizedQuickSort(array, pivot + 1, endIndex); // between pivot+1 and endindex-1
		}
	}

	public static int randomizedPartition(int[] array, int startIndex, int endIndex) {
		int randomEndIndex = randomNumberBetween(startIndex, endIndex);// random index generator
		swap(array, endIndex, randomEndIndex); // swap- randomend index and real end index
		return partition(array, startIndex, endIndex);
	}

	public static int randomNumberBetween(int startNumber, int endNumber) {
		return (int) Math.floor(Math.random() * (endNumber - startNumber + 1) + startNumber);// floor function - closest
																								// integer
	}

	public static int partition(int[] array, int startIndex, int endIndex) {
		int pivotValue = array[endIndex];
		int pivotIndex = startIndex;

		for (int j = startIndex; j < endIndex; j++) {
			if (array[j] <= pivotValue) { // check if element is less than pivot value
				swap(array, pivotIndex, j);// if yes, swap
				pivotIndex = pivotIndex + 1; // increasing pivot index
			}
		}
		swap(array, pivotIndex, endIndex);
		return pivotIndex;
	}

	public static void swap(int[] array, int firstIndex, int secondIndex) {// swapping
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	public static void print2Smallestdiff(int arr[], int arr_size) {

		int diff1 = Integer.MAX_VALUE;// setting initial value as max value
		int diff2 = Integer.MAX_VALUE;
        int index1=0,index2=0;
		for (int x = 0; x < arr_size - 1; x++) {
			if (arr[x + 1] - arr[x] < diff1) {
				diff2 = diff1; // to note down min_diff1 and use it for
				diff1 = arr[x + 1] - arr[x]; // swapping with diff2
				index1=x;
			} else if (arr[x + 1] - arr[x] < diff2 && arr[x + 1] - arr[x] != diff1)// diff1< value <diff2
			{
				diff2 = arr[x + 1] - arr[x]; // noting diff2
				index2=x;
			}
		}
		if (diff2 == Integer.MAX_VALUE) 
            System.out.println("First minimum difference is " + diff1 + " & there is no other second minimum difference"); 
        else
            System.out.println("The first minimum difference is " + 
                               diff1 + "[" + arr[index1] + " " +arr[index1+1] + "]" + " and second Smallest" + 
                               " difference is " + diff2 + "["+ arr[index2] + " " + arr[index2+1]+"]"); 
	
		
	}
}
	



