package salenium;

import java.util.HashSet;
import java.util.Set;

public class Exercise5 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(2);
		set.add(3);
		set.add(4);
//		set.remove(4);
		if(set.contains(5)) {
			System.out.println("contains");
		}
		
		Exercise5 ex = new Exercise5();
		ex.print(set);
	}

	void print(Set<Integer> set) {
		
		System.out.println(set.toString());
		
		for (Integer value : set) {
			System.out.println(value);
		}
	}
}