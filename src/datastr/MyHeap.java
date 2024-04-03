package datastr;

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
		//TODO reheapUp();
	}
	
	public T dequeue() throws Exception {
		if(isEmpty()) throw new Exception("List is empty.");
		
		T prioElement = heap[0];
		heap[0] = heap[counter];
		counter--;
		//TODO reheapDown()
		return prioElement;
	}
	
	
	//TODO recursive print()
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
}
