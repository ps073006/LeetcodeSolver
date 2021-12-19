
public class numbers {
	public static void main(String args[]) { 
		//System.out.println("Is aaa palindrom?: " + isPalindromString("abba")); 
		//System.out.println("Is abc palindrom?: " + isPalindromString("ababc")); 
		printMissingNumbers(new int[]{1, 2, 3, 4, 5}, 6);
		printMissingNumbers(new int[]{1, 2, 3, 4, 6, 7, 9, 10}, 10);

		}
	public static void printMissingNumbers(int[] number,int count){
		int missingCounts=count - number.length;
		int countAllMissings=0;

		for(int i=1;i<count;i++){
			if(number[i-1-countAllMissings] != i){
				System.out.println("missing number " + i);
				countAllMissings++;
				if(countAllMissings == missingCounts){
					break;
				}
			}
		}
		if(countAllMissings == 0){
			System.out.println("missing number " + count);
		}

		}

	}
