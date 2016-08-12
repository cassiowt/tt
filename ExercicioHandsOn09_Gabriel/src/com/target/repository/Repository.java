package com.target.repository;

import java.util.List;


public interface Repository {

	public void save(Object obj);

	public Object busca(Class classe, int codigo);

	public void altera(Object obj);

	public void remove(Object obj);
	
	public void remove(Class classe, int Codigo);

	public List<Object> getAll();

}
