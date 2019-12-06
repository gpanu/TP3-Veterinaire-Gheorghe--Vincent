package dogs.model;

import java.util.Collection;
import java.util.Map;

public interface IRepository<T> {

	Collection<T> getList();
	void add(T t);
	Collection<Integer> getKeys();
	Map<Integer, T> getMap();
	void modify(int idInInt, T dto);

}
