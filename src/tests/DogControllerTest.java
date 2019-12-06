package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import dogs.controller.DogController;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.model.Repository;

public class DogControllerTest{


	
	@Test
	public <T> void WHEN_DogControllerIsAsked_THEN_ItHasRepo() {
		//Arrange
		IRepository<Dog> repo = new ReposytoryMock<Dog>();
		
		//Act
		DogController dogController = new DogController(repo, null);
		IRepository<Dog> repoReturned = dogController.getRepo();
		
		//Assert
		final IRepository<Dog> EXPECTED_REPO = repo;
		assertEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_DogControllerIsAsked_AND_RepoIsDiferent_THEN_ItHasRepo() {
		//Arrange
		IRepository<Dog> repo = new ReposytoryMock<Dog>();
		IRepository<Dog> repo2 = new ReposytoryMock<Dog>();
		
		//Act
		DogController dogController = new DogController(repo2, null);
		IRepository<Dog> repoReturned = dogController.getRepo();
		
		//Assert
		final IRepository<Dog> EXPECTED_REPO = repo;
		assertNotEquals(EXPECTED_REPO, repoReturned);
	}

	

	

}
