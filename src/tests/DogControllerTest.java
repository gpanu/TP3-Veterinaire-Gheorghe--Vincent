package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import dogs.controller.DogController;
import dogs.model.IRepository;
import dogs.model.Repository;

public class DogControllerTest{


	
	@Test
	public void WHEN_DogControllerIsAsked_THEN_ItHasRepo() {
		//Arrange
		IRepository repo = new ReposytoryMock();
		
		//Act
		DogController dogController = new DogController(repo);
		IRepository repoReturned = dogController.getRepo();
		
		//Assert
		final IRepository EXPECTED_REPO = repo;
		assertEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_DogControllerIsAsked_AND_RepoIsDiferent_THEN_ItHasRepo() {
		//Arrange
		IRepository repo = new ReposytoryMock();
		IRepository repo2 = new ReposytoryMock();
		
		//Act
		DogController dogController = new DogController(repo2);
		IRepository repoReturned = dogController.getRepo();
		
		//Assert
		final IRepository EXPECTED_REPO = repo;
		assertNotEquals(EXPECTED_REPO, repoReturned);
	}

	

	

}
