package decryptor.decrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
/*
 * ласс предназначен дл€ расшифровки шифротекста путЄм замены в шифре самых попул€рных знаков
 *на самые часто встречающиес€ знаки данного €зыка.
 *list и cipherList отсортированы в пор€дке убывани€ количества по€влений в тексте, следовательно, зна€ индекс определЄнного знака в шифре
 *можно заменить его на знак с аналогичным индексом из "контрольного" текста
 */
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
				let = index < 0 || index > 25 ? cipher.substring(i, i+1) : arList.get(index);
			} else {
				let = cipher.substring(i, i+1);
			}
			result += let;
		}
		result = DecryptBigr(result);
		return result;
	}
	//закончить
	public String DecryptBigr(String str) {
		/*result = "";
		for(int i = 0; i < cipher.length()-2; i++) {
			if(Character.isLetter(cipher.charAt(i)) && Character.isLetter(cipher.charAt(i+1))) {
				index = new ArrayList<String>(cipherListBigr.keySet()).indexOf(cipher.substring(i, i+2));
				let = index < 0 || index > 5 ? cipher.substring(i, i+2) : brList.get(index);
				i++;
			} else {
				let = cipher.substring(i, i+1);
			}
			result += let;
		}*/
		return result;	
	}
	
	
}

