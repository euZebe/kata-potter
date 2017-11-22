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
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		assertEquals(new Price(8), basket.getCost());
	}

	@Test
	public void givenSameBookTwiceShouldReturn16DollarsCost() {
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		assertEquals(new Price(16), basket.getCost());
	}
	
	@Test
	public void givenTwoDifferentBooksShouldHave5PercentDiscount() {
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_CHAMBER_OF_SECRETS);
		assertEquals(new Price(15.2), basket.getCost());
	}
	
	@Test
	public void givenThreeDifferentBookShouldHave10PercentDiscount() {
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_CHAMBER_OF_SECRETS);
		basket.add(Books.THE_PRISONER_OF_AZKABAN);
		assertEquals(new Price(21.6), basket.getCost());
	}
	
	@Test
	public void givenThreeDifferentBooksAnd1SingleBookShouldHave10PercentDiscountOnlyOnCollection() {
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_CHAMBER_OF_SECRETS);
		basket.add(Books.THE_PRISONER_OF_AZKABAN);
		assertEquals(new Price(29.6), basket.getCost());
	}
	
	@Test
	public void givenABigBasketOfTwoFullCollectionsAndACollectionOfTwo() {
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_CHAMBER_OF_SECRETS);
		basket.add(Books.THE_PRISONER_OF_AZKABAN);
		basket.add(Books.THE_ORDER_OF_THE_PHOENIX);
		basket.add(Books.THE_GOBLET_OF_FIRE);
		
		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_CHAMBER_OF_SECRETS);
		basket.add(Books.THE_PRISONER_OF_AZKABAN);
		basket.add(Books.THE_ORDER_OF_THE_PHOENIX);
		basket.add(Books.THE_GOBLET_OF_FIRE);

		basket.add(Books.THE_PHILOSOPHER_S_STONE);
		basket.add(Books.THE_CHAMBER_OF_SECRETS);
		assertEquals(new Price(75.2), basket.getCost());
	}
}
