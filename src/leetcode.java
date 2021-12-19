import java.util.*;

public class leetcode {
	public static int[] twoSum(int[] nums, int target) {
	        int[] result = new int[2];
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<=nums.length-1;i++){
	        	//brute force solution
	        	/*	for(int j=i+1;j<=nums.length-1;j++){
	        			if(nums[i]+nums[j]==target){
	        				result[0] = i;
	        				result[1] = j;
	        				break;
	        			}
	        		}*/
	        	//hash map solution
	        	if(map.containsKey(target-nums[i])){
	        		result[0] = i;
	        		result[1] = map.get(target-nums[i]);
	        		return result;
	        	}else{
	        		map.put(nums[i], i);
	        	}
	        	
	        }
	        return result;
	    }
	public static int palindrome(int x,int result){
		 if(x == 0) return result;
		 result = result*10 + x%10;
		 return palindrome(x/10,result);
	 }
	public static boolean isPalindrome(int x) {
		 if(x<0) return false;
		 int result = palindrome(x,0);
		 if(x == result) {
			 return true;
		 }else{
			 return false;
		 }
	    }
	public static int climbStairs(int n) {
		 int steps = 0;
		 int prev = 1;
		 int prevprev = 0;
			 for(int i=1;i<=n;i++){
				steps = prev + prevprev; 
				prevprev = prev;
				prev = steps;
			 }
	     return steps;   
	    }
	public static int romanToInt(String s) {
			int total = 0;
	       // Map<Character,Integer> map = new HashMap<>();
	       // char prevChar = 'A';
	        char[] schar = s.toCharArray();
	        for(int i=schar.length-1;i>=0;i--){
	        	if(schar[i]=='I'){
	        		total = total+ 1;
	        	}else if(schar[i]=='V'){
	        		if(i!=0){
	        			if(schar[i-1]=='I'){
		        			total = total + 4;
		        			i = i-1;
		        		}else{
		        			total = total + 5;
		        		}
	        		}else{
	        			total = total + 5;
	        		}
	        		
	        	}else if(schar[i]=='X'){
	        		if(i!=0){
	        			if(schar[i-1]=='I'){
		        			total = total + 9;
		        			i = i-1;
		        		}else{
		        			total = total + 10;
		        		}
	        		}else{
	        			total = total + 10;
	        		}
	        		
	        	}else if(schar[i]=='L'){
	        		if(i!=0){
	        			if(schar[i-1]=='X'){
		        			total = total + 40;
		        			i = i-1;
		        		}else{
		        			total = total + 50;
		        		}
	        		}else{
	        			total = total + 50;
	        		}
	        		
	        	}else if(schar[i]=='C'){
	        		if(i!=0){
	        			if(schar[i-1]=='X'){
		        			total = total + 90;
		        			i = i-1;
		        		}else{
		        			total = total + 100;
		        		}
	        		}else{
	        			total = total + 100;
	        		}
	        		
	        	}else if(schar[i]=='D'){
	        		if(i!=0){
	        			if(schar[i-1]=='C'){
		        			total = total + 400;
		        			i = i-1;
		        		}else{
		        			total = total + 500;
		        		}
	        		}else{
	        			total = total + 500;
	        		}
	        		
	        	}else if(schar[i]=='M'){
	        		if(i!=0){
	        			if(schar[i-1]=='C'){
		        			total = total + 900;
		        			i = i-1;
		        		}else{
		        			total = total + 1000;
		        		}
	        		}else{
	        			total = total + 1000;
	        		}
	        		
	        	}
	        	//if(map.containsKey(schar[i])){
	        	//(schar[i]=='I'){
	        			
	        	//	}
	        	//}else{
	        	//	map.put(schar[i], )
	        	//}
	        }
	        return total;
	    } 
	 public static String longestCommonPrefix(String[] strs) {
		 String  str =strs[0];
		 int len = 0;
	       for(int i=1; i<=strs.length-1;i++){
	    	   if(str.length()==0 || strs[i].length()==0){
	    		   str =""; 
	    		   break;
	    	   }
	    	   if(str.length()<= strs[i].length()){
	    		    len = str.length() - 1;
	    	   }else{
	    		    len = strs[i].length() - 1;
	    	   }
	    	   for(int j = 0; j<=len; j++){
	    		   if(strs[i].charAt(j) != str.charAt(j)){
	    			   if(j==0){
	    				   return "";
	    			   }else{
	    				   str = str.substring(0, j);
	    				   break;
	    			   }
	    		   }else{
	    			   if(j == len) str = strs[i].substring(0, j+1);
	    		   }
	    	   }
	       }
	       return str;
	    }
	  public static boolean isValid(String s) {		  
	      if(s.length()%2!=0) return false;
	      Stack<String> validStack = new Stack();
	      String open = "[{(";
	      String close = "]})";
	      for(char c: s.toCharArray()) {
	    	  if(close.indexOf(Character.toString(c))!=-1 && validStack.isEmpty()) return false;
	    	  if(open.indexOf(Character.toString(c))!=-1) {
	    		  validStack.push(Character.toString(c));
	    	  }else if(close.indexOf(Character.toString(c))!=-1) {
	    		  if(open.indexOf(validStack.peek())==close.indexOf(Character.toString(c))) {
	    			  validStack.pop();
	    		  }else {
	    			  return false;
	    		  }
	    	  }
	      }
	      if(validStack.isEmpty()) return true;
	      return false;
	    } 
	  public static int lengthOfLongestSubstring(String s) {
		  String lngstr = "";
		  String temp = "";
		  	if(s == "") return 0; 
		  	if(s.length() == 1) return 1;
	        for(char c: s.toCharArray()){
	        	if(lngstr.contains(Character.toString(c))){
	        		if(lngstr.length()> temp.length()){
	        			temp = lngstr;	        			
	        		}
	        		lngstr = lngstr.substring(lngstr.indexOf(Character.toString(c))+1, lngstr.length()).concat(Character.toString(c));
	        	}else{
	        		lngstr = lngstr.concat(Character.toString(c));
	        	}
	        }
	       if(lngstr.length()> temp.length()) return lngstr.length();
	       return temp.length(); 
	    }
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        int[] ans = new int[nums1.length];
	        int temp = Integer.MAX_VALUE;
	        for(int v=0; v<= ans.length-1;v++) ans[v] = -1; 
	        for(int i =0; i<= nums1.length-1;i++){
	        	for(int j=0;j<=nums2.length-1;j++){
	        		if(nums2[j] == nums1[i]) temp = j;
	        		if(nums2[j]>nums1[i] && j>temp){
	        			ans[i] = nums2[j];
	        			temp =  Integer.MAX_VALUE;
	        			break;
	        		}
	        		if(j == nums2.length-1) temp =  Integer.MAX_VALUE;
	        	}
	        }
	        return ans;
	    }  
	/* public static  boolean wordBreak(String s, List<String> wordDict) {
	        String[] temp = new String[wordDict.size()];
	        int j =0;
	        String tempS = s;
	        for(int i=j; i<=wordDict.size()-1;i++){
	        	if(s.isEmpty()) return true;
	        	if(s.indexOf(wordDict.get(i))!=-1){
	        		s = s.replaceAll(wordDict.get(i), " ").trim();
	        		//s = s.substring(s.indexOf(wordDict.get(i)), wordDict.get(i).length());
	        		//i = -1;
	        	}
	        	if(!s.isEmpty() && i == wordDict.size()-1){
	        		temp[j] = wordDict.get(j);
	        		i= j++;
	        		s = tempS;
	        	}
	        }
	        if(s.isEmpty()) return true;
        	if(s.isEmpty() && (temp[temp.length-1] == wordDict.get(wordDict.size()-1))) return true;
	        return false;
	    }*/
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 	ListNode ll;
	        if(l1 == null && l2 == null){
	            return null;
	        }else if(l1 == null){
	            return l2;
	        }else if(l2 == null){
	            return l1;
	        }
	        if(l1.val>l2.val){
	            ll = l2;
	            ll.next = mergeTwoLists(l1,l2.next);
	            
	        }else{
	            ll = l1;
	            ll.next = mergeTwoLists(l1.next,l2);
	        }      
	        return ll;
	    }
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 int[] nums = new int[m+n];
		 if(m==1 && n==0){
			 System.out.print(nums1[0]);
		 }else if(m == 0 && n == 1){
			 System.out.print(nums2[0]);
		 }else{
			 for(int i=0; i<=m+n;i++){
		        	if(nums1[0]<=nums2[0]){
		        		nums[i] = nums1[0];
		        		
		        	}else{
		        		nums[i] = nums2[0];
		        	}
		        }
		 }
	       
	    }
	public static int addDigits(int num) {
			int out = 0;
			 if(num<=9) {
	        	return num;
	        }else{
	        	for(;;){
	        		if(num /10 < 10){
	        			num =  out + num/10 + num%10;
	        			out = 0;
	        			if(num<10) return num;
	        		}else{
	        			out = out + num%10;
	        			num = num/10;
	        		}	        		
	        	}
	       	}
			
	    } 
	public static boolean isHappy(int n) {
			int	out =0;
			Set<Integer> holder = new HashSet<>();
	       if(n == 1) return true;
	       for(;;){
	    	   if(n  < 10){
	    		   n = out + (n%10 )*(n%10);// + (n/10 )*(n/10);
	    		   out = 0;
	    		   if(n == 1){
	    			   return true;
	    		   }else{
	    			   if(holder.contains(n)) return false;
	    			   holder.add(n);
	    		   }
	    	   }else{
	    		   out = out + (n%10 )*(n%10);
	    		   n = n/10;
	    	   }
	       }
	       
	    }
	public static boolean isUgly(int n) {
		if(n==0) return false;
        for(;;){
        	if (n == 1) return true;
        	//if(n%2 != 0 || n%3 != 0 || n%5 != 0) return false;
        	if(n%2 == 0){
        		n = n/2;
        	}else if(n%3 == 0){
        		n = n/3;
        	}else if(n%5 == 0){
        		n = n/5;
        	}else{
        		return false;
        	}
        }
    }
	public static int maximumWealth(int[][] accounts) {
        //if(accounts[][]== 0) return 0;
		int max = Integer.MIN_VALUE;
		int total = 0;
		int m = accounts.length;
		int n = accounts[0].length;
		for(int i =0;i<=m-1;i++){
			total = 0;
			for(int j =0;j<=n-1;j++){
				total = total + accounts[i][j];
			}
			if(max< total) max = total;
			
		}
		return max;
    }
	 public static int diagonalSum(int[][] mat) {
	       if(mat.length == 2) return mat[0][0]+mat[0][1]+mat[1][0]+mat[1][1];
	       int len = mat.length;
	       int m =0;
	       int n = mat.length -1;
	       int diagsum =0;
	       for(int i =0 ; i<=len-1;i++){
	    	   if(i == m){
	    		   if(len%2!=0 && i == (len/2)){
	    			   diagsum = diagsum + mat[i][m];
	    			   m = m -1;
	    			   n = n +1;
	    		   }else{
	    			   diagsum = diagsum + mat[i][m] + mat[i][n];	
		    		   m = m+1;
		    		   n = n-1;
	    		   }	    		  
	    	   }else if(i == n){
	    		   diagsum = diagsum + mat[i][m] + mat[i][n];
	    		   m = m -1;
    			   n = n +1;
	    	   }
	       }
	       return diagsum;
	    }
	 public static int countNegatives(int[][] grid) {
		 	int count = 0;
			int countrow = 0;
			int m = grid.length;
			int n = grid[0].length;
			for(int i = m - 1;i>=0;i--){
				countrow = 0;
				for(int j =0;j<=n-1;j++){
					if(grid[i][j]< 0){
						count = count +1;
						countrow = countrow + 1;
					}
				}
				if(countrow == 0) return count;
				
			}
			return count;
	    }
	 public static int majorityElement(int[] nums) {
	       Map<Integer,Integer> map = new HashMap<>();
	       int major = nums[0];
	       for(int i =0; i<=nums.length-1;i++){
	    	   if(map.containsKey(nums[i])){
	    		   map.put(nums[i], map.get(nums[i])+1);
	    		   if(map.get(nums[i])>= map.get(major)){
	    			   major = nums[i];
	    		   }
	    	   }else{
	    		   map.put(nums[i], 1);
	    	   }
	       }
	       return major;
	    } 
	 public static String longestPalindrome(String s) {
		 /*    String out = s.substring(0, 1);
	        String temp = s.substring(0, 1);
	        String rev = s.substring(0, 1);
	        if(s.length() == 1) return s;
	        if(s.length() == 2){
	        	//System.out.println(s.substring(1, 2));
	        	if(s.substring(0, 1).equals(s.substring(1, 2)))
	        		return s;
	        	else
	        		return s.substring(0, 1);
	        }else{
	        	int j = 1;
	        	for(int i=1;i<=s.length()-1;i++){
	        		rev = s.substring(i,i+1) + rev;
	        		temp = temp+s.substring(i,i+1);	        		
	        		if(temp.equals(rev) && temp.length()> out.length()){
	        			out = temp;
	        		}
	        		if(i == s.length()-1 && (s.length()-j)>= out.length()){
	        			rev = s.substring(j,j+1);
	        			temp = s.substring(j,j+1);
	        			i = j;
	        			j++;
	        		
	        		}
	        	}
	        }*/
		 //dynamic programming
		 boolean[][] dp = new boolean[s.length()][s.length()];
		 String out="";
		 for(int i =0;i<s.length();i++){
	        dp[i][i] = true;
	        out = s.substring(0,1);
	        }
		 for(int i =0; i<s.length()-1;i++){
			 if(s.charAt(i)== s.charAt(i+1)){
				 dp[i][i+1] = true;
				 out = s.substring(i, i+2);
			 }else{
				 dp[i][i+1] = false;
			 }
		 }

		 for(int k=3; k<=s.length();k++){
			 for(int i= 0; i<s.length()-k+1;++i){
				 int j = i+k-1;
				 if(s.charAt(i)==s.charAt(j)&& dp[i+1][j-1]){
					 dp[i][j] = true;
					 if(s.substring(i,j+1).length()> out.length()) out = s.substring(i,j+1);
				 }else{
					 dp[i][j] = false;
				 }
			 }
			
		 }
	        return out;

	    }
	 public static int countSubstrings(String s) {
		 boolean[][] dp = new boolean[s.length()][s.length()];
		 int count= 0;
		 for(int i =0;i<s.length();i++){
	        dp[i][i] = true;
	        count++;
	        }
		 for(int i =0; i<s.length()-1;i++){
			 if(s.charAt(i)== s.charAt(i+1)){
				 dp[i][i+1] = true;
				 count++;
			 }else{
				 dp[i][i+1] = false;
			 }
		 }

		 for(int k=3; k<=s.length();k++){
			 for(int i= 0; i<s.length()-k+1;++i){
				 int j = i+k-1;
				 if(s.charAt(i)==s.charAt(j)&& dp[i+1][j-1]){
					 dp[i][j] = true;
					 count++;
					// if(s.substring(i,j+1).length()> out.length()) out = s.substring(i,j+1);
				 }else{
					 dp[i][j] = false;
				 }
			 }
			
		 }
	        return count;

	    } 
	 public  static int[] buildArray(int[] nums) {
	        int[] ans = new int[nums.length];
	        for(int i=0;i<nums.length;i++){
	        	ans[i] = nums[nums[i]];
	        }
	        return ans;
	    }
	 public static int[] getConcatenation(int[] nums) {
		 int[] ans = new int[nums.length*2];
	        for(int i=0;i<nums.length;i++){
	        	ans[i] = nums[i];
	        	ans[i+nums.length] = nums[i];
	        }
	        return ans; 
	    } 
	 public static int finalValueAfterOperations(String[] operations) {
	        int x = 0;
	        for(String i:operations){
	        	  if(i.indexOf('+') >= 0) x++;
	              else x--;
	        }
	        
	        return (int) x;	
	    } 
	 public static int[] runningSum(int[] nums) {
	        int[] sum = new int[nums.length];
	        for(int i=0; i<nums.length;i++){
	        	if(i == 0) sum[i] = nums[i];
	        	else sum[i] = sum[i-1] + nums[i]; 
	        }
	        return sum;
	    } 
	  public static int[] shuffle(int[] nums, int n) {
	        if (n==1) return nums;
	        int[] res = new int[2*n];
	        for(int i=0;i<n;i++){
	        		if(i==0)
		        		res[i] = nums[i];
		        	else
		        		res[i*2] = nums[i];        	
	        }
	        int j = 1;
	        for(int i = n;i<2*n;i++){
	        	res[j] = nums[i];
	        	j = j+2;
	        }
	        return res;
	    } 
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> out = new ArrayList<Boolean>();
	        int max = Integer.MIN_VALUE;
	        for(int i =0; i<candies.length;i++){
	        	if(candies[i]>max) max = candies[i];
	        }
	        for(int i=0;i<candies.length;i++ ){
	        	if(candies[i]+extraCandies>= max)
	        		out.add(i, true);
	        	else
	        		out.add(i, false);
	        }
	      return out;  
	    }  
	 public static int[] twoSums(int[] numbers, int target) {
	        int[] out  = new int[2];
	        int n = numbers.length;
	        Map<Integer,Integer> map = new HashMap<>();		       
	        for(int i =0;i<n;i++){
	        	if(map.containsKey(target-numbers[i])){
	        		if(i<map.get(target-numbers[i])){
	        			out[0] = i+1;
		        		out[1] = map.get(target-numbers[i])+1;
	        		}else{
	        			out[0] = map.get(target-numbers[i])+1;
	        			out[1] = i+1;		        		
	        		}
	        		
	        		return out;
	        	}else{
	        		map.put(numbers[i], i);
	        	}
	        	
	        }
	        return out;
	    }
	 public static int numIdenticalPairs(int[] nums) {
	        int count = 0;
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i: nums){
	        	if(map.containsKey(i)){
	        		count = count + map.get(i);
	        		map.put(i, map.get(i)+1);
	        	}else{
	        		map.put(i, 1);
	        	}
	        }
	        return count;
	    }
	 public static int[] smallerNumbersThanCurrent(int[] nums) {
	     /*   int[] out = new int[nums.length];
	        for(int i=0;i<nums.length;i++){
	        	for(int j =0; j< nums.length; j++){
	        		if(i!=j && nums[j]<nums[i]){
	        			out[i] = out[i]+1;
	        		}
	        	}
	        }
	        return out;*/
		   int[] result = new int[nums.length];
	       int[] temp = new int[101];
	        
	        for (int i = 0; i < nums.length; i++) {
	            temp[nums[i]]++;
	        }
	        
	        for (int i = 1; i < 101; i++) {
	            temp[i] += temp[i-1];
	        }
	        
	        for (int i = 0; i < nums.length; i++) {
	            if(nums[i] == 0) {
	                result[i] = 0;
	            } else {
	                result[i] = temp[nums[i] - 1];
	            }
	        }
	        return result;
	    } 
    public static String restoreString(String s, int[] indices) {
	        String[] temp = new String[indices.length];
	        String res="";
	        for(int i=0;i<indices.length;i++){
	        	temp[indices[i]] = s.substring(i, i+1);

	        }
	        for(int i=0;i<temp.length;i++){
	        	res = res.concat(temp[i]);
	        }
	        return res;
	    } 
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    	String w1 ="";
    	String w2 = "";
        if(word1.length>1){
        	for(int i=0;i<word1.length;i++){
        		w1 = w1.concat(word1[i]);
        	}
        }else{
    		w1 = word1[0];
    	}
        if(word2.length>1){
        	for(int i=0;i<word2.length;i++){
        		w2 = w2.concat(word2[i]);
        	}
        }else{
    		w2 = word2[0];
    	}
        return w1.equals(w2);
        
    }
    public static int countKDifference(int[] nums, int k) {
      /*  int count = 0;
        int countnums = 1;
        int currentx = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(Math.abs(currentx - nums[i])== k){
        		count++;
        	}
        	if(i == nums.length-1 && countnums != nums.length){
        		currentx = nums[countnums];
        		i = countnums;
        		countnums++;
        	}
        }
        return count;*/
    	 Map<Integer,Integer> map = new HashMap<>();
         int res = 0;
         
         for(int i = 0;i< nums.length;i++){
             if(map.containsKey(nums[i]-k)){
                 res+= map.get(nums[i]-k);
             }
             if(map.containsKey(nums[i]+k)){
                 res+= map.get(nums[i]+k);
             }
             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
         }
         
         
         return res;
    }
    public static int minMovesToSeat(int[] seats, int[] students) {
        int moves =0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i=0; i<seats.length;i++){
        	moves = moves + Math.abs(seats[i] - students[i]);
        }
        return moves;
    }
    /* public static int coinChange(int[] coins, int amount) {
    	if(amount == 0) return 0;
    	int changes = 0;
    	Arrays.sort(coins);
    	for(int i = coins.length-1; i>=0;i--){
    		if(amount == 0) return changes;
    		if((amount/coins[i])> 0) changes = changes + (amount/coins[i]);
    		amount = amount%coins[i];
    	}
        if(amount>0)return -1;
        return changes;
    }*/
    
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length -1;
        while(start<end){
        	char temp = s[start];
        	s[start] = s[end];
        	s[end] = temp;
        	end--;
        	start++;
        }
    }
    public static boolean isAnagram(String s, String t) {
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
       // return mapS.equals(mapT);
    }
    public static boolean rotateString(String s, String goal) {
    	if(s.equals(goal)) return true;
        for(int i=0;i<s.length()-1;i++){
        	String temp = s.substring(0,i+1);
        	if(s.substring(i+1).concat(temp).equals(goal)){
        		return true;
        	}
        }
        return false;
    }
    public static int firstUniqChar(String s) {
        Map<Character,Integer> table =  new HashMap<Character,Integer>();
        for(int i=0; i<s.length();i++){
        	if(table.containsKey(s.charAt(i))){
        		table.put(s.charAt(i),table.get(s.charAt(i))+1);
        	}else{
        		table.put(s.charAt(i), 1);
        	}
        }
        int uniindex = Integer.MAX_VALUE;
        Set<Character> setkeys = table.keySet();
        for(Character c: setkeys){
        	if(table.get(c)==1){
        		if(s.indexOf(c)<uniindex){
        			uniindex = s.indexOf(c);
        		}
        	}
        }
        if(uniindex == Integer.MAX_VALUE)return -1;
        return uniindex;
    }
    public static boolean containsDuplicate(int[] nums) {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:nums){
        	if(map.containsKey(i)){
        		return true;
        	}else{
        		map.put(i, 1);
        	}
        }
        return false;
    }
   public static int numOfStrings(String[] patterns, String word) {
	   int count = 0;
	   for(String s: patterns){
		   if(word.indexOf(s)!= -1){
			   count++;
		   }
	   }
	   return count;
    }
   public static List<String> fizzBuzz(int n) {
       List<String> s = new ArrayList<String>();
       for(int i=1;i<=n;i++){
    	   if(i%3==0 && i%5==0){
    		   s.add("FIzzBuzz");
    	   }else if(i%3==0){
    		   s.add("Fizz");
    	   }else if(i%5==0){
    		   s.add("Buzz");
    	   }else{
    		   s.add(Integer.toString(i));
    	   }
       }
       return s;
   }
   public static int numJewelsInStones(String jewels, String stones) {
       int count = 0;
       for(int i=0;i<stones.length();i++){
    	   if(jewels.indexOf(stones.charAt(i))!=-1){
    		   count++;
    	   }
    	   
       }
       return count;
   }
   public static int coinChange(int[] coins, int amount) {
	      return 0;
   }
   public static boolean checkIfPangram(String sentence) {
	 /*  Map<Character,Integer> map =  new HashMap<Character,Integer>();
	   if(sentence.length()<26) return false;
	   for(int i=0;i<sentence.length();i++){
		   if(map.containsKey(sentence.charAt(i))){
			   map.put(sentence.charAt(i), map.get(sentence.charAt(i))+1);
		   }else{
			   map.put(sentence.charAt(i), 1);
		   }
	   }
	   if(map.size()==26) return true;
       return false;*/
	   String alpha = "abcdefghijklmnopqrstuvwxyz";
	   for(char c: alpha.toCharArray()){
		   if(sentence.indexOf(c)==-1) return false;
	   }
	   return true;
   }
   public static int fib(int n) {
       if(n==0) return 0;
       if(n ==1) return 1;
       return n= fib(n-2)+fib(n-1);
       
   }
   public int[] countBits(int n) {
       int[] dp = new int[n + 1];
      dp[0] = 0;
      for (int i = 1; i <= n; i++) {
          dp[i] = dp[i >> 1] + (i % 2);
      }
      return dp;
  }
  public static int compress(char[] chars) {
	  int index=0,count=0;
        for(int i=0;i<chars.length;i++){
        	count++;
        	if(i+1 == chars.length || chars[i] != chars[i+1]){
        		chars[index++] = chars[i];
        		if(count != 1){
        			for(char c: Integer.toString(count).toCharArray()){
        				chars[index++] = c;
        			}
        		}
        		count = 0;
        	}
        }
        	
    	  
       return index;
   }
  public static void rotate(int[][] matrix) {
      int n = matrix.length;
     for (int i = 0; i < (n + 1) / 2; i++) {
         for (int j = i; j < n - 1 - i; j++) {
             int temp = matrix[i][j];
             matrix[i][j] = matrix[n - 1 - j][i];
             matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
             matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
             matrix[j][n - 1 - i] = temp;
         }
     }
 }
  public static void setZeroes(int[][] matrix) {
      boolean[] row = new boolean[matrix.length];
      boolean[] col = new boolean[matrix[0].length];
      for(int i=0;i<matrix.length;i++){
    	  for(int j=0; j<matrix[0].length;j++){
    		  if(matrix[i][j]==0){
    			  row[i] = true;
    			  col[j] = true;
    		  }
    	  }
      }
      
      for(int i=0;i<row.length;i++){
    	  if(row[i]) nullifyRow(matrix,i);
      }
      for(int i=0;i<col.length;i++){
    	  if(col[i]) nullifyCol(matrix,i);
      }
  }
 public static void nullifyRow(int[][] matrix,int row){
	  for(int j =0; j<matrix[0].length;j++){
		  matrix[row][j] = 0;
	  }
  }
 public static void nullifyCol(int[][] matrix,int col){
	  for(int i =0; i<matrix.length;i++){
		  matrix[i][col] = 0;
	  }
  }
 public static ListNode deleteDuplicates(ListNode head) {
     ListNode n = head;
     while(n!=null){
    	 if(n.next==null) break;
    	 if(n.val == n.next.val){
    		 n.next = n.next.next;
    	 }else{
    		 n = n.next;
    	 }
     }
     return head;
     
 }
 public static ListNode deleteDupUnsort(ListNode head) {
	 ListNode prev = null;
	 HashSet<Integer> set = new HashSet<Integer>();
	 while(head!=null){
		 if(set.contains(head.val)){
			 prev.next = head.next;
		 }else{
			 set.add(head.val);
			 prev = head;
		 }
		 head =head.next;
	 }
	 return prev;
 }
 public ListNode removeElements(ListNode head, int val) {
	 if (head == null) return null;
     else {
         if (head.val == val) return removeElements(head.next, val);
         else {
             head.next = removeElements(head.next, val);
             return head;
         }
     }
 }
 Stack<Integer> input = new Stack();
 Stack<Integer> output = new Stack();
 
 public void push(int x) {
     input.push(x);
 }

 public void pop() {
     peek();
     output.pop();
 }

 public int peek() {
     if (output.empty())
         while (!input.empty())
             output.push(input.pop());
     return output.peek();
 }

 public boolean empty() {
     return input.empty() && output.empty();
 }
 
 private Queue<Integer> queue = new LinkedList<>();
 
 
  // Definition for a binary tree node.
 public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
  
 public List<Integer> inorderTraversal(TreeNode root) {
 List<Integer> res = new ArrayList<>();
 helper(root, res);
 return res;
}

