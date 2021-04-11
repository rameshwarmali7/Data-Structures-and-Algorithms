public class StackUsingArrayMain {
	
	static class Stack {
		
		final private int capacity;
		final private int[] stack;
		private int size;
		
		public Stack(final int capacity) {
			this.capacity = capacity;
			this.size = 0;
			this.stack = new int[capacity];
		}
		
		public void push(final int data) {
			if(this.size == this.capacity) throw new IllegalStateException();
			
			this.stack[this.size] = data;
			this.size++;
			show();
		}
		
		public int pop() {
			if(isEmpty()) throw new IllegalStateException();
			
			final int data = this.stack[this.size-1];
			this.size--;
			show();
			
			return data;
		}
		
		public int peek() {
			if(isEmpty()) throw new IllegalStateException();
			
			return this.stack[this.size-1];
		}
		
		public boolean isEmpty() {
			
			return this.size == 0;
		}
		
		public int size() {
			
			return this.size;
		}
		
		public void show() {
			
			if(isEmpty()) System.out.println("Size=0 Top=0 Stack=");
			else System.out.print("Size=" + this.size + " Top=" + this.stack[this.size-1] + " Stack=");
			
			for(int i = 0; i < this.size; i++) System.out.print(this.stack[i] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		StackUsingArrayMain.Stack s = new StackUsingArrayMain.Stack(5);
		
		
		System.out.println(s.isEmpty()); System.out.println();
		System.out.println(s.size()); System.out.println();
		
		s.push(5); s.push(4); s.push(3); s.push(2); s.push(8); System.out.println();
		
		s.pop(); s.pop(); s.pop(); s.pop(); s.pop(); System.out.println();
		
//		s.pop();
		
		s.push(6); s.push(9); System.out.println();
	}
}
