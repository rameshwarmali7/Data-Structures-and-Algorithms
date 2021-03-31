class Node {
	
	final public int data;
	public Node nextNode;
	
	public Node(int data) {
		this.data = data;
	}
}

class Queue {
	
	private int size;
	private Node front;
	private Node rear;
	
	public Queue() {}
	
	public void add(int data) {
		
		Node givenNode = new Node(data);
		
		if(isEmpty()) this.front = givenNode;
		else this.rear.nextNode = givenNode;

		this.rear = givenNode;
		this.size++;
		printQueue();
	}
	
	public int remove() {
		
		if(isEmpty()) throw new IllegalStateException();
		
		int data = this.front.data;
		
		this.front = this.front.nextNode;
		if(this.size == 1) this.rear = null;
		
		this.size--;
		printQueue();
		return data;
	}
	
	public int peek() {
		
		if(isEmpty()) throw new IllegalStateException();
		
		return this.front.data;
	}
	
	public boolean isEmpty() {
		
		return this.size == 0;
	}
	
	public int size() {
		
		return this.size;
	}
	
	private void printQueue() {
		
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		
		Node currentNode = this.front;
		
		System.out.print("Front=" + this.front.data + " Rear=" + this.rear.data + " Size=" + this.size + " Queue=");
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}
}

public class QueueUsingLinkedListMain {
	
	public static void main(String[] args) {
		
		Queue q = new Queue();
		
		System.out.println(q.isEmpty());
//		q.remove();
		
		q.add(12); q.add(38);
		
		q.remove(); q.remove();
		
//		q.remove();
		
		q.add(57);
	}
}
