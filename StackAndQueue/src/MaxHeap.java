public class MaxHeap extends Heap{

	@Override
	public void heapifyDown() {
		int index = 0;
		
		while(hasLeftChild(index)) {
			int higherChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChildItem(index) > getLeftChildItem(index)) {
				higherChildIndex = getRightChildIndex(index);
			}
			
			if(this.items[index] > this.items[higherChildIndex]) break;
			else swap(higherChildIndex, index);
			
			index = higherChildIndex;			
		}
	}

	@Override
	public void heapifyUp() {
		int index = this.size - 1;
		
		while(hasParent(index) && getParentItem(index) < this.items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
}
