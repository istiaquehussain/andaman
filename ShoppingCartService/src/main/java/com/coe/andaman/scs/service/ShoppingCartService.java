package com.coe.andaman.scs.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.scs.entity.Cart;

public interface ShoppingCartService {
	public void createCart(Cart item);
	public Optional<Cart> getCartById(long id);
	public List<Cart> getAllCart();
}

