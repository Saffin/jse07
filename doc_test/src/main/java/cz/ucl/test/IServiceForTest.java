package cz.ucl.test;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IServiceForTest {
	
	int getMin(int[] numbers);

	List<Animal> sortAnimalsByWeightAsc(Collection<Animal> animals);

	Set<Date> get13thFridaysFromYear(int year);

	String getLexicallyLastWord(String[] texts);
}
