package com.coe.andaman.ics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coe.andaman.ics.dao.ItemRepository;
import com.coe.andaman.ics.entity.Item;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemRepository itemRepository;
	
	public Optional<Item> findItemById(Long id)
	{
		return itemRepository.findById(id);
	}
	
	public Optional<Item> findItemByBrand(String brand)
	{
		return itemRepository.findItemByBrand(brand);
	}
	
	public List<Item> findAllItems()
	{
		return itemRepository.findAll();
	}
	public Item createItem(Item item)
	{
		return itemRepository.save(item);
	}
	
	

}
