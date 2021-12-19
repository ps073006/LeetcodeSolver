import java.util.Arrays;
public class bubblesort {

	public static void main(String args[]){
		bubbleSort(new int[] { 20, 12, 45, 19, 91, 55 }); 
		bubbleSort(new int[] { -1, 0, 1 }); 
		bubbleSort(new int[] { -3, -9, -2, -1 });


	}
	
	public static void bubbleSort(int[] numbers) { 
		System.out.println( Arrays.toString(numbers)+ "\n");
		for(int i=0; i < numbers.length; i++){
			for(int j = numbers.length-1; j>i;j--){
				if(numbers[j]< numbers[j-1]){
					swap(numbers,j,j-1);
				}
			}
		}
		
		System.out.println( Arrays.toString(numbers)+ "\n");
	}
	
	public static void swap(int[] numbers, int from, int to){
		int temp = numbers[from];
		numbers[from] = numbers[to];
		numbers[to] = temp;
	}

	}
