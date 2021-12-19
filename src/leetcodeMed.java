
public class leetcodeMed {
public void rotate(int[] nums, int k) {
		    k %= nums.length;
		    reverse(nums, 0, nums.length - 1);
		    reverse(nums, 0, k - 1);
		    reverse(nums, k, nums.length - 1);
}
public void reverse(int[] nums, int start, int end) {
		    while (start < end) {
		      int temp = nums[start];
		      nums[start] = nums[end];
		      nums[end] = temp;
		      start++;
		      end--;
		    }
		  
 }
public ListNode removeNthFromEnd(ListNode head, int n) {
	   ListNode dummy = new ListNode(0);
	   dummy.next = head;
	   ListNode first = dummy;
	   ListNode second = dummy;
	   for(int i=1;i<=n+1;i++) {
		   first = first.next;
	   }
	   while(first!=null) {
		   first = first.next;
		   second = second.next;
	   }
	   second.next = second.next.next;
	   return dummy.next;
}
	public static void main(String[] args) {
		
	}
}
