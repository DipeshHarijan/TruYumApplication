package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(01L, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(02L, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(03L, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(04L, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(05L, "Chocoloate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true));
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		MenuItem item;
		Iterator<MenuItem> itr = menuItemList.iterator();
		while (itr.hasNext()) {
			item = new MenuItem();
			item = itr.next();
			if ((item.getDateOfLaunch().before(new Date())) && (item.isActive())) {
				list.add(item);
			}
		}
		return list;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		MenuItem item;
		Integer index = null;
		Iterator<MenuItem> itr = menuItemList.iterator();
		while (itr.hasNext()) {
			item = new MenuItem();
			item = itr.next();
			if (item.equals(menuItem)) {
				index = menuItemList.indexOf(item);
			}
		}
		menuItemList.set(index, menuItem);
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem;
		Iterator<MenuItem> itr = menuItemList.iterator();
		MenuItem menuItem2 = new MenuItem();
		while (itr.hasNext()) {
			menuItem = new MenuItem();
			menuItem = itr.next();
			if (menuItem.getId() == menuItemId) {
				menuItem2 = menuItem;
			}
		}
		return menuItem2;
	}

	public static List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

}
