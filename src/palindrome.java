import static org.junit.Assert.*;

import org.junit.Test;

public class palindrome {
	public static void main(String args[]) { 
		//System.out.println("Is aaa palindrom?: " + isPalindromString("abba")); 
		//System.out.println("Is abc palindrom?: " + isPalindromString("ababc")); 
		System.out.println("count occurance:: " + countoccurance("abracadabra",'a')); 
		System.out.println("count occurance: " + countoccurance("abracadabra",'b')); 
		}
	@Test 
	public void testIsAnagram() { 
		assertTrue(isAnagram("word", "wrdo")); 
		assertTrue(isAnagram("mary", "army")); 
		assertTrue(isAnagram("stop", "tops")); 
		assertTrue(isAnagram("boat", "btoa")); 
		assertFalse(isAnagram("pure", "in")); 
		assertFalse(isAnagram("fill", "fil")); 
		assertFalse(isAnagram("b", "bbb")); 
		assertFalse(isAnagram("ccc", "ccccccc")); 
		assertTrue(isAnagram("a", "a")); 
		assertFalse(isAnagram("sleep", "slep")); 
		}

	public static boolean isPalindromString(String input){
		if(input == null || input.isEmpty()){
			return false;
		}
		for(int i = 0; i< input.length()/2;i++){
			if(input.charAt(i) != input.charAt(input.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	
	public static String removesubstr(String input, char remove){
		String result = "";
		for(int i = 0;i<input.length();i++){
			if(input.charAt(i)!= remove){
				result+=input.charAt(i);
			}
		}
		return result;
	}
	public static int countoccurance(String input, char remove){
		int result = 0;
		for(int i = 0;i<input.length();i++){
			if(input.charAt(i)== remove){
				result++;
			}
		}
		return result;
	}
	
	public static boolean isAnagram (String input, String anagram){
		String result = "";
		if(input.length()== anagram.length()){
			for(int i = 0; i<input.length(); i++){
				if(anagram.indexOf(input.charAt(i))!=-1){
					result+=input.charAt(i);
				}else{
					return false;
				}
			}
			if(input.equals(result)){
				return true;
			}
		}
		return false;
	}

}
