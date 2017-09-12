package decryptor.decrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Decrypt  {
	private HashMap<String, Integer> cipherList = new LinkedHashMap<>();
	private ArrayList <String> arlist = new ArrayList<>();
	private String cipher;
	private String result;
	private String let;
	private int index;
	
	public Decrypt(String cipher, HashMap<String, Integer> list, HashMap<String, Integer> cipherList) {
		this.cipher = cipher.toLowerCase();
		this.cipherList = cipherList;
		
		for(String key : list.keySet()){
			arlist.add(key);
		}
	}
	
	public String DecryptT() {
		for(int i = 0; i < cipher.length()-1; i++) {
			if(Character.isLetter(cipher.charAt(i))) {
				index = new ArrayList<String>(cipherList.keySet()).indexOf(cipher.substring(i, i+1));
				let = arlist.get(index);
			} else {
				let = cipher.substring(i, i+1);
			}
			result += let;
		}
		return result;
	}
	
	
}

