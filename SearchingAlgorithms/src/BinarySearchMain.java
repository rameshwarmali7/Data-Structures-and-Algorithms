import java.util.Arrays;
import java.util.List;

public class BinarySearchMain {
	
	public static void main(String[] args) {
		
		final List<Integer> givenList = Arrays.asList(3, 7, 7, 7, 7, 11, 45, 45, 76);
		
		System.out.println(binarySearchIterative(givenList, 45));
		System.out.println(binarySearchRecursive(givenList, 45));
	}
	
	public static int binarySearchIterative(final List<Integer> givenList, final int searchValue) {
		
		int midIndex = 0, left = 0, right = givenList.size() - 1;
		
		while(left <= right) {
			
			midIndex = left+(right-left)/2;
			
			if(givenList.get(midIndex) == searchValue) break;
			
			if(givenList.get(midIndex) < searchValue) left = midIndex + 1;
			else right = midIndex - 1;
		}
		
		return getFirstIndexOfElement(givenList, searchValue, midIndex);
	}
	
	public static int binarySearchRecursive(final List<Integer> givenList, final int searchValue) {
		
		int index = binarySearchRecursive(givenList, searchValue, 0, givenList.size()-1);
		
		return getFirstIndexOfElement(givenList, searchValue, index);
	}
	
	public static int binarySearchRecursive(final List<Integer> givenList, final int searchValue, int left, int right) {
		
		if(left <= right) {
			
			int midIndex = left + (right-left)/2;
			
			if(givenList.get(midIndex) == searchValue) return midIndex;
			
			if(givenList.get(midIndex) > searchValue) return binarySearchRecursive(givenList, searchValue, left, midIndex-1);
			else return binarySearchRecursive(givenList, searchValue, midIndex+1, right);
		}
		
		return -1;
	}
	
	public static int getFirstIndexOfElement(final List<Integer> givenList, final int searchValue, int index) {
		
		if(givenList.get(index) == searchValue) {
			while((index-1) >= 0 && givenList.get(index-1) == searchValue) index--;
			return index;
		}
		
		return -1;
	}
}
