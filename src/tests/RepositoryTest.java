package tests;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dogs.model.Repository;

public class RepositoryTest {
	
	
	
	private final String ANY_NAME = "bob";
	private final String ANY_NUMBER = "418 418 4188";
	private static final int ANY_ID = 1;
	Repository<EntityMock> repository;
	
	@Before
	public void createEntity() {
		this.repository = new Repository<EntityMock>();
	}

	@Test
	public void WHEN_EntityIsAddedIntoRepository_THEN_VerifyThatItIsInRepository() {
		//Arrange
		EntityMock entity = new ClientDTOMock(ANY_NAME, ANY_NAME, ANY_NUMBER);
		
		//Act
		this.repository.add(entity);
		
		//Assert
		assertTrue(this.repository.getList().contains(entity));
	}

	@Test
	public void WHEN_EntityFromRepositoryIsModified_THEN_TheEntityIsNoMoreTheSame() {
		//Arrange
		EntityMock entity = new ClientDTOMock(ANY_NAME, ANY_NAME, ANY_NUMBER);
		this.repository.add(entity);
		final String OTHER_NAME = "jimy";
		ClientDTOMock newEntityElements = new ClientDTOMock(OTHER_NAME, OTHER_NAME, ANY_NUMBER);
		//Act
		this.repository.modify(ANY_ID, newEntityElements);
		Map<Integer, EntityMock> map = this.repository.getMap();	
		
		//Assert
		assertNotSame(map.get(ANY_ID), entity);
	}
	
}
