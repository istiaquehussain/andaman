package com.coe.andaman.scs.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coe.andaman.scs.entity.Cart;
import com.coe.andaman.scs.entity.Customer;
import com.coe.andaman.scs.entity.Item;
import com.coe.andaman.scs.service.CartService;
import com.coe.andaman.scs.util.CustomException;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class ShoppingCartController {
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	CartService shoppingCartService;
	
	@Autowired
    private EurekaClient eurekaClient;
	
	@Value("${service.customer.serviceId}")
    private String customerSearchServiceId;
	
	@Value("${service.item.serviceId}")
    private String itemSearchServiceId;
	
	private static final Logger LOGGER = LogManager.getLogger(ShoppingCartController.class);
	
	@GetMapping("/carts")
	ResponseEntity<?> getAllCart()
	{
		return new ResponseEntity<List<Cart>>(shoppingCartService.findAllCarts(),HttpStatus.OK);
	}
	@GetMapping("/carts/{id}")
	ResponseEntity<?> getCartById(@PathVariable("id") Long id) throws Exception
	{
		Customer customerDetails = null;
		Item itemDetails = null;
		Cart cart=shoppingCartService.findCartById(id).orElseThrow(()->new CustomException(HttpStatus.BAD_REQUEST,"Cart Not found for id "+id));
		try
		{
			customerDetails = getCustomerDetailsForId(cart.getId().toString());
			itemDetails =getItemDetailsForId(cart.getItemId().toString());
		}
		catch(Exception ex)
		{
			LOGGER.error("Could not access Customer Service + Item Catalog Service as - > " + ex.getLocalizedMessage());
		}
		cart.setCustomerDeails(customerDetails);
		cart.setItemDeails(itemDetails);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	
	private Customer getCustomerDetailsForId(String id) throws Exception
	{
		Application application = eurekaClient.getApplication(customerSearchServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "cus/customers/" + id;
		LOGGER.info("Customer Service URL" + url);
        return restTemplate.getForObject(url, Customer.class);
	}
	
	private Item getItemDetailsForId(String id) throws Exception
	{
		Application application = eurekaClient.getApplication(itemSearchServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "ics/items/" + id;
		LOGGER.info("Item Catalog Service URL" + url);
        return restTemplate.getForObject(url, Item.class);
	}
}
