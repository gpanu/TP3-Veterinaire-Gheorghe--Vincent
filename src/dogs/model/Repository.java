package dogs.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository<T extends Entity> implements IRepository<T>{
	
	private Map<Integer, T> entities = new HashMap<Integer, T>();
	
	public Collection<T> getList(){
		return this.entities.values();	
	}

	public void add(T objectToAdd) {
		entities.put(objectToAdd.getId(), objectToAdd);
	}
	
	public void modify(int i, T dto) {
		entities.replace(i, dto);
	}

	public Collection<Integer> getKeys() {
		return this.entities.keySet();	
	}
	
	public Map<Integer, T> getMap(){
		return this.entities;
	}

	@Override
	public boolean isCalled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(String id) {
		Collection<Integer> list = this.getKeys(); 
		int idInInt = Integer.parseInt(id);
		list.remove(idInInt);
	}
}
