package br.com.model;

@FunctionalInterface
public interface MemoryObserver {

	void alteredValue(String newValue) ;
	
}
