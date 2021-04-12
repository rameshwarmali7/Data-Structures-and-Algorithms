import java.util.Arrays;

public class DynamicArrayMain {
	
	private static class DynamicArray<T> {
		
		private Object[] objectArray;
		private int size;
		
		public DynamicArray() {
			
			this.size = 0;
			this.objectArray = new Object[1];
		}
		
		public void add(final Object object) {
			addAt(object, this.size);
		}
		
		public void addAt(final Object object, final int index) {
			
			ensureCapacity();
			
			for(int i = size-1; i >= index; i--) this.objectArray[i+1] = this.objectArray[i];
			
			this.objectArray[index] = object;
			this.size++;
			printArray();
		}
		
		public void remove() {
			
			removeAt(size()-1);
		}
		
		public void removeAt(final int index) {
			
			if(size() == 0 || index > this.size) throw new IllegalStateException();
			
			for(int i = index; i < this.size; i++) this.objectArray[i] = this.objectArray[i+1];
			
			this.size--;
			printArray();
		}
		
		public T get(final int index) {
			
			return (T) this.objectArray[index];
		}
		
		public int size() {
			
			return this.size;
		}
		
		private void ensureCapacity() {
			
			if(this.objectArray.length == size()) {
				this.objectArray = Arrays.copyOf(this.objectArray, 2 * this.objectArray.length);
			}
		}
		
		private void printArray() {
			
			for(int i = 0; i < this.objectArray.length; i++) {
				System.out.print(this.objectArray[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		DynamicArrayMain.DynamicArray<Integer> da = new DynamicArray<>();
		System.out.println(da.size());
//		da.removeAt(7);
		da.add(3674);
		da.add(3754);
		da.add(3877);
		da.add(3377);
		System.out.println(da.get(3));
		da.add(3672);
		da.remove();
		da.removeAt(1);
		da.removeAt(2);
	}

}
