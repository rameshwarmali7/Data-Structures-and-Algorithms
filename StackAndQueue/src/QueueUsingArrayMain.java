public class QueueUsingArrayMain {
	
	private static class Queue {
		
		final private int capacity;
		final private int[] queue;
		private int size;
		private int front;
		private int rear;
		
		public Queue(final int capacity) {
			this.capacity = capacity;
			this.front = 0;
			this.rear = 0;
			this.queue = new int[capacity];
		}
		
		public void add(final int data) {			
			if(this.size == this.capacity) throw new IllegalStateException();
			
			this.queue[this.rear] = data;
			this.rear = (this.rear+1)%this.capacity;
			
			this.size++;
			printQueue();
		}
		
		public int remove() {
			if(isEmpty()) throw new IllegalStateException();
			
			final int result = this.queue[this.front];
			this.front =(this.front+1)%this.capacity;
			
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
			if(isEmpty()) System.out.println("Size=0 Fron=0 Rear=0 List=");
			else System.out.print("Size=" +this.size+ " Front=" +this.queue[this.front]+ " Rear=" + this.queue[(this.rear-1+this.capacity)%this.capacity] + " List=");
			
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
