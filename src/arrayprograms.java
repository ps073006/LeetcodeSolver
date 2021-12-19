import java.util.*;

public class arrayprograms {
	//private static final int Hashmap = 0;
	//How do you find the missing number in a given integer array of 1 to 10?
	public static int missingInt(int[] arr){
		if(arr.length ==0) return 0;
		int sum = 0, sum1 = 0 ;
		//for(int i=1;i<=10;i++){
		//	sum+=i;
		//}
		//sum of n element , n*(n+1)/2
		int totalnum = arr.length+1;
		sum = totalnum * (totalnum+1)/2;
		for(int i=0; i<=arr.length-1;i++){
			sum1+= arr[i];
		}

		return sum-sum1;
	}
	//How do you find the duplicate number on a given integer array?
	public static int duplicateElem(int[] arr){
		Map<Integer,Integer> dupcount = new HashMap<>();
		int dupfound = 0;
		for(int i: arr){
			if(dupcount.containsKey(i)){
				//return i;
				dupfound = i;
				break;
			}
			else{
				dupcount.put(i, 1);
			}
		}
		return dupfound;
	}
	//How do you find the largest and smallest number in an unsorted integer array?
	public static void largestSmallestNum(int[] arr){
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		for(int i=0 ; i<= arr.length-1;i++){
			if(arr[i]>largest){
				largest = arr[i];
			}
			if (arr[i]< smallest){
				smallest = arr[i];
			}
		}
		System.out.println(smallest +"   "+largest);
	}
	//How do you find all pairs of an integer array whose sum is equal to a given number?
	public static void sumPair(int[] arr,int sum){
		for(int i =0; i<=arr.length-1;i++){
			if(arr[i]<= sum){
				for(int j =i+1;j<=arr.length-1;j++){
					if(arr[j]== sum - arr[i]){
						System.out.println(arr[i]+"  "+arr[j]);
					}
				}
			}
		}
	}
	//How do you find duplicate numbers in an array if it contains multiple duplicates?
	public static void mulDuplicateElem(int[] arr){
		Map<Integer,Integer> dupcount = new HashMap<>();
		int dupfound = 0;
		for(int i: arr){
			if(dupcount.containsKey(i)){
				//return i;
				dupcount.put(i,dupcount.get(i)+1);
				//break;
				System.out.println(i);
			}
			else{
				dupcount.put(i, 1);
			}
		}
		
		//return dupfound;
	}
	//		How are duplicates removed from a given array in Java?
	//		How do you remove duplicates from an array in place?
	//		How are duplicates removed from an array without using any library?
	public static void removeDuplicates(int[] arr){
		Map<Integer,Integer> dupcount = new HashMap<>();
		int[] newarr = new int[arr.length];
		int j =0;
		for(int i=0; i<= arr.length-1;i++){
			if(dupcount.containsKey(arr[i])){
				//return i;
				dupcount.put(arr[i],dupcount.get(arr[i])+1);
				//break;
				//System.out.println(i);
			}
			else{
				newarr[j] = arr[i];
				dupcount.put(arr[i], 1);
				j++;
				System.out.print(newarr[j-1]+",");
				
			}
		}
		
		
	}
	//		How is an integer array sorted in place using the quicksort algorithm?

	//		How do you reverse an array in place in Java?
	public static void reverseArray(int[] arr){
		int[] newarr = new int[arr.length];
		int j =0;
		for(int i = arr.length -1;i>=0;i--){
			newarr[j] = arr[i];
			j++;
			System.out.print(newarr[j-1]+",");
		}
	}
	public static int[] arrayRotate(int[] arr, int d, int n){
		int[] newarr = new int[n];
		arr =  reverse(arr, 0,d-1);
		arr = reverse(arr,d,n-1);
		newarr = reverse(arr,0,n-1);
		return newarr;
	}
	public static int[] reverse(int[] rev, int a, int b){
		int temp;
		while(a<b){
			temp = rev[a];
			rev[a] = rev[b];
			rev[b] = temp;
			a++;
			b--;
		}
		return rev;
	}
	public static void main(String[] args){
		//int[] arr= {1,5,3,4,2,6,8,9,10};
		//System.out.println(missingInt(arr));
		int[] arr= {1,5,3,4,2,6,8,9,10,5,3};
		//System.out.println(duplicateElem(arr));
		//largestSmallestNum(arr);
		//sumPair(arr,7);
		//mulDuplicateElem(arr);
		//removeDuplicates(arr);
		//reverseArray(arr);
		arrayRotate(new int[]{4,5,6,7,1,2,3},2,7);
	}
}
