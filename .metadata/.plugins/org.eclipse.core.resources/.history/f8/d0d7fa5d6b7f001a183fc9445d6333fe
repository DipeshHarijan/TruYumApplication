package com.cognizant.truyum.dao;

import com.cognizant.truyum.exception.CartEmptyException;

public class CartDaoCollectionImplTest {
	public static void main(String args[]) throws CartEmptyException {
		System.out.println("Adding items to cart");
		testAddCartItem();
		System.out.println("Getting all the items added to cart");
		testGetAllCartItems();
		System.out.println("Removing some cart items");
		testRemoveCartItem();
		System.out.println("After removing");
		testGetAllCartItems();
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		try{
			cartDao.removeCartItem(1, 4);
		}
		catch (NullPointerException e){
			System.out.println("The cart for user doesn't exist");
		}
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println(cartDao.getAllCartItems(1));
	}

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 01L);
		cartDao.addCartItem(1, 03L);
		cartDao.addCartItem(1, 04L);
	}
}
