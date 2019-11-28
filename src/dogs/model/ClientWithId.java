package dogs.model;

public class ClientWithId {
	private String firstName;
	private String lastName;
	private String number;
	public int id;
		
	public ClientWithId(String firstName, String lastName, String number, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.id = id;
	}

}
