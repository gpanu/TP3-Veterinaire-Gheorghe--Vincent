package dogs.repository;

public abstract class Entity {
	
	protected Integer id;

	public Entity(int id) {
		this.id = id;
	}

	public abstract int getId();

}
