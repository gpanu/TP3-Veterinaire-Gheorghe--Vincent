package dogs.model;

public class Dog extends Entity{  // La classe est très simple ici mais il pourrait avoir des validations ou des algos plus complexes.
	
	private String name;
	private String breed;
	private int ownerId;
	private static int nextDog = 1;
	
	public Dog(String name, String breed, int ownerId) {
		//TODO: calculer l'id --> un no unique pour identifier un chien
		super(nextDog);
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
	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setId(int id) {
		this.id = id;
		
	}


}
