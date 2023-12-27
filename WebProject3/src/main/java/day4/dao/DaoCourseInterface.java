package day4.dao;

import java.util.Collection;

public interface DaoCourseInterface<T, K> {

	Collection<T>getAll(); //method to retrieve all the (objects)records
	T getOne(K key); //method to retrieve single record based upon its identity (ID)
void create(T t);//method create new record
	
	void update(T t);
	
   void deleteOne(K key);
}
