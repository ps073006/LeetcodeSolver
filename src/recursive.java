
public class recursive {
	public static int fibonacci(int n){
		//base case
		if(n == 0) return 0;
		if(n==1||n==2) return 1;
		//otherwise
		return fibonacci(n-1) + fibonacci(n-2);
	}
	public static int fact(int n){
		//base case
		if(n<=1) return 1;
		//otherwise
		return n*fact(n-1);
	}
	//divide and concuer Alg
	public static int DACMax(int[] a, int index, int len){
		int max;
		if(index>=len-2){
			if(a[index]>a[index+1]){
				return a[index];
			}else{
				return a[index+1];
			}	
		}
		max = DACMax(a,index+1,len);
		if(a[index]>max)
			return a[index];
		else
			return max;
	}
	public static int DACMin(int[] a, int index, int len){
		int min;
		if(index>=len-2){
			if(a[index]<a[index+1])
				return a[index];
			else
				return a[index+1];
		}
		min = DACMin(a,index+1,len);
		if(a[index]<min)
			return a[index];
		else
			return min;
	}
	
	public static void main(String[] args) {
		//for(int n = 0;n<7;n++){
		//	System.out.println(fibonacci(n));
		//}
		//System.out.println(fact(5));
		int[] a = {70, 250, 50, 80, 140, 12, 14};
		//System.out.println(DACMax(a,0,7));
		System.out.println(DACMin(a,0,7));
	}
}
