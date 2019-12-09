package mock;
import dogs.model.Entity;

public class EntityMock extends Entity{
	protected int id;
	public EntityMock(int id) {
		super(id);
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}
}
