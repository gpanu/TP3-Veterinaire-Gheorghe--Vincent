package tests;

import dogs.model.Entity;

public abstract class EntityMock extends Entity{

	public EntityMock(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract int getId();
}
