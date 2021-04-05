import java.util.Arrays;
import java.util.Random;

class QuickSort {
	
	public int[] quickSort(final int[] givenArray) {
		
		return quickSort(givenArray, 0, givenArray.length - 1);
	}
	
	private int[] quickSort(final int[] givenArray, final int left, final int right) {
		
		if(left < right) {
			final int partition = partition(givenArray, left, right);
			
			quickSort(givenArray, left, partition-1);
			quickSort(givenArray, partition+1, right);
		}
		
		return givenArray;
	}
	
	private int[] swap(final int[] givenArray, final int index1, final int index2) {
		
		final int temp = givenArray[index1];
		givenArray[index1] = givenArray[index2];
		givenArray[index2] = temp;
		
		return givenArray;
	}
	
	private int partition(final int[] givenArray, int leftIndex, int rightIndex) {
		
		final int pivotIndex = (int) (Math.random()*(rightIndex-leftIndex+1) + leftIndex);
		swap(givenArray, leftIndex, pivotIndex);
		
		int border = leftIndex + 1;
		
		for(int i = border; i <= rightIndex; i++) {
			if(givenArray[i] < givenArray[leftIndex]) swap(givenArray, i, border++); 
		}
		
		swap(givenArray, leftIndex, border-1);
		return border-1;
	}
}

public class QuickSortMain {
	
	public static void main(String[] args) {
		
		int[] givenArray = new int[] {2, 5, 44, 23, 85, 98, 20, 12, 85, 44, 30};
		
		QuickSort qs = new QuickSort();
		
		System.out.println(Arrays.toString(givenArray));
		System.out.println(Arrays.toString(qs.quickSort(givenArray)));
	}
}