public void helper(TreeNode root, List<Integer> res) {
 if (root != null) {
     helper(root.left, res);
     res.add(root.val);
     helper(root.right, res);
 }
}
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    helper2(root,res);
    return res;
}
public void helper2(TreeNode root, List<Integer> res){
    if(root!=null){
        res.add(root.val);
        helper2(root.left,res);
        helper2(root.right,res);
    }
        
} 

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    helper3(root,res);
    return res;
}
public void helper3(TreeNode root, List<Integer> res){
   if(root!=null){
       helper3(root.left,res);
       helper3(root.right,res);
       res.add(root.val);
   }
}
public static String replaceDigits(String s) {
	String alphabet ="abcdefghijklmnopqrstuvwxyz";
	for(int i =1; i<s.length();i=i+2){		
		int digit = Integer.parseInt(s.substring(i, i+1));
		int charpos = alphabet.indexOf(s.substring(i-1, i));
		String alpha = alphabet.substring(charpos+digit,charpos+digit+1);
		s = s.replaceFirst(s.substring(i, i+1), alpha);
	}
    return s;
}

public static int[][] transpose(int[][] A) {
	int result[][] = new int[A[0].length][A.length];

    if(A.length == 0){
        return result;
    }

    for(int i = 0; i < A[0].length; i++){
        for(int j = 0; j < A.length; j++){
            result[i][j] = A[j][i];
        }
    }

    return result;
}
public static int sumOfUnique(int[] nums) {
	  int sum =0;
	    HashMap<Integer,Integer> tab = new HashMap<Integer,Integer>();
	    for(int i=0;i<nums.length;i++){
	    	if(tab.containsKey(nums[i])){
	    		tab.put(nums[i], tab.get(nums[i])+1);
	    	}else{
	    		tab.put(nums[i], 1);
	    	}
	    }
	    Set<Integer> keys = new HashSet<Integer>();
	    keys = tab.keySet();
	    for(int i:keys){
	    	if(tab.get(i)==1) sum = sum + i;
	    }
	    return sum;
}
public static boolean halvesAreAlike(String s) {
    String vowels ="aeiouAEIOU";
    int countA = 0;
    int countB = 0;
    int halflen = s.length()/2;
    for(int i=0; i< halflen;i++){
    	if(vowels.indexOf(s.substring(i, i+1))!= -1) countA++;
    	if(vowels.indexOf(s.substring(i+halflen, i+halflen+1))!=-1) countB++;
    }
    if(countA == countB)
    	return true;
    else
    	return false;
}
private HashMap<String,Integer> map;
public void Logger() {
    map = new HashMap<String,Integer>();    
}
public  boolean shouldPrintMessage(int timestamp, String message) {
	
	if(!this.map.containsKey(message)) {
		this.map.put(message, timestamp);
		return true;
	}else{
		int oldtimestamp = this.map.get(message);
		if(timestamp - oldtimestamp >=10){
			this.map.put(message, timestamp);
			return true;
		}else{
			return false;
		}
	}
    
}
public boolean validPalindrome(String s) {
    if(s.isEmpty()) return false;
    if(s.length()==1) return true;
    int start = 0;
    int end = s.length()-1;
    //int counter = 0;
    while(start<end){
    	if(s.charAt(start) != s.charAt(end)){
    		return isPal(s,start+1,end)||isPal(s,start,end-1);
    	}
    	start++;
    	end--;
    	
    }
    return true;
}
private boolean isPal(String s, int start, int end){
	while(start<end){
		if(s.charAt(start) != s.charAt(end)) return false;
		start++;
		end--;
	}
	return true;
}
private HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
public void ParkingSystem(int big, int medium, int small) {
    map1.put(1, big);
    map1.put(2, medium);
    map1.put(3, small);
}

