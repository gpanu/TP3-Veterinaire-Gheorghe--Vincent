package mock;

public class DogMock extends EntityMock{

	private static int nextDog = 1;
	private String name;
	private String breed;
	private int ownerId;
	
	public DogMock(String name, String breed, int ownerId) {
		super(nextDog);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.breed = breed;
		this.ownerId = ownerId;
		incrementId();
	}

	public void incrementId() {
		nextDog++;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOwnerId() {
		return this.ownerId;
	}

	public String getBreed() {
		return breed;
	}
}
