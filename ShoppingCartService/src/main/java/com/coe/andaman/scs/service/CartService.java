package com.coe.andaman.scs.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.scs.entity.Cart;

public interface CartService {
	
	public Optional<Cart> findCartById(Long id);
	public List<Cart> findAllCarts();
	public Cart createCart(Cart cart);
	
	

}
