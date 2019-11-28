package tests;

import java.util.Collection;

import dogs.model.Dog;
import dogs.repository.IDogRepository;

public class DogRepositorySpy implements IDogRepository {
	
	boolean isAdd = false;
	boolean getList = false;

	@Override
	public void add(Dog dog) {
		// TODO Auto-generated method stub
		isAdd = true;
	}

	@Override
	public Collection<Dog> getList() {
		// TODO Auto-generated method stub
		getList = true;
		return null;
	}
	
	public boolean isAddedSpy() {
		return isAdd = true;
	}
	
	public boolean getListSpy() {
		return getList = true;
	}

}
