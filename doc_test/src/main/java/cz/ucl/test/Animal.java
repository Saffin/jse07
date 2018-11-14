package cz.ucl.test;

public abstract class Animal {
	protected String name;

	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	abstract double getWeight();
}
