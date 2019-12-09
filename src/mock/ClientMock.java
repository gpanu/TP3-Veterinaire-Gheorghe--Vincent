package mock;

public class ClientMock extends EntityMock{

	
	private String firstName;
	private String lastName;
	private String number;
	private static int nextClient = 1;

	public ClientMock(String firstName, String lastName, String number) {
		super(nextClient);
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		incrementId();
	}

	private void incrementId() {
		nextClient++;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getNumber() {
		return this.number;
	}
}
