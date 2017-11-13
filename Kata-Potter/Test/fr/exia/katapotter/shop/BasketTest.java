package fr.exia.katapotter.shop;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {
	Basket basket;

	@Before
	public void init() {
		basket = new Basket();
	}
	
	@Test
	public void givenOneBookShouldReturn8DollarsCost() {
		basket.add(Books.FIRST);
		assertEquals(new BigDecimal(8), basket.getCost());
	}

	@Test
	public void givenSameBookTwiceShouldReturn16DollarsCost() {
		basket.add(Books.FIRST);
		basket.add(Books.FIRST);
		assertEquals(new BigDecimal(16), basket.getCost());
	}
	
	@Test
	public void givenTwoDifferentBooksShouldHave5PercentDiscount() {
		basket.add(Books.FIRST);
		basket.add(Books.SECOND);
		assertEquals(new BigDecimal(15.2), basket.getCost());
	}
	
	@Test
	public void givenThreeDifferentBookShouldHave10PercentDiscount() {
		basket.add(Books.FIRST);
		basket.add(Books.SECOND);
		basket.add(Books.THREE);
		assertEquals(new BigDecimal(21.6), basket.getCost());
	}
	
	@Test
	public void givenThreeDifferentBooksAnd1SingleBookShouldHave10PercentDiscountOnlyOnCollection() {
		basket.add(Books.FIRST);
		basket.add(Books.FIRST);
		basket.add(Books.SECOND);
		basket.add(Books.THREE);
		assertEquals(new BigDecimal(29.6), basket.getCost());
	}
}
