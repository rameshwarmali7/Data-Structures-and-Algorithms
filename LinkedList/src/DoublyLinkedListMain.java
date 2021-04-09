//#Check folder D:\New Eclipse\aws doc\LinkedList\src
//#Methods to Add
//	add(data)
//	add(index, data)
//	remove()
//	remove(index)
//	get(index)
//	isEmpty()
//	size()
//	show()


class DoublyLinkedList {
	private class Node {
		private final int data;
		public Node next;
		public Node prev;
		
		public Node(final int data) {
			this.data = data;
		}
	}
	
	private int size;
	private Node head;
	
	public DoublyLinkedList() {
		this.size = 0;
	}
	
	
	public void add(final int data) {
		
		add(this.size,data);
	}
	
	public void add(final int index, final int data) {
		
		if(index < 0 || index > this.size) throw new IllegalArgumentException();
		
		final Node givenNode = new Node(data);
		Node currNode = this.head;
		
		for(int i = 0; i < index - 1; i++) currNode = currNode.next;
		
		if(index == 0) {
			givenNode.next = currNode;
			if(this.head != null) this.head.prev = givenNode;
			this.head = givenNode;
		} else {
			if(currNode.next != null) currNode.next.prev = givenNode;
			givenNode.next = currNode.next;
			currNode.next = givenNode;
			givenNode.prev = currNode;
			
		}
		this.size++;
		show();
	}
	
	public void remove() {
		
		remove(this.size-1);
		
	}
	
	public void remove(final int index) {
		
		if(index < 0 || index >= this.size) throw new IllegalStateException();
		
		if(this.size == 1) {
			this.head = null;
		} else if(index == 0) {
			this.head = this.head.next;
			this.head.prev = null;
		} else {
			Node currNode = this.head;
			for(int i = 0; i < index - 1; i++) currNode = currNode.next;

			currNode.next = currNode.next.next;
			
			if(index != this.size - 1) currNode.next.prev = currNode;
		}
		
		this.size--;
		show();
	}
	
	public int get(final int index) {
		
		return -1;
	}
	
	public boolean isEmpty() {
		
		return this.size == 0;
	}
	
	public void show() {
		
		if(isEmpty()) throw new IllegalStateException();
		
		Node currNode = this.head;
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();

		currNode = this.head;
		while(currNode.next != null) currNode = currNode.next;
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.prev;
		}
		System.out.println();
		System.out.println();
	}
	
}

public class DoublyLinkedListMain {
	
	public static void main(String[] args) {
		
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.add(54); dl.add(63); dl.add(23); dl.add(1, 25); dl.add(0, 11); dl.add(5, 73);
		System.out.println("-----------");
		dl.remove(2);
	}

}