public boolean addCar(int carType) {
	if(map1.get(carType)!= 0){
		map1.put(carType, map1.get(carType)-1);
		return true;
	}else
		return false;
}

public static int[] sumZero(int n) {
	int[] res = new int[n];
	int setVal = 1;
	if(n>1){
		int i = 0;
		if(n%2!=0){
    		res[0] = 0;
    		i = i +1;
    	}
		for(; i<n;i++){
	    	
	    	res[i] = setVal;
	    	res[i+1] = (-1)*setVal;
	    	i++;
	    	setVal++;
	    	
	    }
	}else{
		res[0] =0;
	}
    
    return res;
}
public static int[] decompressRLElist(int[] nums) {
    ArrayList<Integer> arr =  new ArrayList<Integer>();
    for(int i=0; i<nums.length;i=i+2){
    	for(int j =0; j<nums[i];j++){
    		arr.add(nums[i+1]);
    	}
    }
    int[] res = new int[arr.size()];    
    for(int i=0; i<arr.size();i++){
    	res[i] = arr.get(i);
    }
    return res;
}
public static boolean canPlaceFlowers(int[] flowerbed, int n) {
	if(flowerbed.length==1 && flowerbed[0]==0 && n==1) return true;
	if(flowerbed.length==1 && flowerbed[0]==1 && n==1) return false;
	for(int i=0;i<flowerbed.length;i++){
		if(n==0) return true;
		if(i==0 && n>0){
			if(flowerbed[i]==0 && flowerbed[i+1]==0){
				flowerbed[i]= 1;
				n--;
			}
		}else if(i==flowerbed.length-1 && n>0){
			if(flowerbed[i]==0 && flowerbed[i-1]==0){
				flowerbed[i]= 1;
				n--;
			}
		}else if(flowerbed[i]==0 && flowerbed[i+1]==0 && flowerbed[i-1]==0){
			flowerbed[i]= 1;
			n--;
		}
	}
	if(n==0) return true;
    return false;
}
public static int maxSubArray(int[] nums) {
    if(nums.length == 1) return nums[0];
    int maxsum =Integer.MIN_VALUE;
    int currmax = 0;
    for(int i=0;i<nums.length;i++){
    	if(currmax+nums[i]>nums[i]){
    		currmax = currmax+nums[i];
    	}else{
    		currmax = nums[i];
    	}
    	if(currmax>maxsum) maxsum = currmax;
    }
    return maxsum;
}
public static void merge1(int[] nums1, int m, int[] nums2, int n) {
	 int p1 = m - 1;
     int p2 = n - 1;
     
     // And move p backwards through the array, each time writing
     // the smallest value pointed at by p1 or p2.
     for (int p = m + n - 1; p >= 0; p--) {
         if (p2 < 0) {
             break;
         }
         if (p1 >= 0 && nums1[p1] > nums2[p2]) {
             nums1[p] = nums1[p1--];
         } else {
             nums1[p] = nums2[p2--];
         }
     }
    
}
public static int maximumPopulation(int[][] logs) {
	  int[] year = new int[2051];
      
			// O(n) -> n is log.length
			
	        for(int[] log : logs){
	            
	            year[log[0]] += 1;
	            year[log[1]] -= 1;
	        }
	        
	        int maxNum = year[1950], maxYear = 1950;
	        
			// O(100) -> 2050 - 1950 = 100

	        for(int i = 1951; i < year.length; i++){
	            year[i] += year[i - 1];  // Generating Prefix Sum
	            
	            if(year[i] > maxNum){
	                maxNum = year[i];
	                maxYear = i;
	            }
	        }
	        
	        return maxYear;
}
public static int[] intersect(int[] nums1, int[] nums2) {
    ArrayList<Integer> arr = new ArrayList();
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int i: nums1){
    	if(map.containsKey(i)){
    		map.put(i, map.get(i)+1);
    	}else{
    		map.put(i, 1);
    	}
    }
    int count =0;
    for(int j:nums2){
    	if(map.containsKey(j) && map.get(j)>0){
    		//res[count++]=j;
    		arr.add(j);
    		count++;
    		map.put(j, map.get(j)-1);
    	}
    }
    int[] res = new int[count];
    for(int i=0;i<res.length;i++){
    	res[i]= arr.get(i);
    }
    return res;
}
public static int maxProfit(int[] prices) {
    int maxprofit = 0;
    int min = Integer.MAX_VALUE;
    /*int dp =0;
    for(int i =0;i<prices.length;i++){
    	for(int j = i;j<prices.length;j++){
    		if(i==j){
    			dp =0;
    		}else{
    			dp = prices[j]-prices[i];
    		}
    			
    		if(dp>maxprofit) maxprofit = dp;
    	}
    }*/
    
    for(int i=0;i<prices.length;i++){
    	if(prices[i]<min){
    		min = prices[i];
    	}else{
    		maxprofit = Math.max(maxprofit, prices[i]-min);
    	}
    }
    return maxprofit;
}
public static int[][] matrixReshape(int[][] mat, int r, int c) {
    int res[][] = new int[r][c];
    if(mat.length*mat[0].length != r*c){
    	return mat;
    }
    int sc =0;
    int sr =0;
    for(int i=0;i<mat.length;i++){
    	for(int j=0;j<mat[0].length;j++){
    		if(sc==c) {
    			sr++;
    			sc =0;
    		}
    		res[sr][sc] = mat[i][j];
    		sc++;
    	}
    }
    return res;
}
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle= new ArrayList<>();
    if(numRows==0) return triangle;
    List<Integer> first_row = new ArrayList<>();
    first_row.add(1);
    triangle.add(first_row);
    for(int i=1;i<numRows;i++){
    	List<Integer> prev_row = triangle.get(i-1);
    	List<Integer> row = new ArrayList<>();
    	row.add(1);
    	for(int j=1;j<i;j++){
    		row.add(prev_row.get(j)+prev_row.get(j-1));
    	}
    	row.add(1);
    	triangle.add(row);
    }
    return triangle;
}
public boolean isValidSudoku(char[][] board) {
	int row = board.length;
	int col = board[0].length;
	HashSet<String> seen = new HashSet<String>();
	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			if(board[i][j]!='.'){
				if(!seen.add(board[i][j]+"in row"+i)||
				   !seen.add(board[i][j]+"in col"+j)||
				   !seen.add(board[i][j]+"in box"+i/3+"x"+j/3)){
					return false;
				}
			}
		}
	}
    return true;
}
public static boolean searchMatrix(int[][] matrix, int target) {
	int row = matrix.length;
	int col = matrix[0].length;
	for(int i=0;i<row;i++){
		if(matrix[i][0]==target){
			return true;
		}else if(matrix[i][0]<target && matrix[i][col-1]>=target){
			if(matrix[i][col-1]==target){
				return true;
			}else{
				int start = 1;
				int end = col-2;
				while(start<=end){
					int mid = (start+end)/2;					
					if(matrix[i][mid]==target){
						return true;
					}else if(matrix[i][mid]<target){
						start = mid+1;
					}else{
						end = mid-1;
					}
				}
			}
		}
	}
    return false;
}
public static String getHint(String secret, String guess) {
    int countA =0;
    int countB = 0;
    HashMap<Character,Integer> map = new HashMap();
    for(int i=0;i<guess.length();i++){
    	char g = guess.charAt(i);
    	char s = secret.charAt(i);
    	if(s==g){
    		countA++;
    		//secret = secret.replaceFirst(secret.substring(i, i+1), "A");
    	}else{
    		if(map.getOrDefault(s, 0)<0)
    			countB++;
    		if(map.getOrDefault(g, 0)>0)
    			countB++;
    		map.put(s, map.getOrDefault(s, 0)+1);
    		map.put(g, map.getOrDefault(g, 0)-1);
    	}
    }
    return countA+"A"+countB+"B";
}
// Takes a String, and returns a HashMap with counts of
// each character.
private static Map<Character, Integer> makeCountsMap(String s) {
    Map<Character, Integer> counts = new HashMap<>();
    for (char c : s.toCharArray()) {
        int currentCount = counts.getOrDefault(c, 0);
        counts.put(c, currentCount + 1);
    }
    return counts;
}

