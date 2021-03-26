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
	
	public void addNode(int data) {
		
		ListNode givenNode = new ListNode(data);
		
		if(this.head == null) {
			this.head = givenNode;
		} else {
			this.tail.nextNode = givenNode;
		}
		
		this.tail = givenNode;
		
		this.size++;
		printLinkedList();
	}
	
	public void addNode(int data, int index) {
		
		if(index < 0 || index > this.size) throw new IllegalArgumentException("Invalid Index");
		
		ListNode givenNode = new ListNode(data);
		int currentIndex = 0;
		ListNode currentNode = this.head;
		
		if(index == 0) {
			givenNode.nextNode = this.head;
			if(this.head == null) {
				this.tail = givenNode;
			}
			this.head = givenNode;	
		} else {
			while(currentNode.nextNode != null) {
				if(currentIndex == index - 1) break;
				currentNode = currentNode.nextNode;
				currentIndex++;
			}
			givenNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = givenNode;
			if(index == this.size) this.tail = givenNode;
		}
		
		this.size++;
		printLinkedList();
	}
	
	
	public int get(int index) {
		
		if(index < 0 || index > this.size - 1) throw new IllegalArgumentException("Invalid Index");
		
		int currentIndex = 0;
		int dataAtIndex = 0;
		ListNode currentNode = this.head;
		
		while(currentNode != null) {
			if(currentIndex == index) dataAtIndex = currentNode.data;
			currentNode = currentNode.nextNode;
			currentIndex++;
		}
		
		System.out.println(dataAtIndex);
		return dataAtIndex;
	}
	
	public boolean isEmpty() {
		System.out.println(this.size == 0);
		return this.size == 0;
	}
	
	public void remove(int index) {
		
		if(index < 0 || index > this.size - 1) throw new IllegalArgumentException("Invalid Index");
		
		ListNode currentNode = this.head;
		int currentIndex = 0;
		
		if(index == 0) this.head = this.head.nextNode;
		else {
			while(currentNode.nextNode != null) {
				if(currentIndex == index - 1) {
					currentNode.nextNode = currentNode.nextNode.nextNode;
					if(index == this.size - 1) this.tail = currentNode;
					break;
				}
				currentNode = currentNode.nextNode;
				currentIndex++;
			}
		}
		
		this.size--;
		printLinkedList();		
	}
	
	public void removeElement(int data) {
		
		ListNode currentNode = this.head;
		int currentIndex = 0;
		
		if(currentNode.data == data) {
			remove(0);
			return;
		}
		while(currentNode.nextNode != null) {
			if(currentNode.nextNode.data == data) {
				currentNode.nextNode = currentNode.nextNode.nextNode;
				if(currentIndex == this.size - 2) this.tail = currentNode;
				break;
			}
			currentNode = currentNode.nextNode;
			currentIndex++;
		}

		this.size--;
		printLinkedList();
	}
	
	public int size() {
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
	}
}

public class SinglyLinkedListMain {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.size();
		sll.addNode(21);
		sll.addNode(14, 0);
		sll.get(1);
		
		sll.remove(1);
		sll.addNode(32, 0);
		sll.addNode(55, 2);
		sll.addNode(21, 1);
		sll.remove(3);
		sll.remove(0);
	}
}
