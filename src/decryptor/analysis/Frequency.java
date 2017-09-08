package decryptor.analysis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Frequency {
	
	private HashMap<String, Integer> list = new HashMap<>();
	private String text;

	public Frequency(String text) {
		this.text = text.toLowerCase();;
	}
	
	public HashMap<String, Integer> count() {
		for(int i = 0; i < text.length(); i++) {
			
			if(Character.isLetter(text.charAt(i))) {
				String s = String.valueOf(text.charAt(i));
				Integer f = list.get(s);
				list.put(text.substring(i, i+1), f == null ? 1 : ++f);
			}
		}
		list = sortMap(list);
		return list;
	}
	
	private HashMap<String, Integer> sortMap(HashMap<String, Integer> uns) {
		HashMap<String, Integer> sortedMap = 
			     uns.entrySet().stream()
			    .sorted(Entry.<String, Integer>comparingByValue().reversed())
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap;	
	}
	
}
