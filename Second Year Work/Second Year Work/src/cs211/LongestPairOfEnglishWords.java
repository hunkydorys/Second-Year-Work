package cs211;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestPairOfEnglishWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CS211Reader reader = new CS211Reader();
		String[] contents = reader.load("dict");
		
		String one = "";
		String two = "";

		for (int i = 0; i < contents.length; i++) {
			String str1 = contents[i];
			HashMap< Character, Integer> hashMapForI =(HashMap<Character, Integer>) putIntoHashMap(str1);
			if(str1.length() > one.length()){
			 for (int j = i +1; j < contents.length; j++) {

				String str2 =contents[j];
				if(str2.length() > two.length() ){
					if (haveSameLetters(hashMapForI, str2)) {
						if(str1.compareTo(str2) != 0)
						{
							 one= str1;
							 two = str2;
							 System.out.println(one + " " + two);
						} 
					}
				}
			}
			}
		}
		// haveSameLetters("aabb", "aabb");
		System.out.println(one + " " + two);

	}

	// assume they have the same length
	public static boolean haveSameLetters(Map hit, String str2) {

		HashMap<Character, Integer> hit2 = (HashMap<Character, Integer>) putIntoHashMap(str2);
		if (hit.keySet().equals(hit2.keySet())) {
			return true;
		}
		return false;
	}

	public static Map putIntoHashMap(String str1) {

		HashMap<Character, Integer> hit = new HashMap<Character, Integer>(
				str1.length());

		for (int index = 0; index < str1.length(); index++) {
			hit.put(Character.valueOf(str1.charAt(index)),
					Integer.valueOf(index));
		}
		return hit;
	}

	public static int numberOfUniqueChars(String str) {
		HashMap<Character, Integer> hit = new HashMap<Character, Integer>(256);
		Integer value;
		Character key;

		for (int i = 0; i < str.length(); i++) {
			key = (Character) str.charAt(i);
			if (hit.containsKey(key)) {
				value = hit.get(key);
				hit.put(key, value + 1);
			}
			hit.put(key, 1);

		}
		Integer sumOfValue = 0;
		Iterator enIterator = hit.entrySet().iterator();
		while (enIterator.hasNext()) {
			Map.Entry<Character, Integer> pairs = (Map.Entry<Character, Integer>) enIterator
					.next();
			key = (Character) pairs.getKey();
			sumOfValue = ((Integer) pairs.getValue()) + sumOfValue;

		}
		return sumOfValue;
	}

}
