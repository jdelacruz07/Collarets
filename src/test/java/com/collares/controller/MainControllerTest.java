package com.collares.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.collares.domain.Picture;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

	@Autowired
	MainController mainController;

	@Test
	public void testCreatePicture() {
		Picture picture = new Picture();
		picture.setNameArtist("Tere");
		picture.setNamePicture("Lolololo");

		String outcome = mainController.createPicture(picture);

		assertThat(outcome, is(equalTo("success")));
	}

	@Test
	public void testGetallPictures() {

		mainController.getAllPictures().forEach(x -> System.out.println(x));
	}
}
