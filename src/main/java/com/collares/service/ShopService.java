package com.collares.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collares.domain.Shop;
import com.collares.repository.ShopRepository;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepository shopRepository;

	public void addShop(Shop shopNew) {
		Shop shop = new Shop();
		shop.setNameShop(shopNew.getNameShop());
		shop.setQuantity(shopNew.getQuantity());
		System.out.println(shop.getNameShop());
		System.out.println(shop.getQuantity());
		shopRepository.save(shop);
	}
	
	public Iterable<Shop> getAllShop() {
		return shopRepository.findAll();
	}
	
}
