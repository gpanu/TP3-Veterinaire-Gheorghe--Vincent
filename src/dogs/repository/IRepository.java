package dogs.repository;

import java.util.Collection;

import dogs.model.Dog;

public interface IRepository {

	void add(Dog dog);

	Collection<Dog> getList();

}
