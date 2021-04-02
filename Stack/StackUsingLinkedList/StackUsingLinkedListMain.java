class Node {
	
	public final int data;
	public Node nextNode;
	
	public Node(final int data) {
		this.data = data;
	}
}

class Stack {
	
	private int size;
	private Node top;
	
	public void push(final int data) {
		
		final Node givenNode = new Node(data);
		
		givenNode.nextNode = this.top;
		
		this.top = givenNode;
		
		this.size++;
		printStack();
	}
	
	public int pop() {
		
		if(isEmpty()) throw new IllegalStateException();
		
		final int data = this.top.data;
		this.top = this.top.nextNode;
		
		this.size--;
		printStack();
		return data;
	}
	
	public int peek() {
		
		if(isEmpty()) throw new IllegalStateException();
		
		return this.top.data;
	}
	
	public boolean isEmpty() {
		
		return this.size == 0;
	}
	
	public int size() {
		
		return this.size;
	}
	
	private void printStack() {
		
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		
		Node currentNode = this.top;
		
		System.out.print("Size=" + this.size + " Top=" + this.top.data + " Stack=");
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}
}

public class StackUsingLinkedListMain {
	
	public static void main(String[] args) {
		
		Stack s = new Stack();
		
		System.out.println(s.isEmpty());
		
		s.push(23); s.push(54);
		
		s.pop(); s.pop(); s.pop();
	}
}
