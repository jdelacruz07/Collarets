package com.collares;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collares.repository.PictureRepository;
import com.collares.repository.ShopRepository;

@Controller
@RequestMapping(path = "/shops")
public class MainController {

	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private PictureRepository pictureRepository;

	public MainController(ShopRepository shopRepository, PictureRepository pictureRepository) {
		super();
		this.shopRepository = shopRepository;
		this.pictureRepository = pictureRepository;
	}

	@PostMapping
	@ResponseBody
	public void createShop(@RequestBody Shop shopNew) {

		Shop shop = new Shop();
		shop.setNameShop(shopNew.getNameShop());
		shop.setQuantity(shopNew.getQuantity());
		shopRepository.save(shop);
	}

	@GetMapping
	@ResponseBody
	public Iterable<Shop> getAllShops() {
		return shopRepository.findAll();
	}

	@PostMapping(path = "/pictures")
	@ResponseBody
	public void createPicture(@RequestBody Picture pictureNew) {

		Picture picture = new Picture();
		picture.setNameArtist(pictureNew.getNameArtist());
		picture.setNamePicture(pictureNew.getNamePicture());
		pictureRepository.save(picture);
	}

	@GetMapping(path = "/pictures")
	@ResponseBody
	public Iterable<Picture> getAllPictures() {

		return pictureRepository.findAll();
	}

	@DeleteMapping(path = "/pictures")
	@ResponseBody
	public void deletePictures() {
		pictureRepository.deleteAll();
	}

	@DeleteMapping(path = "/{id}/pictures")
	@ResponseBody
	public void deletePictures(@PathVariable("id") int id) {
		pictureRepository.deleteById(id);
	}

}