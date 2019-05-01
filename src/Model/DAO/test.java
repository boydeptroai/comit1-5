package Model.DAO;

// Java program select a random element from List 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {

	// Drive Function
	public static void main(String[] args) {

		// create a list of Integer type
		List<Integer> list = new ArrayList<>();
		// add 5 element in ArrayList
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(43); 
//			list.add(55); 
//			list.add(33); 
//			list.add(13); 
//			list.add(23); 
//			list.add(31); 

		test obj = new test();

		// boundIndex for select in sub list
		//int numberOfElements = 3;
		// take a random element from list and print them
		for (int i = 0; i < 10; i++) {
			System.out.println("h"+obj.getRandomElement(list));
		}
	
		//System.out.println(obj.getRandomElement(list));

	}

	// Function select an element base on index and return
	// an element

	public List<Integer> getRandomElement(List<Integer> list) {
		//Random rand = new Random(); 
		List<Integer> newList = new ArrayList<>();
		//newList.add(10);

//		for(int i=0;i<5;i++) {
//		if(newList.size()<4) {
//			int n=Random(list);
//			if(newList.contains(n)) {
//				
//			}else {
//				newList.add(n);
//			}
//		}
//		}
		while(newList.size()<=2) {
			int n=Random(list);
			if(newList.contains(n)) {
				
			}else {
				newList.add(n);
			}
		}	
		
		
		return newList;
	}
	public static int Random(List<Integer> list) {
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size()));
	}
}
