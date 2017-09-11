package decryptor.decrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Decrypt {
	private HashMap<String, Integer> list = new LinkedHashMap<>();
	private HashMap<String, Integer> cipherList = new LinkedHashMap<>();
	private String cipher;
	private String dec;
	int pos;
	
	public Decrypt(String cipher, HashMap<String, Integer> list, HashMap<String, Integer> cipherList) {
		this.cipher = cipher;
		this.list = list;
		this.cipherList = cipherList;
		pos = new ArrayList<String>(list.keySet()).indexOf("a");
		System.out.println(list.get("b"));
		System.out.println(pos);
	}
	
	
	
	public String Decrypt() {
		for(int i = 0; i < cipher.length(); i++) {
			
		}
		
		
		return dec;
		
	}
	
	
}
