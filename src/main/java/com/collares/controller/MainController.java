package com.collares.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collares.domain.Picture;
import com.collares.domain.Shop;
import com.collares.service.PictureService;
import com.collares.service.ShopService;

@RestController
@RequestMapping(path = "/shops")
public class MainController {
	private ShopService shopService;
	private PictureService pictureService;

	@Autowired
	public MainController(ShopService shopService, PictureService pictureService) {
		super();
		this.shopService = shopService;
		this.pictureService = pictureService;
	}

	@PostMapping
	public void createShop(@RequestBody Shop shopNew) {
		shopService.addShop(shopNew);
	}

	@GetMapping
	public Iterable<Shop> getAllShops() {
		return shopService.getAllShop();
	}

	@PostMapping(path = "/pictures")
	public String createPicture(@RequestBody Picture pictureNew) {
		Picture newPicture = pictureService.addPicture(pictureNew);
		if (newPicture != null) {
			return "success";
		}
		return "failure";
	}

	@GetMapping(path = "/pictures")
	public Iterable<Picture> getAllPictures() {

		return pictureService.getAllPicture();
	}

	@DeleteMapping(path = "/pictures")
	public void deleteAllPictures() {
		pictureService.deleteAllPicture();
	}

	@DeleteMapping(path = "/{id}/pictures")
	public void deletePictures(@PathVariable("id") int id) {
		pictureService.deleteById(id);
	}

}