public static boolean canConstruct(String ransomNote, String magazine) {
    if(ransomNote.length()>magazine.length()) return false;
  /*  for(int i=0;i<ransomNote.length();i++){
    	if(magazine.indexOf(ransomNote.charAt(i))==-1){
    		return false;
    	}else{
    		magazine = magazine.replaceFirst(ransomNote.substring(i, i+1), "0");
    	}
    }
    return true;*/
    // Make a counts map for the magazine.
    Map<Character, Integer> magazineCounts = makeCountsMap(magazine);
    
    // For each character in the ransom note:
    for (char c : ransomNote.toCharArray()) {
        // Get the current count for c in the magazine.
        int countInMagazine = magazineCounts.getOrDefault(c, 0);
        // If there are none of c left, return false.
        if (countInMagazine == 0) {
            return false;
        }
        // Put the updated count for c back into magazineCounts.
        magazineCounts.put(c, countInMagazine - 1);
    }
    
    // If we got this far, we can successfully build the note.
    return true;
}
public boolean hasCycle(ListNode head) {
/*	Set<ListNode> nodeSeen = new HashSet();
	while(head != null) {
		if(nodeSeen.contains(head)) {
			return true;
		}
		nodeSeen.add(head);
		head = head.next;
	}
    return false;*/
	//floyd's cycle alg
	if(head == null) return false;
	ListNode slow = head;
	ListNode fast = head.next;
	while(slow != fast) {
		if(fast == null || fast.next == null) {
			return false;
			
		}
		slow = slow.next;
		fast = fast.next.next;
	}
	return true;
}
public ListNode reverseList(ListNode head) {
	if(head == null || head.next==null) return head;
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null) {
    	ListNode temp = curr.next;
    	curr.next = prev;
    	prev = curr;
    	curr = temp;
    }
    
    return prev;
    
}
public int maxDepth(TreeNode root) {
    if(root==null) return 0;
    int left_depth = maxDepth(root.left);
    int right_depth =maxDepth(root.right);
    return Math.max(left_depth, right_depth)+1;
}
public int minDepth(TreeNode root) {
    if (root == null) {
	  return 0;
	}
	
	if ((root.left == null) && (root.right == null)) {
	  return 1;
	}
	
	int min_depth = Integer.MAX_VALUE;
	if (root.left != null) {
	  min_depth = Math.min(minDepth(root.left), min_depth);
	}
	if (root.right != null) {
	  min_depth = Math.min(minDepth(root.right), min_depth);
	}
	
	return min_depth + 1;
}
public boolean isSymmetric(TreeNode root) {
    if(root==null) return false;
    List<Integer> left = new ArrayList();
    List<Integer> right = new ArrayList();
    if(root.left!=null)  helperLeft(root.left,left);
    if(root.right!=null) helperRight(root.right,right);
    if(left.equals(right))
    	return true;
    else
    	return false;
}
private void helperLeft(TreeNode root, List<Integer> left){
    if(root==null)
        left.add(null);
    else{
        left.add(root.val);
        helperLeft(root.left,left);
	    helperLeft(root.right,left);

    }    
		
}
private void helperRight(TreeNode root, List<Integer> right){
    if(root==null)
        right.add(null);
    else    {
       right.add(root.val);
		helperRight(root.right,right);
		helperRight(root.left,right); 
    }
		

}
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();  
	if (root == null) return res;  
	Queue<TreeNode> queue = new LinkedList<>();  
	queue.add(root);  
	while (!queue.isEmpty()) {  
		List<Integer> level = new ArrayList<>();
		int cnt = queue.size();  
		for (int i = 0; i < cnt; i++) {  
			TreeNode node = queue.poll();  
			level.add(node.val);  
			if (node.left != null) {  
				queue.add(node.left);  
			}
			if (node.right != null) {  
				queue.add(node.right);  
			}  
		}
		res.add(level);  
	}
	return res;
}
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null)
    	return false;

	targetSum = targetSum - root.val;
	if ((root.left == null) && (root.right == null))
	  return (targetSum == 0);
	return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
}

