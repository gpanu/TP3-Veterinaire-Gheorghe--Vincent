package dogs.dto;

public class ClientDTOWithId {
	private String firstName;
	private String lastName;
	private String number;
	public int id;
		
	public ClientDTOWithId(String firstName, String lastName, String number, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.id = id;
	}

}
