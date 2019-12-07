package com.collares.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collares.domain.Picture;
import com.collares.repository.PictureRepository;

@Service
public class PictureService {

	@Autowired
	private PictureRepository pictureRepository;

	public Picture addPicture(Picture pictureNew) {
		Picture newPicture = pictureRepository.save(pictureNew);
		return newPicture;
	}

	public Iterable<Picture> getAllPicture() {
		return pictureRepository.findAll();
	}

	public void deleteAllPicture() {
		pictureRepository.deleteAll();
	}

	public void deleteById(int id) {
		pictureRepository.deleteById(id);
	}
}
