public class MinHeap extends Heap{

	@Override
	public void heapifyDown() {
		int index = 0;
		
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChildItem(index) < getLeftChildItem(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(this.items[index] < this.items[smallerChildIndex]) break;
			else swap(smallerChildIndex, index);
			
			index = smallerChildIndex;
		}
	}

	@Override
	public void heapifyUp() {
		int index = this.size - 1;

		while(hasParent(index) && getParentItem(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
}