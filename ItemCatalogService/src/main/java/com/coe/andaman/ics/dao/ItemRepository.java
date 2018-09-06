package com.coe.andaman.ics.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coe.andaman.ics.entity.Item;
public interface ItemRepository extends JpaRepository<Item, Long> {

}