public TreeNode invertTree(TreeNode root) {
    if(root==null) return null;
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    invertTree(root.left);
    invertTree(root.right);
    
    return root;
}
public TreeNode searchBST(TreeNode root, int val) {
    if(root==null || root.val==val) return root;
    
    if(root.val < val)
        return searchBST(root.right,val) ;
    else   
        return searchBST(root.left,val);

    
}
public TreeNode insertIntoBST(TreeNode root, int val) {
    if(root==null) return new TreeNode(val);
    if(val>root.val)
        root.right = insertIntoBST(root.right,val);
    else
        root.left = insertIntoBST(root.left,val);
    return root;
}
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null) return null;
    if(p.val<root.val && q.val<root.val) {
    	return lowestCommonAncestor(root.left,p,q);
    }else if(p.val>root.val && q.val>root.val) {
    	return lowestCommonAncestor(root.right,p,q);
    }else {
    	return root;
    }
    	

}
Set<Integer> vals = new HashSet();
public boolean findTarget(TreeNode root, int k) {
    if(root == null) return false;
    if(vals.contains(k-root.val)) return true;
    vals.add(root.val);
    return findTarget(root.left,k) ||findTarget(root.right,k);
    
}
public boolean validate(TreeNode root, Integer low, Integer high) {
    // Empty trees are valid BSTs.
    if (root == null) {
        return true;
    }
    // The current node's value must be between low and high.
    if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
        return false;
    }
    // The left and right subtree must also be valid.
    return validate(root.right, root.val, high) && validate(root.left, low, root.val);
}

