package com.coe.andaman.rs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public interface ItemService {
	
	public Optional<Item> findItemById(Long id);
	
	public Optional<Item> findItemByBrand(String brand);
	
	public List<Item> findAllItems();
	public Item createItem(Item item);
	
	

}
