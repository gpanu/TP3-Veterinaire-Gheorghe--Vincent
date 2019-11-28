package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import dogs.controller.DogController;
import dogs.repository.DogRepository;
import dogs.repository.IDogRepository;

public class DogControllerTest{


	
	@Test
	public void WHEN_DogControllerIsAsked_THEN_ItHaveRepo() {
		//Arrenge
		IDogRepository repo = new DogRepositorySpy();
		
		//Act
		DogController dogController = new DogController(repo);
		IDogRepository repoReturned = dogController.getRepo();
		
		//Assert
		final IDogRepository EXPECTED_REPO = repo;
		assertEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_DogControllerIsAsked_AND_RepoIsDiferent_THEN_ItHaveRepo() {
		//Arrenge
		IDogRepository repo = new DogRepositorySpy();
		IDogRepository repo2 = new DogRepositorySpy();
		
		//Act
		DogController dogController = new DogController(repo2);
		IDogRepository repoReturned = dogController.getRepo();
		
		//Assert
		final IDogRepository EXPECTED_REPO = repo;
		assertNotEquals(EXPECTED_REPO, repoReturned);
	}


}
