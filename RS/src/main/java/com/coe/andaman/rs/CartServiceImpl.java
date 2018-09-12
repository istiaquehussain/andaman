package com.coe.andaman.rs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepository cartRepository;
	
	public Optional<Cart> findCartById(Long id)
	{
		return cartRepository.findById(id);
	}
	
	public List<Cart> findAllCarts()
	{
		return cartRepository.findAll();
	}
	public Cart createCart(Cart cart)
	{
		return cartRepository.save(cart);
	}
	
	

}
