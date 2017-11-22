package fr.exia.katapotter.shop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Basket {

	private static final int BOOK_UNITARY_PRICE = 8;

	private ArrayList<Books> content = new ArrayList<>();

	private static final double[] DISCOUNT = { 0, 0.05, 0.1, 0.2, 0.25 };

	/**
	 * gives the cost of the basket, extracting all collections of different books
	 * @return a double value representing the price
	 */
	public Price getCost() {
		int[] collectionsOfDifferentBooks = getCollectionsOfDifferentBooks();

		double sum = 0;
		for (int i = 0; i < collectionsOfDifferentBooks.length; i++) {
			double discount = 1 - DISCOUNT[i];
			sum += BOOK_UNITARY_PRICE * (i + 1) * collectionsOfDifferentBooks[i] * discount;
		}
		return new Price(sum);
	}

	/**
	 * Processes the basket to compute the number of collections of 1, 2, 3, 4 and 5 different books.
	 * example: Basket = Book_1 x 4 + Book_2 x 2 + Book_3 x 1 
	 * 	=> 1 collection of 3 different books + 1 collection of 2 different books + 2 collections of 1 single book
	 * @return an array of 5 integers 
	 */
	private int[] getCollectionsOfDifferentBooks() {
		int[] collectionsOfDifferentBooks = { 0, 0, 0, 0, 0 };

		List<Books> splitterOfCollections = new ArrayList<>(content);

		while (!splitterOfCollections.isEmpty()) {
			Set<Books> aCollection = new HashSet<>(splitterOfCollections);
			collectionsOfDifferentBooks[aCollection.size() - 1] += 1;
			aCollection.forEach(copy -> splitterOfCollections.remove(copy));
		}
		return collectionsOfDifferentBooks;
	}
	
	public void add(Books bookName) {
		content.add(bookName);
	}

}
