class Queue {
	
	private int capacity;
	private int size;
	private int front;
	private int rear;
	private int[] queue;
	
	public Queue(int capacity) {
		
		this.capacity = capacity;
		this.front = -1;
		this.rear = -1;
		this.queue = new int[this.capacity];
		printQueue();
	}
	
	public boolean add(int data) {
		
		if(this.size == this.capacity) throw new IllegalStateException();
		else if (isEmpty()) {
			this.rear = 0;
			this.front = 0;
		} else {
			this.rear = (this.rear + 1) % this.capacity;
		}
		
		queue[this.rear] = data;
		this.size++;
		printQueue();
		return true;
	}
	
	public int remove() {
		
		int result;
		
		if(isEmpty()) throw new IllegalStateException();
		else if(this.size == 1) {
			result = queue[this.front];
			this.rear = -1;
			this.front = -1;
		} else {
			result = queue[this.front];
			this.front = (this.front + 1) % this.capacity;
		}
		
		this.size--;
		printQueue();
		return result;
	}
	
	public int peek() {
		
		int result;
		if(isEmpty()) throw new IllegalStateException();
		else result = queue[this.front];
		return result;
	}
	
	public int size() {
		
		return this.size;
	}
	
	public boolean isEmpty() {
		
		return this.size == 0;
	}
	
	private void printQueue() {

		if(isEmpty()) System.out.println("[]");
		else {
			System.out.print("Size=" + this.size + " Front=" + this.queue[this.front] + " Rear=" + this.queue[this.rear] + " List=[");
			for(int i = 0; i < this.capacity; i++) System.out.print(this.queue[i] + " ");
			System.out.println("]");
		}
	}
}

public class QueueUsingArrayMain {
	
	public static void main(String[] args) {
		
		Queue q = new Queue(4);
		
		q.add(52);
		q.add(23);
		q.add(31);
		q.add(89);
		
		q.remove();
		q.peek();
		
		q.add(45);
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.remove();
	}
}
