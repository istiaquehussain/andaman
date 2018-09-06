package com.coe.andaman.ics.util;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.ics.dao.ItemRepository;
import com.coe.andaman.ics.entity.Item;

@Component
public class ItemCatalogInitializer implements CommandLineRunner{
	@Autowired
	ItemRepository repository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Intializing Item DB ........");
		Stream.of(	new Item("Item1_Name","Item1 Description"),
					new Item("Item2_Name","Item2 Description"),
					new Item("Item3_Name","Item3 Description"),
					new Item("Item4_Name","Item4 Description"),
					new Item("Item5_Name","Item4 Description")).forEach(item->repository.save(item));
	
		System.out.println(" Item DB Initialized successfully........");
	}
	
}
