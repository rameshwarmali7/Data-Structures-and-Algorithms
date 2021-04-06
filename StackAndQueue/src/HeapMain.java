import java.util.Arrays;

public class HeapMain {
	
	public static void main(String[] args) {
		
		final int arrayLength = 10;
		final int[] givenArray = new int[arrayLength];
		final int[] ascendingArray = new int[arrayLength];
		final int[] decendingArray = new int[arrayLength];
		
		MinHeap minh = new MinHeap();
		MaxHeap maxh = new MaxHeap();
		
		for(int i = 0; i < arrayLength; i++) {
			int random = (int) (Math.random()*10 + 0); 
			givenArray[i] = random;
			minh.add(random);
			maxh.add(random);
		}
		
		for(int i = 0; i < arrayLength; i++) {
			ascendingArray[i] = minh.poll();
			decendingArray[i] = maxh.poll();
		}
		
		System.out.println("givenArray=" + Arrays.toString(givenArray));
		System.out.println("ascenArray=" + Arrays.toString(ascendingArray));
		System.out.println("decenArray=" + Arrays.toString(decendingArray));
	}
}