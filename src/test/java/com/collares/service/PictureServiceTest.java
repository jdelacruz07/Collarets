package com.collares.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.collares.domain.Picture;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class PictureServiceTest {

	@Autowired
	PictureService pictureService;

	@Test
	public void test() {
		Picture picture = new Picture();
		picture.setNameArtist("Teresita");
		picture.setNamePicture("Ocaso");

		Picture newPicture = pictureService.addPicture(picture);

		assertNotNull(newPicture);
		assertNotNull(newPicture.getNamePicture());
		assertEquals("Teresita", newPicture.getNameArtist());

	}

	@Ignore
	@Test
	public void testDeleteAllPictures() {

		pictureService.deleteAllPicture();
	}
}
