import java.util.Arrays;

public class MergeSortMain {
	
	public static void main(String[] arge) {
		
		final int[] givenArray = new int[] {23, 54, 38, 20, 19, 234};
		
		final int[] result = mergeSort(givenArray);
		System.out.println(Arrays.toString(result));
	}
	
	private static int[] mergeSort(final int[] givenArray) {
		
		if(givenArray.length <= 1) return givenArray;
		
		final int givenArrayLength = givenArray.length;
		final int midIndex;
		
		if(givenArrayLength % 2 == 0) midIndex = (givenArrayLength / 2) - 1;
		else midIndex = givenArrayLength / 2;
		
		int[] left = fillArray(givenArray, 0, midIndex);
		int[] right = fillArray(givenArray, midIndex+1, givenArray.length - 1);
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return mergeSortedTwoArray(left, right);
	}
	
	private static int[] fillArray(final int[] givenArray, final int startIndex, final int endIndex) {
		
		final int filledArrayLength = endIndex - startIndex + 1;
		final int[] filledArray = new int[filledArrayLength];
		
		for(int i = 0; i < filledArrayLength; i++) filledArray[i] = givenArray[startIndex + i];
		
		return filledArray;
	}
	
	private static int[] mergeSortedTwoArray(int[] leftArray, int[] rightArray) {
		
		final int leftArrayLength = leftArray.length;
		final int rightArrayLength = rightArray.length;
		final int sortedArrayLength = leftArrayLength + rightArrayLength;
		final int[] sortedArray = new int[sortedArrayLength];
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int sortedArrayIndex = 0;
		
		while(leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
			if(leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) sortedArray[sortedArrayIndex++] = leftArray[leftArrayIndex++];
			else sortedArray[sortedArrayIndex++] = rightArray[rightArrayIndex++];
		}
		
		while(leftArrayIndex < leftArrayLength) sortedArray[sortedArrayIndex++] = leftArray[leftArrayIndex++];
		while(rightArrayIndex < rightArrayLength) sortedArray[sortedArrayIndex++] = rightArray[rightArrayIndex++];
		return sortedArray;
	}
}
