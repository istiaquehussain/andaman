package com.coe.andaman.ics.util;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.ics.dao.ItemRepository;
import com.coe.andaman.ics.entity.Item;

@Component
public class ServiceInitializer implements CommandLineRunner{
	
	@Autowired
	ItemRepository itemRepository;
	@Override
	public void run(String... args) throws Exception {
		loadItems();
		
	}
	

	public void loadItems()
	{
		Stream.of(
		new Item("Apple","IPhone-X"),
		new Item("Apple","Mac Book Pro"),
		new Item("Sony","PS4 Pro"),
		new Item("Microsoft","XBox One X"),
		new Item("Kingston","Hyper X Cloud"),
		new Item("LG","LG Transformer"))
		.forEach(item->itemRepository.save(item));
		System.out.println(" Item DB Initialized successfully........");
	}
	
	
}
