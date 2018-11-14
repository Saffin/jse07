package cz.ucl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiceForTest implements IServiceForTest {

	public int getMin(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			throw new IllegalArgumentException();
		}

		List<Integer> asList = new ArrayList<>();

		for (int i : numbers) {
			asList.add(i);
		}

		Collections.sort(asList);

		return asList.get(0);
	}

	/**
	 *
	 * @param animals
	 * @return
	 */
	public List<Animal> sortAnimalsByWeightAsc(Collection<Animal> animals) {
		List<Animal> ani = new ArrayList<>(animals);
		Collections.sort(ani, new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				return Double.valueOf(o1.getWeight()).compareTo(Double.valueOf(o2.getWeight()));
			}
		});

		return ani;
	}

	public Set<Date> get13thFridaysFromYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DATE, 13);

		Set<Date> fridays = new HashSet<>();

		for (int i = 0; i < 12; i++) {
			cal.set(Calendar.MONTH, i);
			int j = cal.get(Calendar.DAY_OF_WEEK);
			if (j == Calendar.FRIDAY) {
				fridays.add(cal.getTime());
			}
		}

		return fridays;
	}

	public String getLexicallyLastWord(String[] texts) {
		if (texts == null || texts.length < 1) {
			return null;
		}

		List<String> strings = new ArrayList<>(Arrays.asList(texts));
		Collections.sort(strings);
		return strings.get(strings.size() - 1);
	}
}
