class Node {
	
	public int data;
	public Node nextNode;
	
	public Node(int data) {
		this.data = data;
	}
}

class Queue {
	
	private int size;
	private Node front;
	private Node rear;
	
	public boolean add(int data) {
		
		Node givenNode = new Node(data);
		
		if(isEmpty()) this.front = givenNode;
		else this.rear.nextNode = givenNode;

		this.rear = givenNode;
		this.size++;
		printQueue();
		return true;
	}
	
	public int remove() {
		
		int data;
		
		if(isEmpty()) throw new IllegalStateException();
		
		data = this.front.data;
		
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
		
		Node currentNode = this.front;
		
		if(isEmpty()) System.out.println("Queue is empty");
		else {
			System.out.print("Front=" + this.front.data + " Rear=" + this.rear.data + " Size=" + this.size + " Queue=");
			while(currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.nextNode;
			}
			System.out.println();
		}
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
