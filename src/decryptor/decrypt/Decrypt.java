package decryptor.decrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Decrypt  {
	private HashMap<String, Integer> cipherList = new LinkedHashMap<>();
	private HashMap<String, Integer> cipherListBigr = new LinkedHashMap<>();
	private ArrayList <String> arList = new ArrayList<>();
	private ArrayList <String> brList = new ArrayList<>();
	private String cipher;
	private String result;
	private String let;
	private int index = 0;
	
	public Decrypt(String cipher, HashMap<String, Integer> list, HashMap<String, Integer> cipherList,
			HashMap<String, Integer> listBigr, HashMap<String, Integer> cipherListBigr) {
		this.cipher = cipher.toLowerCase();
		this.cipherListBigr = cipherListBigr;
		this.cipherList = cipherList;
		
		for(String key : list.keySet()){
			arList.add(key);
		}
		
		for(String key : listBigr.keySet()){
			brList.add(key);
		}
	}
	
	public String DecryptT() {
		for(int i = 0; i < cipher.length()-1; i++) {
			if(Character.isLetter(cipher.charAt(i))) {
				index = new ArrayList<String>(cipherList.keySet()).indexOf(cipher.substring(i, i+1));
				let = arList.get(index);
			} else {
				let = cipher.substring(i, i+1);
			}
			result += let;
		}
		result = DecryptBigr(result);
		return result;
	}
	
	public String DecryptBigr(String str) {
		result = "";
		for(int i = 0; i < cipher.length()-2; i++) {
			if(Character.isLetter(cipher.charAt(i)) && Character.isLetter(cipher.charAt(i+1))) {
				index = new ArrayList<String>(cipherListBigr.keySet()).indexOf(cipher.substring(i, i+2));
				let = index != null ? cipher.substring(i, i+2) : brList.get(index);
			} else {
				let = str.substring(i, i+1);
			}
			result += let;
		}
		return result;	
	}
	
	
}

