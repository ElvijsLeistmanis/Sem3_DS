package datastr;

@SuppressWarnings("unchecked")
public class MyHeap<T> {
	private T[] heap;
	private final int HEAP_DEFAULT_SIZE = 10;
	private int size = HEAP_DEFAULT_SIZE;
	private int counter = 0;
	
	public MyHeap() {
		heap = (T[]) new Object[size];
	}
	
	public MyHeap(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		heap = (T[]) new Object[size];
	}
	
	public boolean isEmpty() {
		return (counter==0);
	}
	
	public boolean isFull() {
		return (counter == size);
	}
	
	public int howManyElements() {
		return counter;
	}
	
	private void resize()
	{
		int newSize = (counter <= 100)? size * 2 : (int)(size * 1.5);
		T[] heapNew = (T[]) new Object[newSize];
		for(int i = 0; i < size; i++) {
			heapNew[i] = heap[i];
		}
		
		heap = heapNew;
		System.gc();
		size = newSize;
	}
	
	public void enqueue (T element) throws Exception {
		if(element == null) throw new Exception("Bad element.");
		if(isFull()) resize();
		
		heap[counter] = element;
		counter++;
		reheapUp(counter-1);
	}
	
	public T dequeue() throws Exception {
		if(isEmpty()) throw new Exception("List is empty.");
		
		T prioElement = heap[0];
		heap[0] = heap[counter-1];
		counter--;
		reheapDown(0);
		return prioElement;
	}
	
	//TODO recursive print()
	public void print2() throws Exception {
		if(isEmpty()) throw new Exception("Array is empty and it "
				+ "is not possible to print elements");
		
		printRecursiveHelp(0);
	}

	private void printRecursiveHelp(int index) {
		T element = heap[index];
		System.out.println("P: " + element + " ");
		
		int leftChildIndex = index * 2 + 1;
		int rightChildIndex = index * 2 + 2; 
		
		if (leftChildIndex < counter) {
			T leftChild = heap[leftChildIndex];
			System.out.print("LC: " + leftChild + " [" + element + "]");
			printRecursiveHelp(leftChildIndex);
		}
		if (rightChildIndex < counter){
			T rightChild = heap[rightChildIndex];
			System.out.print("RC: " + rightChild + " [" + element + "]");
			printRecursiveHelp(rightChildIndex);
		}
	}
	
	public void print() throws Exception {
		
		if(isEmpty()) throw new Exception("Array is empty and it "
				+ "is not possible to print elements");
		
		for(int i = 0; i < counter;i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
	
	public void makeEmpty() {
		counter = 0;
		size = HEAP_DEFAULT_SIZE;
		heap = (T[])new Object[size];
		System.gc();	
	}
	
	@SuppressWarnings("rawtypes")
	private void reheapUp(int index) {
		int parentIndex = (index - 1) / 2;
		if(index >= 0) {
			T element = heap[index];
			T parent = heap[parentIndex];
			if( ((Comparable)(element)).compareTo(parent) == 1) {
				swap(index, parentIndex);
				reheapUp(parentIndex);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void reheapDown(int index) {
		int leftChildIndex = index * 2 + 1;
		int rightChildIndex = index * 2 + 2; 
		
		if (counter > leftChildIndex && counter > rightChildIndex) {
			T element = heap[index];
			T rightChild = heap[rightChildIndex];
			T leftChild = heap[leftChildIndex];
			
			if ( ((Comparable)(leftChild)).compareTo(rightChild) == 1) {
				if ( ((Comparable)(leftChild)).compareTo(element) == 1) {
					swap(leftChildIndex, index);
					reheapDown(leftChildIndex);
				}
			}
			else {
				if ( ((Comparable)(rightChild)).compareTo(element) == 1) {
					swap(rightChildIndex, index);
					reheapDown(rightChildIndex);
				}
			}
		}
		else if (leftChildIndex < counter && rightChildIndex >= counter) {
			T element = heap[index];
			T leftChild = heap[leftChildIndex];
			
			if ( ((Comparable)(leftChild)).compareTo(element) == 1) {
				swap(leftChildIndex, index);
			}
		}
	}
	
	private void swap(int index1, int index2) {
		T temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
