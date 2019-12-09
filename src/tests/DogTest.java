package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import dogs.model.Dog;

public class DogTest {
	private static final String ANY_NAME = "bob";
	private static final String ANY_BREED = "Stav";
	private static final int  ANY_OWNER_ID = 1;
	Dog dog;

	@Before
	public void createClient() {
		dog = new Dog(ANY_NAME, ANY_BREED, ANY_OWNER_ID);
	}
	
	@Test
	public void WHEN_DogIsCreated_THEN_returnTheName() {
		//Arrange
		//Act
		//Assert
		assertEquals(ANY_NAME, this.dog.getName());
	}
	
	@Test
	public void WHEN_DogIsCreated_THEN_returnTheBreed() {
		//Arrange
		//Act
		//Assert
		assertEquals(ANY_BREED, this.dog.getBreed());
	}
	
	@Test
	public void WHEN_DogIsCreated_THEN_returnTheOwnerId() {
		//Arrange
		//Act
		//Assert
		assertEquals(ANY_OWNER_ID, this.dog.getOwnerId());
	}
}
