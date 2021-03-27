class Stack {
	
	private int capacity;
	private int size;
	private int top;
	private int[] stack;
	
	public Stack(int capacity) {
		
		this.capacity = capacity;
		this.size = 0;
		this.top = -1;
		this.stack = new int[capacity];
	}
	
	public boolean push(int data) {
		
		if(this.size == this.capacity) throw new IllegalStateException();
		else if(isEmpty()) this.top = 0;
		else this.top = (this.top + 1) % this.capacity;

		this.stack[this.top] = data;
		this.size++;
		printStack();
		return true;
	}
	
	public int pop() {
		
		int data;
		if(isEmpty()) throw new IllegalStateException();
		else {
			data = this.stack[this.top];
			this.top = (this.top - 1 + this.capacity) % this.capacity;
		}
		
		this.size--;
		printStack();
		return data;
	}
	
	public int peek() {
		
		int data;
		if(isEmpty()) throw new IllegalStateException();
		else data = this.stack[this.top];
		
		return data;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	private void printStack() {
		
		if(isEmpty()) System.out.println("Stack is Empty");
		else {
			System.out.print("Size=" + this.size + " Top=" + this.stack[this.top] + " Stack=");
			for(int i = 0; i < this.capacity; i++) System.out.print(this.stack[i] + " ");
			System.out.println();
		}
	}
}


public class StackUsingArrayMain {
	
	public static void main(String[] args) {
		
		Stack s = new Stack(5);
		
		System.out.println(s.isEmpty());
		System.out.println(s.size());
		
		s.push(15);s.push(54);s.push(53);s.push(25);s.push(55);
		
		s.pop();s.pop();s.pop();s.pop();s.pop();
		
//		s.pop();
		
		s.push(67);
	}
}
