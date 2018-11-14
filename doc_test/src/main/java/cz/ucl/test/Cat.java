package cz.ucl.test;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	double getWeight() {
		return 10;
	}

	@Override
	public String toString() {
		return "Cat {" + "name='" + name + '\'' + '}';
	}
}
