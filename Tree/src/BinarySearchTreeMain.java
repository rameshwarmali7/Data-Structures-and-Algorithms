class Node {
	
	int data;
	Node leftChild;
	Node rightChild;
	
	public Node(final int data) {
		this.data=data;
	}
	
	public void insert(final int data) {
		if(data<this.data) {
			if(leftChild==null) leftChild = new Node(data);
			else leftChild.insert(data);
		} else {
			if(rightChild==null) rightChild=new Node(data);
			else rightChild.insert(data);
		}
	}
	
	public boolean contains(final int data) {
		if(data==this.data) return true;
		
		else if (data<this.data) {
			if(leftChild==null) return false;
			else return leftChild.contains(data);
		} else {
			if(rightChild==null) return false;
			else return rightChild.contains(data);
		}
	}
	
	public void inOrderTraversal() {
		if(leftChild!=null) leftChild.inOrderTraversal();
		System.out.print(this.data + " ");
		if(rightChild!=null) rightChild.inOrderTraversal();
	}
	
	public void preOrderTraversal() {
		System.out.print(this.data + " ");
		if(leftChild != null) leftChild.preOrderTraversal();
		if(rightChild != null) rightChild.preOrderTraversal();
	}
	
	public void postOrderTraversal() {
		if(leftChild != null) leftChild.postOrderTraversal();
		if(rightChild != null) rightChild.postOrderTraversal();
		System.out.print(this.data + " ");
	}
}

public class BinarySearchTreeMain {
	
	public static void main(String args[]) {
		
		final Node bst = new Node(50);
		bst.insert(25); bst.insert(75);
		bst.insert(15); bst.insert(40); bst.insert(65); bst.insert(80);
		bst.insert(10); bst.insert(20); bst.insert(30); bst.insert(45); bst.insert(60); bst.insert(70); bst.insert(77); bst.insert(90);
		
		System.out.println(bst.contains(20));
		System.out.println(bst.contains(999));
		
		bst.inOrderTraversal(); System.out.println();
		bst.preOrderTraversal(); System.out.println();
		bst.postOrderTraversal(); System.out.println();
	}
}
