package dogs;
import dogs.model.Client;
import dogs.model.IRepository;

public class ClientDataSeed {

	private IRepository<Client> repository;

	public ClientDataSeed(IRepository<Client> repository) {
		this.repository = repository;
		this.tableSeeder(repository);
	}
	
	public void tableSeeder (IRepository<Client> repository) {
		this.repository.add(new Client("Michel","Tremblay","418 555 3215"));
		this.repository.add(new Client("Dima","Bilan","+7 849 5561215"));
		this.repository.add(new Client("Misha","Beliy", "514 322 4859"));
		this.repository.add(new Client("Robert","DeDorval", "514 422 48569"));
	}
}
