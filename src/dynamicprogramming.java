
public class dynamicprogramming {
	public static int fact(int n){
		//bottom-up approach
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i=1;i<=n;i++){
			dp[i] = dp[i-1]*i;
		}
		return dp[n];
	}
	public static int solve(int x){
		int dp[] = new int[x+1];
		dp[x] =-1;
	    if (x==0)
	        return 1;
	    if (dp[x]!=-1)
	        return dp[x];
	    return (dp[x] = x * solve(x-1));
	}
	public static void main(String[] args) {
		//for(int n = 0;n<7;n++){
		//	System.out.println(fibonacci(n));
		//}
		System.out.println(solve(5));
	}
}
