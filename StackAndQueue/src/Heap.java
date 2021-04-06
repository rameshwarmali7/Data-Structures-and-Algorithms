import java.util.Arrays;

abstract class Heap {
	
	protected int capacity;
	protected int size;
	protected int[] items;
	
	public Heap() {
		this.capacity = 10;
		this.size = 0;
		this.items = new int[this.capacity];
	}
	
	public int peek() {
		if(isEmpty()) throw new IllegalStateException();
		
		return this.items[0];
	}
	
	public int poll() {
		if(isEmpty()) throw new IllegalStateException();
		
		final int topItem = this.items[0];
		this.items[0] = this.items[this.size - 1];
		this.size--;
		heapifyDown();

		return topItem;
	}
	
	public void add(final int item) {
		
		ensureCapacity();
		this.items[this.size] = item;
		this.size++;
		heapifyUp();
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void show() {
		System.out.print("Heap=[");
		for(int i = 0; i < this.size; i++) {
			System.out.print(this.items[i] + " ");
		}
		System.out.println("]");
	}
	
	public abstract void heapifyDown();
	
	public abstract void heapifyUp();
	
	public int getLeftChildIndex(final int parentIndex) {
		return 2*parentIndex+1;
	}
	
	public int getRightChildIndex(final int parentIndex) {
		return 2*parentIndex+2;
	}
	
	public int getParentIndex(final int childIndex) {
		return (childIndex-1)/2;
	}
	
	public boolean hasLeftChild(final int parentIndex) {
		return getLeftChildIndex(parentIndex) < this.size;
	}
	
	public boolean hasRightChild(final int parentIndex) {
		return getRightChildIndex(parentIndex) < this.size;
	}
	
	public boolean hasParent(final int childIndex) {
		return getParentIndex(childIndex) >= 0;
	}
	
	public int getLeftChildItem(final int parentIndex) {
		return this.items[getLeftChildIndex(parentIndex)];
	}
	
	public int getRightChildItem(final int parentIndex) {
		return this.items[getRightChildIndex(parentIndex)];
	}
	
	public int getParentItem(final int childIndex) {
		return this.items[getParentIndex(childIndex)];
	}
	
	public void swap(final int indexOne, final int indexTwo) {
		final int temp = this.items[indexOne];
		this.items[indexOne] = this.items[indexTwo];
		this.items[indexTwo] = temp;
	}
	
	public void ensureCapacity() {
		if(this.size == this.capacity) {
			this.items = Arrays.copyOf(this.items, 2*this.size);
			this.capacity *= 2;
		}
	}
}
