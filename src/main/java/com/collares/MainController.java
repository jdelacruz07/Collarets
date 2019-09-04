package com.collares;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collares.repository.PictureRepository;
import com.collares.repository.ShopRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/shops") // This means URL's start with /demo (after Application path)
public class MainController {
	
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private ShopRepository shopRepository;
	@Autowired
	private PictureRepository pictureRepository;


	public MainController(ShopRepository shopsRepository, PictureRepository pictureRepository) {
		super();
		this.shopRepository = shopsRepository;
		this.pictureRepository = pictureRepository;
	}

	@GetMapping
	public @ResponseBody Iterable<Shop> getAllShops() {
		return shopRepository.findAll();
	}

	@GetMapping(path = "/pictures")
	public @ResponseBody Iterable<Picture> getAllPictures() {
		return pictureRepository.findAll();
	}

	@DeleteMapping(path = "/delete/pictures")
	public void deletePictures() {
		pictureRepository.deleteAll();
	}
	
	
//	@PostMapping(path="/add") // Map ONLY POST Requests
//	public @ResponseBody String addNewUser (@RequestParam String name
//			, @RequestParam String email) {
//		// @ResponseBody means the returned String is the response, not a view name
//		// @RequestParam means it is a parameter from the GET or POST request
//
//		User n = new User();
//		n.setName(name);
//		n.setEmail(email);
//		userRepository.save(n);
//		return "Saved";
//	}

}