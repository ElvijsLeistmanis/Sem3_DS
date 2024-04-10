package service;

import datastr.MyHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
	/*	MyHeap<Integer> heapOfInt = new MyHeap<Integer>();
		try {
			heapOfInt.enqueue(6);
			heapOfInt.enqueue(8);
			heapOfInt.enqueue(10);
			heapOfInt.enqueue(2);
			heapOfInt.enqueue(7);
			heapOfInt.enqueue(99);
			
			heapOfInt.print();
			System.out.println("--------------------");
			heapOfInt.print2();
			System.out.println("---------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		MyHeap<Patient> allPatients = new MyHeap<Patient>();
		try {
			allPatients.enqueue(new Patient("Janis", "Berzins", "119583-19583", 2));
			allPatients.enqueue(new Patient("Baiba", "Kalnina", "219583-39583", 4));
			allPatients.enqueue(new Patient("Liga", "Jaula", "519588-49583", 8));
			
			System.out.println(allPatients.dequeue());
			allPatients.print2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
