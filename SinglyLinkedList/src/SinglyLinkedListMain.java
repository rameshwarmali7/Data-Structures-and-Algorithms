class ListNode {
	
	public int data;
	public ListNode nextNode;
	
	public ListNode(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int size;
	
	public void addListNodeAtEnd(int data) {
		
		ListNode givenNode = new ListNode(data);
		
		if(this.head == null) {
			this.head = givenNode;
		} else {
			this.tail.nextNode = givenNode;
		}
		this.tail = givenNode;
		
		this.size++;
		printLinkedList();
		return;
	}
	
	public void addListNodeAtStart(int data) {
		
		ListNode givenNode = new ListNode(data);
		
		givenNode.nextNode = this.head;
		
		if(this.head == null) {
			this.tail = givenNode;
		}
		
		this.head = givenNode;
		
		this.size++;
		printLinkedList();		
		return;
	}
	
	public ListNode getNode(int data) {
		
		ListNode currNode = this.head;
		
		while(currNode.nextNode != null) {
			if(currNode.data == data) {
				return currNode;
			}
			currNode = currNode.nextNode;
		}
		
		System.out.println("No Node exist");
		return null;
	}

	public void deleteNode(ListNode givenNode) {
		
		ListNode currNode = this.head;
		
		while(currNode.nextNode != null) {
			if(currNode.nextNode == givenNode) {
				currNode.nextNode = currNode.nextNode.nextNode;
				
				this.size--;
				printLinkedList();
				return;
			}
			currNode = currNode.nextNode;
		}
		
		System.out.println("No such node exist");
		return;		
	}
	
	public void addListNodeAtPosition(int data, int index) {
		
		if(index > this.size) {
			System.out.println("Out of bound");
			return;
		}
		
		if(index == 0) {
			addListNodeAtStart(data);
			return;
		}
		
		if(index == this.size) {
			addListNodeAtEnd(data);
			return;
		}
		
		ListNode givenNode = new ListNode(data);
		ListNode currentNode = this.head;
		int currentIndex = 0;
		
		while(currentNode.nextNode != null) {
			if(currentIndex == index - 1) break;
			
			currentNode = currentNode.nextNode;
			currentIndex++;
		}
		
		givenNode.nextNode = currentNode.nextNode;
		currentNode.nextNode = givenNode;
		
		this.size++;
		printLinkedList();
		return;
	}
	
	public void deleteListNodeAtPosition(int index) {
		
		if(index > this.size - 1) {
			System.out.println("Out of bound");
			return;
		}
		
		if(index == 0) {
			this.head = this.head.nextNode;
			this.size--;
			printLinkedList();
			return;
		}
		
		ListNode currentNode = this.head;
		int currentIndex = 0;
		
		while(currentNode.nextNode != null) {
			if(currentIndex == index - 1) {
				currentNode.nextNode = currentNode.nextNode.nextNode;
				if(index == this.size - 1) this.tail = currentNode;
				break;
			}
			currentNode = currentNode.nextNode;
			currentIndex++;
		}
		
		this.size--;
		printLinkedList();
		return;		
	}
	
	public boolean isEmpty() {
		System.out.println(this.size == 0);
		return this.size == 0;
	}
	
	public int getSize() {
		System.out.println(this.size);
		return this.size;
	}

	
	private void printLinkedList() {
		
		if(head == null) {
			System.out.println("Linked List []");
			return;
		}
		
		ListNode currNode = this.head;
		
		System.out.print("Size=" + this.size + " Head=" + this.head.data + " Tail=" + this.tail.data + " LinkedList=[");
		
		while(currNode.nextNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.nextNode;
		}
		
		System.out.println(currNode.data + "]");
		return;
	}
}

public class SinglyLinkedListMain {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.addListNodeAtEnd(12);
		sll.addListNodeAtEnd(12);
		sll.addListNodeAtEnd(13);
		sll.addListNodeAtEnd(13);
		sll.addListNodeAtEnd(13);
		sll.addListNodeAtEnd(14);
		sll.addListNodeAtEnd(14);
		sll.addListNodeAtEnd(14);
		
	}
}
