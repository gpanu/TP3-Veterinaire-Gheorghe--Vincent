package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import dogs.controller.DogController;
import dogs.repository.Repository;
import dogs.repository.IRepository;

public class DogControllerTest{


	
	@Test
	public void WHEN_DogControllerIsAsked_THEN_ItHaveRepo() {
		//Arrange
		IRepository repo = new DogRepositorySpy();
		
		//Act
		DogController dogController = new DogController(repo);
		IRepository repoReturned = dogController.getRepo();
		
		//Assert
		final IRepository EXPECTED_REPO = repo;
		assertEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_DogControllerIsAsked_AND_RepoIsDiferent_THEN_ItHaveRepo() {
		//Arrange
		IRepository repo = new DogRepositorySpy();
		IRepository repo2 = new DogRepositorySpy();
		
		//Act
		DogController dogController = new DogController(repo2);
		IRepository repoReturned = dogController.getRepo();
		
		//Assert
		final IRepository EXPECTED_REPO = repo;
		assertNotEquals(EXPECTED_REPO, repoReturned);
	}


}
