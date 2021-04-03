import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithmsMain {
	
	public static void main(String[] args) {
		
		final List<Integer> givenArray = Arrays.asList(6, 5, 3, 4, 3, 2, 6, 1);
		System.out.println("givenArray=" + givenArray);
		
		insertionSort(givenArray);
		bubbleSort(givenArray);
		selectionSort(givenArray);
	}
	
	public static List<Integer> insertionSort(final List<Integer> givenArray) {
		
		for(int i = 1; i < givenArray.size(); i++) {
			
			int j = i;
			while(j > 0) {
				if(givenArray.get(j) < givenArray.get(j-1)) Collections.swap(givenArray, j, j-1);
				j--;
			}
		}
		
		System.out.println("insertionSort=" + givenArray);
		return givenArray;
	}
	
	public static List<Integer> bubbleSort(final List<Integer> givenArray) {
		
		for(int i = 0; i< givenArray.size(); i++) {
			for(int j = 0; j < givenArray.size() - 1 - i; j++) {
				
				if(givenArray.get(j) > givenArray.get(j+1)) Collections.swap(givenArray, j, j+1);
			}
		}
		
		System.out.println("bubbleSort=" + givenArray);
		return givenArray;
	}
	
	public static List<Integer> selectionSort(final List<Integer> givenArray) {
		
		for(int i = 0; i < givenArray.size(); i++) {
			
			int minimumIndex = i;
			
			for(int j = i + 1; j < givenArray.size(); j++) {
				
				if(givenArray.get(j) < givenArray.get(minimumIndex)) minimumIndex = j;
			}
			
			Collections.swap(givenArray, i, minimumIndex);
		}
		
		System.out.println("selectionSort=" + givenArray);
		return givenArray;
	}
}
