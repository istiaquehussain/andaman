package com.coe.andaman.ics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coe.andaman.ics.entity.Item;
import com.coe.andaman.ics.service.ItemService;
import com.coe.andaman.ics.util.CustomException;

@RestController
public class ItemServiceController {
	
	
	@Autowired
	ItemService itemService;
	@GetMapping("/items/id/{id}")
	public ResponseEntity<?> findItemById(@PathVariable("id") Long id) throws Exception
	{
		Item items=itemService.findItemById(id).orElseThrow(()->new CustomException(HttpStatus.BAD_REQUEST,"Item Not found for ID "+id));
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	@GetMapping("/items/brand/{id}")
	public ResponseEntity<?> findItemByBrand(@PathVariable("id") String brand) throws Exception
	{
		Item items=itemService.findItemByBrand(brand).orElseThrow(()->new CustomException(HttpStatus.BAD_REQUEST,"Item Not found for brand "+brand));
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	@GetMapping("/items")
	public ResponseEntity<?> findAllItems()
	{
		List<Item> item=itemService.findAllItems();
		return new ResponseEntity<List<Item>>(item,HttpStatus.OK);
	}
	@PostMapping("/items")
	public ResponseEntity<?> createItem(Item item)
	{
		Item itemsCreated=itemService.createItem(item);
		return new ResponseEntity<>(itemsCreated,HttpStatus.OK);
	}
}
