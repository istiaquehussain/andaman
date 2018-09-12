package com.coe.andaman.rs;

import java.util.List;
import java.util.Optional;

public interface CartService {
	
	public Optional<Cart> findCartById(Long id);
	public List<Cart> findAllCarts();
	public Cart createCart(Cart cart);
	
	

}
