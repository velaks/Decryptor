package decryptor.analysis;

import java.util.HashMap;


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
				list.put(text.substring(i, i+1), f == null ? 1 : f+1);
			}
		}
		return list;
	}
	
}
