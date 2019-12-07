package dogs.model;

public class Client extends Entity{
	private String firstName;
	private String lastName;
	private String number;
	private static int nextClient = 1;

	public Client(String firstName, String lastName, String number) {
		super(nextClient);
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		incrementId();
	}

	public void incrementId() {
		nextClient++;
	}

	public int getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public void setId(int id) {
		this.id = id;
		
	}
}
