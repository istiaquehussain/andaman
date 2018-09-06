package com.coe.andaman.ics.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coe.andaman.ics.entity.Item;
import com.coe.andaman.ics.service.ItemService;

@RestController
@RequestMapping("/ics")
public class ItemServiceController {
	@Autowired
	@Qualifier("ItemService")
	ItemService itemService;
	@GetMapping("/items")
	ResponseEntity<?> getAllItem()
	{
		return new ResponseEntity<List<Item>>(itemService.getAllItem(),HttpStatus.OK);
	}
	@GetMapping("/items/{id}")
	ResponseEntity<?> getItemById(@PathVariable("id") String id) throws Exception
	{
		Item item=itemService.getItemById(Long.parseLong(id)).orElseThrow(()->new Exception("Customer Not found for id "+id));

		return new ResponseEntity<>(item,HttpStatus.OK);
	}
}
