package fr.exia.katapotter.shop;

import java.util.ArrayList;
import java.util.HashSet;

public class Basket {

	private ArrayList<Books> content = new ArrayList<>();
	
	public Price getCost() {
		int numberOfDuplicates = countDuplicates(content);
		if (numberOfDuplicates > 0) {
			return new Price(8  * content.size());
		}
		
		double promotion = (1 - (content.size()-1) * 0.05);
		return new Price(8  * content.size() * promotion);
	}

	private int countDuplicates(ArrayList<Books> content) {
		HashSet<Books> contentTest = new HashSet<>(content);
		return content.size() - contentTest.size();
	}

	public void add(Books bookName) {
		content.add(bookName);
	}

}