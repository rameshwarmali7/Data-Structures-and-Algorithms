class Node {
	
	public int data;
	public Node nextNode;
	
	public Node(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public void addNode(int data) {
		
		addNode(data, this.size);
	}
	
	public void addNode(int data, int index) {
		
		if(index < 0 || index > this.size) throw new IllegalArgumentException("Invalid Index");
		
		Node givenNode = new Node(data);
		Node currentNode = this.head;
		
		for(int i = 0; i < index - 1; i++) currentNode = currentNode.nextNode;
		
		if(index == 0) {
			givenNode.nextNode = currentNode;
			this.head = givenNode;
		} else {
			givenNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = givenNode;
		}
		
		if(index == this.size) this.tail = givenNode;
		
		this.size++;
		printLinkedList();
	}
	
	public int get(int index) {
		
		if(index < 0 || index > this.size - 1) throw new IllegalArgumentException("Invalid Index");

		Node currentNode = this.head;
		
		for(int i = 0; i < index; i++) currentNode = currentNode.nextNode;
		
		return currentNode.data;
	}
	
	public boolean isEmpty() {
		
		return this.size == 0;
	}
	
	public void remove(int index) {
		
		if(index < 0 || index >= this.size) throw new IllegalArgumentException("Invalid Index");
		
		Node currentNode = this.head;
		
		for(int i = 1; i < index; i++) currentNode = currentNode.nextNode;
		
		if(index == 0) this.head = this.head.nextNode;
		else currentNode.nextNode = currentNode.nextNode.nextNode;

		if(index == this.size - 1) this.tail = currentNode;

		this.size--;
		printLinkedList();		
	}
	
	public int size() {
		
		return this.size;
	}
	
	private void printLinkedList() {
		
		if(head == null) {
			System.out.println("Linked List is Empty");
			return;
		}
		
		Node currentNode = this.head;
		
		System.out.print("Size=" + this.size + " Head=" + this.head.data + " Tail=" + this.tail.data + " LinkedList=");
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}
}

public class SinglyLinkedListMain {
	
	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		
		System.out.println(sll.size());

		sll.addNode(95);sll.addNode(47);
		
		sll.addNode(23, 1);sll.addNode(11, 0);sll.addNode(83, 4);
		
		sll.addNode(75);
		
		sll.remove(5);
	}
}
