package com.coe.andaman.ics.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coe.andaman.ics.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	Optional<Item> findItemByBrand(String brand);

}
