package mock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogs.model.Entity;
import dogs.model.IRepository;

public class RepositoryMock<T extends Entity> implements IRepository<T> {

	public boolean isCalled = false;
	private Map<Integer, T> entities = new HashMap<Integer, T>();

	@Override
	public Collection<T> getList() {
		return this.entities.values();	
	}

	@Override
	public Collection<Integer> getKeys() {
		return this.entities.keySet();
	}

	@Override
	public void add(T t) {
		entities.put(t.getId(), t);
		this.isCalled = true;
	}

	@Override
	public Map<Integer, T> getMap() {
		return this.entities;
	}

	@Override
	public void modify(int idInInt, T dto) {
		isCalled = true;
		
	}

	public boolean isCalled() {
		return this.isCalled;
	}

	@Override
	public void remove(String id) {
		isCalled = true;
	}
}
