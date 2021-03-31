class Queue {
	
	private int capacity;
	private int size;
	private int front;
	private int rear;
	private int[] queue;
	
	public Queue(int capacity) {
		
		this.capacity = capacity;
		this.front = 0;
		this.rear = 0;
		this.queue = new int[capacity];
		printQueue();
	}
	
	public boolean add(int data) {
		
		if(this.size == this.capacity) throw new IllegalStateException();
		
		if(!isEmpty()) this.rear = (this.rear + 1) % this.capacity;
		
		this.queue[this.rear] = data;
		this.size++;
		printQueue();
		return true;
	}
	
	public int remove() {
		
		if(isEmpty()) throw new IllegalStateException();
		
		int result = this.queue[this.front];
		
		this.front = (this.front + 1) % this.capacity;
		
		if(this.size == 1) this.rear = this.front;
		
		this.size--;
		printQueue();
		return result;
	}
	
	public int peek() {
		
		if(isEmpty()) throw new IllegalStateException(); 
		return queue[this.front];
	}
	
	public int size() {
		
		return this.size;
	}
	
	public boolean isEmpty() {
		
		return this.size == 0;
	}
	
	private void printQueue() {
		
		if(isEmpty()) System.out.print("Size=0 Front=0 Rear=0 List=");
		else System.out.print("Size=" + this.size + " Front=" + this.queue[this.front] + " Rear=" + this.queue[this.rear] + " List=");

		int i = this.front;
		int count = 0;
		while(count<this.size) {
			System.out.print(this.queue[i] + " ");
			i = (i + this.capacity + 1) % this.capacity;
			count++;
		}
		System.out.println();
	}
}

public class QueueUsingArrayMain {
	
	public static void main(String[] args) {
		
		Queue q = new Queue(4); System.out.println();
		
		q.add(5); q.add(3); q.add(1); q.add(9); System.out.println();
		
		q.remove(); System.out.println();
		
		q.add(2); System.out.println();
		
		q.remove(); System.out.println();
		
		System.out.println(q.peek()); System.out.println();
		
		q.add(4); System.out.println();
		
		q.remove(); q.remove(); q.remove(); q.remove(); System.out.println();
		
		q.remove();
	}
}
