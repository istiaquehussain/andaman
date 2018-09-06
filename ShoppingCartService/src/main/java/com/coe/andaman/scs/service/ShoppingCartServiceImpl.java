package com.coe.andaman.scs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coe.andaman.scs.dao.CartRepository;
import com.coe.andaman.scs.entity.Cart;
@Service("ShoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	CartRepository repository;
	@Override
	public void createCart(Cart item) {
		repository.save(item);

	}

	@Override
	public Optional<Cart> getCartById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Cart> getAllCart() {
		return repository.findAll();
	}

}
