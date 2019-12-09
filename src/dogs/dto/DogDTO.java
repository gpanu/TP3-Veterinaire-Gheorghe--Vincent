package dogs.dto;

public class DogDTO {
	public String name;
	public String breed;
	public int ownerId;
	
	public DogDTO(String name, String breed, int ownerId) {
		this.name = name;
		this.breed = breed;
		this.ownerId = ownerId;
	}

}
