package com.coe.andaman.scs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coe.andaman.scs.entity.Cart;
public interface CartRepository extends JpaRepository<Cart, Long> {

}
