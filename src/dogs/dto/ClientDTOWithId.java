package dogs.dto;

public class ClientDTOWithId {
	public String firstName;
	public String lastName;
	public String number;
	public int id;
		
	public ClientDTOWithId(String firstName, String lastName, String number, int clientId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.id = clientId;
	}

}
