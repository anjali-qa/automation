package collection;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class Demo {
	Set<Integer> mySet = new HashSet<Integer>();;

	@Test
	void assignValues() {
		mySet.add(2);
		mySet.add(3);
		mySet.add(5);
		mySet.add(6);
		
		mySet.remove(3);

		for (Integer val : mySet) {
			System.out.println(val);
		}
	}
}
