package com.coe.andaman.scs.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coe.andaman.scs.entity.Cart;
import com.coe.andaman.scs.entity.Customer;
import com.coe.andaman.scs.entity.Item;
import com.coe.andaman.scs.service.ShoppingCartService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/scs")
public class ShoppingCartController {
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("ShoppingCartService")
	ShoppingCartService shoppingCartService;
	
	@Autowired
    private EurekaClient eurekaClient;
	
	@Value("${service.customersearch.serviceId}")
    private String customerSearchServiceId;
	
	@Value("${service.itemsearch.serviceId}")
    private String itemSearchServiceId;
	
	@GetMapping("/carts")
	ResponseEntity<?> getAllCart()
	{
		return new ResponseEntity<List<Cart>>(shoppingCartService.getAllCart(),HttpStatus.OK);
	}
	@GetMapping("/carts/{id}")
	ResponseEntity<?> getCartById(@PathVariable("id") String id) throws Exception
	{
		Cart cart=shoppingCartService.getCartById(Long.parseLong(id)).orElseThrow(()->new Exception("Customer Not found for id "+id));
		Customer customerDetails = getCustomerDetailsForId(cart.getUserId().toString());
		Item itemDetails =getItemDetailsForId(cart.getItemId().toString());
		cart.setCustomerDeails(customerDetails);
		cart.setItemDeails(itemDetails);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	@GetMapping("/carts/customer/{id}")
	ResponseEntity<?> getCartByCutomerId(@PathVariable("id") String id) throws Exception
	{
		Cart cart=shoppingCartService.getCartById(Long.parseLong(id)).orElseThrow(()->new Exception("Customer Not found for id "+id));

		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	private Customer getCustomerDetailsForId(String id)
	{
		Application application = eurekaClient.getApplication(customerSearchServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "cs/customers/" + id;
        System.out.println("URL" + url);
        return restTemplate.getForObject(url, Customer.class);
	}
	
	private Item getItemDetailsForId(String id)
	{
		Application application = eurekaClient.getApplication(itemSearchServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "ics/items/" + id;
        System.out.println("URL" + url);
        return restTemplate.getForObject(url, Item.class);
	}
}
