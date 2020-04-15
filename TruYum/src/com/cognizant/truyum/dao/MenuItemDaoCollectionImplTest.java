package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void main(String[] args) throws ParseException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		menuItemList.addAll(menuItemDao.getMenuItemListAdmin());
		Iterator<MenuItem> itr = menuItemList.iterator();
		System.out.println("\nAdmin:");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
			System.out.println();
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		menuItemList.addAll(menuItemDao.getMenuItemListCustomer());
		Iterator<MenuItem> itr = menuItemList.iterator();
		System.out.println("\nCustomer:");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
			System.out.println();
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem menuItem = new MenuItem(01L, "Sandwich", 100.00f, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("\nModify:");
		System.out.println(menuItemDao.getMenuItem(menuItem.getId()));
	}
}