public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
}
public int search(int[] nums, int target) {
	if(nums.length==0) return -1;
	if(nums.length==1 && nums[0]==target) return 0;
	if(nums.length==1 && nums[0]!=target) return -1;
    int start = 0;
    int end = nums.length -1;
    while(start<=end) {
    	int mid = start+(end-start)/2;
    	if(nums[mid]==target) {
    		return mid;
    	}else if(target>nums[mid]) {
    		start = mid+1;
    	}else {
    		end = mid -1;
    	}
    }
    return -1;
}
 /*   		
public int firstBadVersion(int n) {
	int start = 1;
	int end = n;
	int mid;
   while(start<end) {
	   mid = start+(end-start)/2;
	   if(isBadVersion(mid)) {
		   end = mid;
	   }else {
		   start = mid +1;
	   }
   }
   return start;
}*/

public int searchInsert(int[] nums, int target) {
	int start = 0;
    int end = nums.length -1;
    while(start<=end) {
    	int mid = start+(end-start)/2;
    	if(nums[mid]==target) {
    		return mid;
    	}else if(target>nums[mid]) {
    		start = mid+1;
    	}else {
    		end = mid -1;
    	}    	
    }
    return start;
}
public int[] sortedSquares(int[] nums) {
    int start =0;
    int end = nums.length-1;
    int[] res = new int[nums.length];
    int count = nums.length-1;
    while(start<=end) {
    	if(nums[end]*nums[end]>=nums[start]*nums[start]) {
    		res[count--]= nums[end]*nums[end];
    		end--;
    	}else {
    		res[count--] = nums[start]*nums[start];
    		start++;
    	}
    }
    return res;
}
public void moveZeroes(int[] nums) {
	if(nums.length>1)
        for(int j=0,i=0;j<nums.length;j++) {
    	if(nums[i]!=0) i++;
    	if(j>i && nums[i]==0 && nums[j]!=0) {
    		int temp = nums[j];
    		nums[j] = nums[i];
    		nums[i] = temp;
    		i++;
    	}
    }
}
public String reverseWords(String s) {
	 String[] str = s.split(" ");
		String res ="";
		for(int i=0; i<str.length;i++) {
			char[] torev = str[i].toCharArray();
			int  start =0;
			int end = torev.length-1;
			while(start<end) {
			   char temp = torev[start];
			   torev[start]=torev[end];
			   torev[end]=temp;
			   start++;
			   end--;
			}
			str[i] = String.valueOf(torev);
	        if(i != str.length - 1)
			    res = res.concat(str[i]+" ");
	        else
	            res = res.concat(str[i]);
		}
		
	   return res;
	    
}
public ListNode middleNode(ListNode head) {
    ListNode fast =head,slow=head;
    while(fast!=null && fast.next!=null) {
    	slow = slow.next;
    	fast = fast.next.next;
    }
    return slow;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {-1,-2,-3,-4,-5};
		//int target =-8;
		//System.out.println(twoSum(nums,target));
		//System.out.println(isPalindrome(10));
		//System.out.println(climbStairs(10));
		//System.out.println(romanToInt( "MCMXCIV"));
		//System.out.println(longestCommonPrefix(new String[]{"aa","aa"}));
		//System.out.println(lengthOfLongestSubstring("pwwkew"));
		//System.out.println(isValid("(){}}{"));
		//int[] nums1 = {1,3,5,2,4};
		//int[] nums2 = {5,4,3,2,1};
		//int[] ans = nextGreaterElement(nums1,nums2);
		//for(int i: ans) System.out.println(i);
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cc");
		wordDict.add("ac");
		//wordDict.add("sand");
		//wordDict.add("and");
		//wordDict.add("cat");
		//wordDict.add("dog");
		//System.out.println(wordBreak("ccaccc",  wordDict));
		LinkedList<Integer> l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(4);
		LinkedList<Integer> l2 = new LinkedList();
		l2.add(1);
		l2.add(3);
		l2.add(4);
				
		//System.out.println(isUgly(19));
		//System.out.println(countSubstrings("abc"));
		//buildArray(new int[]{5,0,1,2,3,4});
		//getConcatenation(new int[]{1,2,1});
		//System.out.println(finalValueAfterOperations(new String[]{"--X","X++","X++"}));
		//runningSum(new int[]{1,2,3,4});
		//shuffle(new int[]{1,2,3,4},2);
		//smallerNumbersThanCurrent(new int[]{8,6,4,9});
		//restoreString("aaiougrt",new int[]{4,0,2,6,7,3,1,5});
		//coinChange(new int[]{1,2,5},11);
		//reverseString(new char[]{'h','e','l','l','o'});
		//firstUniqChar("leetcode");
		//rotate(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
		//transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		//sumOfUnique(new int[]{1,2,3,2});
		//sumZero(5);
		//decompressRLElist(new int[]{1,2,3,2});
		//canPlaceFlowers(new int[]{1,0,0,0,1},2);
		//merge1(new int[]{4,5,6,0,0,0},3,new int[]{1,2,3},3);
		//maximumPopulation(new int[][]{{1993,1999},{2000,2010}});
		//searchMatrix(new int[][]{{1,3,5,7}},5);
		//getHint("1123","0111");
		canConstruct("aa","ab");
	}

}
