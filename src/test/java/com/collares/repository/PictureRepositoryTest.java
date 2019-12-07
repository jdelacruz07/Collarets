package com.collares.repository;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.collares.domain.Picture;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PictureRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PictureRepository pictureRepository;

	@Test
	public void testFindByNamePicture() {
		Picture picture = new Picture();
		picture.setNamePicture("Moon");

		entityManager.persistAndFlush(picture);

		Picture foundPicture = pictureRepository.findByNamePicture("Moon");
		assertNotNull(foundPicture.getNamePicture());
	}
}
