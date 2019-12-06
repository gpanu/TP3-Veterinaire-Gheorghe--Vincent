package tests;

import java.util.Collection;
import java.util.Map;

import dogs.model.IRepository;

public class ReposytoryMock<T> implements IRepository<T> {

	@Override
	public Collection getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Integer, T> getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(int idInInt, T dto) {
		// TODO Auto-generated method stub
		
	}

}
