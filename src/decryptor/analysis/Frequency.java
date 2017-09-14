package decryptor.analysis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
/*
 * В объекте данного класса проводится частотный анализ букв и биграмм.
 *
 * Методы count(), countBigr() считают частоту появлений отдельного знака (в случае countBigr() - двух знаков)  в тексте.
 * Метод sortMap() сортируюет получившуюся коллекцию по убыванию частоты.
 */
public class Frequency {
	
	private HashMap<String, Integer> listLet = new HashMap<>();
	private HashMap<String, Integer> listBigr = new HashMap<>();
	private String text;

	public Frequency(String text) {
		this.text = text.toLowerCase();;
	}
	
	public HashMap<String, Integer> count() {
		for(int i = 0; i < text.length(); i++) {
			
			if(Character.isLetter(text.charAt(i))) {
				String s = String.valueOf(text.charAt(i));
				Integer f = listLet.get(s);
				listLet.put(text.substring(i, i+1), f == null ? 1 : ++f);
			}
		}
		listLet = sortMap(listLet);
		return listLet;
	}
	
	public HashMap<String, Integer> countBigr() {
		for(int i = 0; i < text.length()-2; i++) {
			
			if(Character.isLetter(text.charAt(i)) && Character.isLetter(text.charAt(i+1))) {
				String s = text.substring(i, i+2);
				Integer f = listBigr.get(s);
				listBigr.put(text.substring(i, i+2), f == null ? 1 : ++f);
			} else {
				i++;
			}
		}
		listBigr = sortMap(listBigr);
		return listBigr;
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
