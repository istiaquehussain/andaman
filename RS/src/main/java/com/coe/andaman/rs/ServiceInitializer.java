package com.coe.andaman.rs;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceInitializer implements CommandLineRunner{
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadCustomers();
		loadUsers();
		loadItems();
		loadCarts();
		
	}
	
	public void loadCustomers()
	{
		Stream.of(
		new Customer("ihuss","Istiaque","Hussain",new Address("Bangalore", "India", "560029")),
		new Customer("robb","Roy","Williams",new Address("Melbourne", "Australlia", "6003")),
		new Customer("mzafar","Mirza","Zafar",new Address("Hydrabad", "India", "490029")),
		new Customer("jshell","Jessica","Shelly",new Address("California", "USA", "71005")))
		.forEach(customer->customerRepository.save(customer));
		
		System.out.println(" Cutomer DB Initialized successfully........");
	}
	
	public void loadUsers()
	{
		Stream.of(new User("ihuss","pwd",Arrays.asList(new Role("USER"))),
				new User("robb","pwd",Arrays.asList(new Role("USER"))),
				new User("mzafar","pwd",Arrays.asList(new Role("USER"))),
				new User("jshell","pwd",Arrays.asList(new Role("USER"))),
				new User("admin","pwd",Arrays.asList(new Role("USER"),new Role("ADMIN"))),
				new User("dba","pwd",Arrays.asList(new Role("DBA")))
				).forEach(user->userRepository.save(user));
		
		
		System.out.println(" User DB Initialized successfully........");
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
	
	public void loadCarts()
	{
		Stream.of(
		new Cart(1L,3L),
		new Cart(2L,3L),
		new Cart(3L,5L),
		new Cart(3L,2L),
		new Cart(4L,1L),
		new Cart(4L,5L))
		.forEach(cart->cartRepository.save(cart));
		System.out.println(" Cart DB Initialized successfully........");
	}
	
}
