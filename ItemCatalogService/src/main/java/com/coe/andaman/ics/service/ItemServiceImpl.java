package com.coe.andaman.ics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coe.andaman.ics.dao.ItemRepository;
import com.coe.andaman.ics.entity.Item;
@Service("ItemService")
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository repository;
	@Override
	public void createItem(Item item) {
		repository.save(item);

	}

	@Override
	public Optional<Item> getItemById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Item> getAllItem() {
		return repository.findAll();
	}

}
