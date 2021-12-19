import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class javaprog {
	public static String reverse(String text){
		if (text == null)
			throw new IllegalArgumentException ("No null value accepted");
		char[] in = text.toCharArray();
		StringBuilder reverse = new StringBuilder();
		for(int i = in.length -1; i>=0; i--){
			reverse.append(in[i]);
		}
		return reverse.toString();
	}
	public static void swapNumbers(int a, int b){
		b = a + b;
		a = b - a;
		b = b - a;
		System.out.printf("a=%d --- b=%d", a,b);
	}
	public static boolean containsVowel(String text){
		return text.toLowerCase().matches(".*[aeiou].*");
	}
	public static boolean isPrime(int n){
		if(n == 0 || n == 1) return false;
		if (n == 2) return true;
		for(int i =2; i<= Math.sqrt(n); i++){
			if(n%i==0) return false;
		}
		return true;
	}
	public static int fibonacciNumbers(int n){
		if(n<=1) 
			return n;
		return fibonacciNumbers(n-1)+ fibonacciNumbers(n-2);
	}
	public static void fibonacci(int n){
		//int n = 10;
		System.out.println(0);
		System.out.println(1);
		for(int i = 2 ; i<=n; i++){
			System.out.println(fibonacciNumbers(i));
		}
	}
	public static boolean oddNumber(List<Integer> lst){
		for(int i : lst){
			if(i%2 != 0) return true;
		}
		return false;
	}
	public static boolean isPalindrome(String input){
		boolean ret = true;
		int length = input.length();
		for(int i = 0; i<length/2; i++){
			if(input.charAt(i)!= input.charAt(length-i-1)) {
				ret = false; 
				break;
			}
		}
		return ret;
	}
	public static String removeWhitespace(String input){
		StringBuilder output = new StringBuilder();
		char[] inchar = input.toCharArray();
		for(char c : inchar){
			if(!Character.isWhitespace(c)){
				output.append(c);
			}
		}
		return output.toString();
	}
	public static long factorial(long n){
		if(n==1)
			return 1;
		else
			return n*factorial(n-1);
	}
	public static void reverseLL(){
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		System.out.println(ll);
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		ll.descendingIterator().forEachRemaining(ll1::add);
		System.out.println(ll1);
		
	}
	public static int binarySearch(int[] arr, int key){
		int low =  0;
		int high =  arr.length-1;
		int mid = (low+high)/2;
		while(low<=high){
			if(arr[mid]< key){
				low = mid+1;
			}else if(arr[mid]== key){
				return 1;
			}else{
				high = mid-1;
			}
			mid = (low+high)/2;
		}
		if(low>high) return -1;
		return -1;
	}
	public static void printpattern(int rows){
		for(int i=1;i<=rows;i++){
			int numbwhitespaces = rows-i;
			printString(" ",numbwhitespaces);
			printString(i+" ",i);
			System.out.println("");
		}
	}
	public static void printString(String toprint, int index){
		for(int i=0; i<index;i++){
			System.out.print(toprint);
		}
	}
	public static boolean sameElem(Object[] obj1, Object[] obj2){
		Set<Object> elemset1 = new HashSet<>(Arrays.asList(obj1));
		Set<Object> elemset2 = new HashSet<>(Arrays.asList(obj2));
		if(elemset1.size()!= elemset2.size()) return false;
		for(Object obj: elemset1){
			if(!elemset2.contains(obj)) return false;
		}
		return true;
	}
	public static int sumArray(int[] arr){
		int sum = 0;
		if(arr.length == 0) return 0;
		for(int i:arr) sum+=i;
		return sum;
	}
	private static int findSecondHighest(int[] array) {
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		for (int i : array) {
			if (i > highest) {
				secondHighest = highest;
				highest = i;
			} else if (i > secondHighest) {
				secondHighest = i;
			}

		}
		return secondHighest;
	}
	public static boolean isTextinFile(String path, String text) throws FileNotFoundException{
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if(line.contains(text)){
				scanner.close();
				return true;
			}
		}
		scanner.close();
		return false;
	}
	public static void mergeLists(){
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("3");
		List<String> list2 = new ArrayList<>();
		list2.add("2");
		list1.addAll(list2);
		System.out.println(list1);
	}
	public static String removeChar(String str, String ch){
		return str.replace(ch, "");
	}
	public static void charCount(String str){
		char[] charr = str.toCharArray();
		Map<Character,Integer> charcount = new HashMap<>();
		for(char c: charr){
			if(charcount.containsKey(c)){
				charcount.put(c, charcount.get(c)+1);
			}else{
				charcount.put(c, 1);
			}
		}
		System.out.println(charcount);
	}
	public static String sumofStrings(String a, String b){
		int j = a.length();
		int k = b.length();
		int  m = 0;
		if(j>=k){
			m =j;
		for(int i =0;i<=m-k-1;i++){
			b = "0"+b;
		}}
		else{
			m = k;
			for(int i =0;i<=m-j-1;i++){
				a = "0"+a;
			}
		}
		String out = "";
		for(int i=m-1;i>=0;i--){
			out = Integer.toString(Integer.parseInt(a.substring(i,i+1))+  Integer.parseInt(b.substring(i,i+1)))+out;
		}
		
		return out;
	}
	public static boolean isUnique(String s){
		Hashtable<Character,Integer> tab = new Hashtable<Character,Integer>();
		//int val = s.charAt(0);
		for(char c: s.toCharArray()){
			if(tab.containsKey(c)){
				return false;
			}else{
				tab.put(c, 1);
			}
		}
		return true;
	}
	public static boolean checkPermutation(String s, String t){
		Map<Character,Integer> mapS = new HashMap<Character,Integer>();
    	Map<Character,Integer> mapT = new HashMap<Character,Integer>();
        if(s.length()!= t.length()){
        	return false;
        }else{        	
        	for(int i=0;i<s.length();i++){
        		if(mapS.containsKey(s.charAt(i))){
        			mapS.put(s.charAt(i), mapS.get(s.charAt(i))+1);
        		}else{
        			mapS.put(s.charAt(i), 1);
        		}
        		if(mapT.containsKey(t.charAt(i))){
        			mapT.put(t.charAt(i), mapT.get(t.charAt(i))+1);
        		}else{
        			mapT.put(t.charAt(i), 1);
        		}
        	}
        	return mapS.equals(mapT);
        }
	}
	public static String urlify(String s, int len){
		StringBuilder newS = new StringBuilder();
		char[] arr = s.toCharArray();
		for(int i=0;i<len;i++){
			if(arr[i]==' '){
				newS.append("%20");
			}else{
				newS.append(arr[i]);
			}
		}
		return newS.toString();
		
	}
	public static boolean isPermPalindrome(String s){
		Hashtable<Character,Integer> tab = new Hashtable<Character,Integer>();
		int len;
		if(s.length()%2 == 0){
			len = 0;
		}else{
			len = 1;
		}
		for(char c : s.toCharArray()){
			if(tab.containsKey(c)){
				tab.put(c, tab.get(c)+1);
			}else{
				tab.put(c, 1);
			}
		}
		Set<Character> keys = tab.keySet();
		int countodd =0;
		for(char c: keys){
			//if(tab.get(c)%2==1 && len == 0) return false;
			if(tab.get(c)%2==1) countodd++;
		}
		if(countodd>0 && len == 0) return false;
		if(countodd>1 && len == 1) return false;
		return true;
	}
	public static boolean isOneAway(String str1, String str2){
		if(str1.length()== str2.length()+1 || str1.length()==str2.length() || str1.length()+1==str2.length()){
			int count = 0;
			for(char c: str2.toCharArray()){
				
				if(str1.indexOf(c, 0)==-1){
					count++;
				}
			}
			if (count>1) return false;		
		}else return false;
		return true;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//String in = "Test the code";
		//System.out.println(reverse(in));
		//int a=20,b=10;
		//swapNumbers(a,b);
		//System.out.println(containsVowel("vowel"));
		//System.out.println(containsVowel("TVt"));
		//fibonacci(10);				
		//System.out.println(isPrime(19));
		//System.out.println(isPrime(4009));
		// List<Integer> list2=new ArrayList<Integer>();
		// list2.add(40);
		// list2.add(14);
		// list2.add(10);
		//System.out.println(oddNumber(list2));
		//System.out.println(isPalindrome("lowel"));
		//System.out.println(isPalindrome("level"));
		//System.out.println(removeWhitespace("what is love"));
		//System.out.println(factorial(10));
		//reverseLL();
		//int[] arr=new int[] {1,2,3,4,5,6,10,11,22};
		//System.out.println(binarySearch( arr,1));
		//printpattern(9);
		//Integer[] arr1= {1,2,3,4,5,6,10,11,22};
		//Integer[] arr2= {1,2,3,4,5,6,10,11,22};
		//System.out.println(sameElem(arr1,arr2));
		//int[] arr=new int[] {1,2,3,4,6,5,7};
		//System.out.println(sumArray(arr));
		//System.out.println(findSecondHighest(arr));
		//System.out.println(isTextinFile("C:\\Users\\psaha\\workspace\\Programming\\src\\testtext.txt","test"));
		//mergeLists();
		//System.out.println(removeChar("itisasitis","s"));
		//System.out.println(sumofStrings("11","99"));
		System.out.println(isOneAway("pale","bake"));
	}

}
