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
		int midIndex = (givenArrayLength/2);
		
		final int leftArrayLength = midIndex;
		final int rightArrayLength = givenArrayLength - midIndex;
		final int[] left = new int[midIndex];
		final int[] right = new int[givenArrayLength - midIndex];
		
		if(givenArrayLength%2==0) midIndex--;
	
		System.arraycopy(givenArray, 0, left, 0, leftArrayLength);
		System.arraycopy(givenArray, midIndex + 1, right, 0, rightArrayLength);

		return mergeSortedTwoArray(left, right);
	}
	
	private static int[] mergeSortedTwoArray(final int[] leftArray,final  int[] rightArray) {
		
		final int[] sortedArray = new int[leftArray.length + rightArray.length];
		int leftArrayIndex = 0, rightArrayIndex = 0, sortedArrayIndex = 0;
		
		while(leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
			if(leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) sortedArray[sortedArrayIndex++] = leftArray[leftArrayIndex++];
			else sortedArray[sortedArrayIndex++] = rightArray[rightArrayIndex++];
		}
		
		while(leftArrayIndex < leftArray.length) sortedArray[sortedArrayIndex++] = leftArray[leftArrayIndex++];
		while(rightArrayIndex < rightArray.length) sortedArray[sortedArrayIndex++] = rightArray[rightArrayIndex++];
		return sortedArray;
	}
}