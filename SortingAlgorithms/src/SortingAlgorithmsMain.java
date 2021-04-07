import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortingAlgorithmsMain {
	
	public static void main(String[] args) {
		
		final List<Integer> givenList = new ArrayList<Integer>();

		for(int i = 0; i < 10; i++) {
			int randomNum =(int) (Math.random() * 10 + 0);
			givenList.add(randomNum);
		}
		
		System.out.println("givenList=" + givenList);
		insertionSort(givenList);
		bubbleSort(givenList);
		selectionSort(givenList);
		countSort(givenList);
	}
	
	public static List<Integer> insertionSort(final List<Integer> givenList) {
		
		for(int i = 1; i < givenList.size(); i++) {
			int j = i;
			while(j > 0) {
				if(givenList.get(j) < givenList.get(j-1)) Collections.swap(givenList, j, j-1);
				j--;
			}
		}
		
		System.out.println("insertion=" + givenList);
		return givenList;
	}
	
	public static List<Integer> bubbleSort(final List<Integer> givenList) {
		
		for(int i = 0; i< givenList.size(); i++) {
			for(int j = 0; j < givenList.size() - 1 - i; j++) {
				if(givenList.get(j) > givenList.get(j+1)) Collections.swap(givenList, j, j+1);
			}
		}
		
		System.out.println("bubbleSor=" + givenList);
		return givenList;
	}
	
	public static List<Integer> selectionSort(final List<Integer> givenList) {
		
		for(int i = 0; i < givenList.size(); i++) {
			int minimumIndex = i;
			
			for(int j = i + 1; j < givenList.size(); j++) {
				if(givenList.get(j) < givenList.get(minimumIndex)) minimumIndex = j;
			}
			
			Collections.swap(givenList, i, minimumIndex);
		}
		
		System.out.println("selection=" + givenList);
		return givenList;
	}
	
	public static List<Integer> countSort(final List<Integer> givenList) {
		
		int minimumValue = Integer.MAX_VALUE;
		int maximumValue = Integer.MIN_VALUE;
		
		for(int num : givenList) {
			minimumValue = Math.min(minimumValue, num);
			maximumValue = Math.max(maximumValue, num);
		}
		
		final int[] countArray = new int[maximumValue - minimumValue + 1];
		final List<Integer> sortedList = new ArrayList<Integer>();
		
		for(int num : givenList) countArray[num-minimumValue] += 1;
		
		for(int i = 0; i < countArray.length; i++) {
			int count = countArray[i];
			while(count > 0) {
				sortedList.add(i+minimumValue);
				count--;
			}
		}
		
		System.out.println("countSort=" + sortedList);
		return sortedList;
	}
}