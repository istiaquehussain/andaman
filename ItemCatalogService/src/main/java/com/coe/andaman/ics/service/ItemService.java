package com.coe.andaman.ics.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.ics.entity.Item;
public interface ItemService {
	
	public Optional<Item> findItemById(Long id);
	
	public Optional<Item> findItemByBrand(String brand);
	
	public List<Item> findAllItems();
	public Item createItem(Item item);
	
	

}
