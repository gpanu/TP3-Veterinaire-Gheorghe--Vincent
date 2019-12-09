package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dogs.controller.ClientController;
import dogs.controller.DogController;
import dogs.controller.IClientController;
import dogs.controller.IDogController;
import dogs.dto.ClientDTOWithId;
import dogs.dto.DogDTOWithId;
import dogs.model.Client;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.view.IView;
import dogs.view.ShowDogView;
import mock.DogControllerMok;
import mock.ClientDTOMock;
import mock.ClientDTOWithIdMock;
import mock.ClientMock;
import mock.DogControllerMock;
import mock.DogDTOMock;
import mock.DogMock;
import mock.DogDTOWithIdMock;
import mock.EntityMock;
import mock.RepositoryMock;
import mock.ShowDogViewMock;

public class ClientControllerTest{


	
	private static final String ANY_NAME = "bob";
	private static final int ANY_ID = 1;
	private static final int ANY_OWNER_ID = 1;
	private static final int SECOND_OBJECT = 2;
	private static final int FIRST_OBJECT = 1;
	private static final String ANY_CLIENT_NUMBER = "418 418 4188";

	
//	@Before
//	public void setUpDogRepository() {
//		RepositoryMock<Dog> dogs = new RepositoryMock<Dog>();
//		RepositoryMock<Client> clients = new RepositoryMock<Client>();
//		ClientControllerMock clientController = new ClientControllerMock(clients);
//		IDogController dogController = new DogController(dogs, clientController);
//	}

	@Test
	public <T> void WHEN_ClientControllerIsAsked_THEN_ItHasRepo() {
		//Arrange
		RepositoryMock<Client> clients = new RepositoryMock<Client>();
		IClientController clientController = new ClientController(clients);
		//Act
		//Assert
		final IRepository<Client> EXPECTED_REPO = clients;
		IRepository<Client> repoReturned = clientController.getRepo();
		assertEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_ClientControllerIsAsked_AND_RepoIsDiferent_THEN_ItHasTwoRepo() {
		//Arrange
		RepositoryMock<Client> clients = new RepositoryMock<Client>();
		IRepository<Client> repo2 = new RepositoryMock<Client>();
		
		//Act
		IClientController clientController = new ClientController(repo2);
		
		//Assert
		IRepository<Client> repoReturned = clientController.getRepo();
		final IRepository<Client> EXPECTED_REPO = clients;
		assertNotEquals(EXPECTED_REPO, repoReturned);
	}
	
	@Test
	public void WHEN_ClientIsAdded_THEN_returnTrueThatTheMethodIsCalled() {
		//Arrange
		ClientDTOMock entity = new ClientDTOMock(ANY_NAME, ANY_NAME, ANY_CLIENT_NUMBER);
		RepositoryMock<Client> clients = new RepositoryMock<Client>();
		IClientController clientController = new ClientController(clients);
		
		//Act
		clientController.addClientToRepository(entity);
		
		//Assert	
		assertTrue(clients.isCalled());
	}
	
	@Test
	public void WHEN_ClientIsRemoved_THEN_returnTrueThatTheMethodIsCalled() {
		//Arrange
		ClientDTOMock entity = new ClientDTOMock(ANY_NAME, ANY_NAME, ANY_CLIENT_NUMBER);
		RepositoryMock<Client> clients = new RepositoryMock<Client>();
		IClientController clientController = new ClientController(clients);
		clientController.addClientToRepository(entity);
		clientController.addClientToRepository(entity);
				
		//Act
		clientController.deleteClientFromList(FIRST_OBJECT+"");
				
		//Assert
		assertTrue(clients.isCalled());
	}
	
	@Test
	public void WHEN_DogIsModified_THEN_returnTrueIfNotTheSameAnyMore() {
		//Arrange
		final String OTHER_NAME = "chico";
		ClientDTOMock client = new ClientDTOMock(ANY_NAME, ANY_NAME, ANY_CLIENT_NUMBER);
		RepositoryMock<Client> clients = new RepositoryMock<Client>();
		ClientController clientController = new ClientController(clients);
		clientController.addClientToRepository(client);
		//clientController.addClientToRepository(client);
		//List<DogDTOWithId> dogList = dogController.getDTOList();
		//List<ClientDTOWithId> clientList = clientController.getDTOList();
		//IView showDogView = new ShowDogViewMock(dogController, dogList, clientList);
		ClientDTOWithIdMock entityWithId = new ClientDTOWithIdMock(OTHER_NAME, OTHER_NAME, ANY_CLIENT_NUMBER, FIRST_OBJECT);
		
		
		//Act
		clientController.modifyClient(null, entityWithId);
				
		Map<Integer, Client> map = clients.getMap();	
		//Assert
		assertNotSame(map.get(FIRST_OBJECT), client);
	}
}
