package cz.ucl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is dog
 */
@Important
public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	/**
	 * @deprecated
	 * @return
	 */
	@Override
	@Deprecated
	double getWeight() {
		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public String toString() {
		Date date;

		getWeight();

		List list = new ArrayList<String>();

		List<String> list2 = list;

		return "Dog {" + "name='" + name + '\'' + '}';
	}
}
