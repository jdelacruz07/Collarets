package com.collares.repository;

import org.springframework.data.repository.CrudRepository;

import com.collares.domain.Picture;

public interface PictureRepository extends CrudRepository<Picture, Integer> {

	public Picture findByNamePicture(String NamePicture);
}
