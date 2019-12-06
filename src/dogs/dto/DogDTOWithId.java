package dogs.dto;

public class DogDTOWithId {
	public String name;
	public String breed;
	public int id;
	public int ownerId;
	public String ownerName;
	
	public DogDTOWithId(String name, String breed, int id, int ownerId) {
		this.name = name;
		this.breed = breed;
		this.id = id;
		this.ownerId = ownerId;
	}

}
