import java.util.Arrays;
import java.util.List;

public class BinarySearchMain {
	
	public static void main(String[] args) {
		
		List<Integer> givenArray = Arrays.asList(3, 4, 7, 11, 45, 76);
		
		System.out.println(binarySearchIterative(givenArray, 7));
		System.out.println(binarySearchRecursive(givenArray, 0, givenArray.size()-1, 7));
		
	}
	
	public static int binarySearchIterative(List<Integer> givenList, int searchValue) {
		
		int midIndex = 0, left = 0, right = givenList.size() - 1;
		
		while(left <= right) {
			
			midIndex = left+(right-left)/2;
			
			if(givenList.get(midIndex) == searchValue) return midIndex;
			
			if(givenList.get(midIndex) < searchValue) left = midIndex + 1;
			else right = midIndex - 1;
		}
		
		return -1;
	}
	
	public static int binarySearchRecursive(List<Integer> givenList, int left, int right, int x) {
		
		if(left <= right) {
			
			int midIndex = left + (right-left)/2;
			
			if(givenList.get(midIndex) == x) return midIndex;
			
			if(givenList.get(midIndex) > x) return binarySearchRecursive(givenList, left, midIndex-1, x);
			else return binarySearchRecursive(givenList, midIndex+1, right, x);
		}
		
		return -1;
	}
}
