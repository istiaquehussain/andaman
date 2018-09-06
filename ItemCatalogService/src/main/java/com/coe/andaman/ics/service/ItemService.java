package com.coe.andaman.ics.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.ics.entity.Item;

public interface ItemService {
	public void createItem(Item item);
	public Optional<Item> getItemById(long id);
	public List<Item> getAllItem();
}

