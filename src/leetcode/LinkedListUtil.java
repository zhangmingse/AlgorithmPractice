package leetcode;


public class LinkedListUtil {
	
	

	public static void showList(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static ListNode makeList(int[] arr){
		
		if(arr ==null || arr.length ==0){
			return null;
		}
		ListNode head = new ListNode(arr[0]);
		ListNode temp = head;
		for(int i = 1;i<arr.length;i++){
			ListNode node = new ListNode(arr[i]);
			temp.next = node;
			temp = temp.next;
		}
		
		return head;
	}
}
