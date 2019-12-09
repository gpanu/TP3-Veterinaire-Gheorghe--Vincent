package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dogs.controller.DogController;
import dogs.controller.IDogController;
import dogs.model.Client;
import dogs.model.Dog;
import dogs.model.IRepository;
import mock.DogControllerMok;
import mock.DogDTOMock;
import mock.RepositoryMock;


public class DogControllerTest{
	
	private static final String ANY_NAME = "bob";
	private static final int ANY_OWNER_ID = 1;
	private static final int FIRST_OBJECT = 1;
	
//	@Before
//	public void setUpDogRepository() {
//		RepositoryMock<Dog> dogs = new RepositoryMock<Dog>();
//		RepositoryMock<Client> clients = new RepositoryMock<Client>();
//		ClientControllerMock clientController = new ClientControllerMock(clients);
//		IDogController dogController = new DogController(dogs, clientController);
//	}

	@Test
	public <T> void WHEN_DogControllerIsAsked_THEN_ItHasRepo() {
		//Arrange
		RepositoryMock<Dog> dogs = new RepositoryMock<Dog>();
		IDogController dogController = new DogController(dogs, null);
		//Act
		//Assert
		final IRepository<Dog> EXPECTED_REPO = dogs;
		IRepository<Dog> repoReturned = dogController.getRepo();
		assertEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_DogControllerIsAsked_AND_RepoIsDiferent_THEN_ItHasRepo() {
		//Arrange
		RepositoryMock<Dog> dogs = new RepositoryMock<Dog>();
		IRepository<Dog> repo2 = new RepositoryMock<Dog>();
		
		//Act
		IDogController dogController = new DogController(repo2, null);
		
		//Assert
		IRepository<Dog> repoReturned = dogController.getRepo();
		final IRepository<Dog> EXPECTED_REPO = dogs;
		assertNotEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_DogIsAdded_THEN_returnTrueThatTheMethodIsCalled() {
		//Arrange
		DogDTOMock entity = new DogDTOMock(ANY_NAME, ANY_NAME, ANY_OWNER_ID);
		RepositoryMock<Dog> dogs = new RepositoryMock<Dog>();
		RepositoryMock<Client> clients = new RepositoryMock<Client>();
		DogControllerMok clientController = new DogControllerMok(clients);
		IDogController dogController = new DogController(dogs, clientController);
		
		//Act
		dogController.addDogToRepository(entity);
		
		//Assert	
		assertTrue(dogs.isCalled());
	}
	
	@Test
	public void WHEN_DogIsRemoved_THEN_returnTrueThatTheMethodIsCalled() {
		//Arrange
		DogDTOMock entity = new DogDTOMock(ANY_NAME, ANY_NAME, ANY_OWNER_ID);
		RepositoryMock<Dog> dogs = new RepositoryMock<Dog>();
		RepositoryMock<Client> clients = new RepositoryMock<Client>();
		DogControllerMok clientController = new DogControllerMok(clients);
		IDogController dogController = new DogController(dogs, clientController);
		dogController.addDogToRepository(entity);
		dogController.addDogToRepository(entity);
				
		//Act
		dogController.deleteDogFromList(FIRST_OBJECT+"");
				
		//Assert
		assertTrue(dogs.isCalled());
	}

	
	//Nous avons essayer de tester ce comportement mais nous n'avont pas ete capable... nous le lesson quand meme pour montrer que
	//nous l'avon essaillé

//	@Test
//	public void WHEN_DogIsModified_THEN_returnTrueIfNotTheSameAnyMore() {
//		//Arrange
//		final String OTHER_NAME = "chico";
//		DogDTOMock dog = new DogDTOMock(ANY_NAME, ANY_NAME, ANY_OWNER_ID);
//		//ClientDTOMock client = new ClientDTOMock(ANY_NAME, ANY_NAME, ANY_CLIENT_NUMBER);
//		RepositoryMock<Dog> dogs = new RepositoryMock<Dog>();
//		//RepositoryMock<Client> clients = new RepositoryMock<Client>();
//		//ClientControllerMock clientController = new ClientControllerMock(clients);
//		IDogController dogController = new DogController(dogs, null);
//		dogController.addDogToRepository(dog);
//		//clientController.addClientToRepository(client);
//		//List<DogDTOWithId> dogList = dogController.getDTOList();
//		//List<ClientDTOWithId> clientList = clientController.getDTOList();
//		//IView showDogView = new ShowDogViewMock(dogController, dogList, clientList);
//		DogDTOWithIdMock entityWithId = new DogDTOWithIdMock(OTHER_NAME, OTHER_NAME, FIRST_OBJECT, ANY_OWNER_ID);
//		
//		
//		//Act
//		dogController.modifyDog(null, entityWithId);
//				
//		Map<Integer, Dog> map = dogs.getMap();	
//		//Assert
//		assertNotSame(map.get(FIRST_OBJECT), dog);
//	}
}
