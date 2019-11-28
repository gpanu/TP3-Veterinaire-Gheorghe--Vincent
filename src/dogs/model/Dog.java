package dogs.model;

public class Dog extends Entity{  // La classe est tr�s simple ici mais il pourrait avoir des validations ou des algos plus complexes.
	
	private String name;
	private String breed;
	private static int nextDog = 1;
	
	public Dog(String name, String breed) {
		//TODO: calculer l'id --> un no unique pour identifier un chien
		super(nextDog);
		this.name = name;
		this.breed = breed;
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
	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

}
