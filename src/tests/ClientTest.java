package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dogs.model.Client;

public class ClientTest {
	private static final String ANY_FIRST_NAME = "bob";
	private static final String ANY_LAST_NAME = "Stav";
	private static final String ANY_PHONE_NUMBER = "418 418 4188";
	Client client;

	@Before
	public void createClient() {
		client = new Client(ANY_FIRST_NAME, ANY_LAST_NAME, ANY_PHONE_NUMBER);
	}
	
	@Test
	public void WHEN_ClientIsCreated_THEN_returnTheFirstName() {
		//Arrange
		//Act
		//Assert
		assertEquals(ANY_FIRST_NAME, this.client.getFirstName());
	}
	
	@Test
	public void WHEN_ClientIsCreated_THEN_returnTheLastName() {
		//Arrange
		//Act
		//Assert
		assertEquals(ANY_LAST_NAME, this.client.getLastName());
	}
	
	@Test
	public void WHEN_ClientIsCreated_THEN_returnTheNumber() {
		//Arrange
		//Act
		//Assert
		assertEquals(ANY_PHONE_NUMBER, this.client.getNumber());
	}
}
