package dogs;

import dogs.model.Dog;
import dogs.model.IRepository;

public class DataSeed {

	private IRepository repository;

	public DataSeed(IRepository repository) {
		this.repository = repository;
		this.tableSeeder(repository);
	}
	
	public void tableSeeder (IRepository repository) {
		this.repository.add(new Dog("bob","boxer"));
		this.repository.add(new Dog("rex","pitbull"));
		this.repository.add(new Dog("chup","golden"));
	}
}
