package leetcode;

public class AddTwoNumber {
	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		int preResult = 0;
		int currentResult = 0;
		ListNode head = new ListNode(0);
		ListNode currentNode = head;
		while (l1 != null || l2 != null || preResult!=0) {
			currentResult=0;
			if(l1!=null){
				currentResult+=l1.val;
				l1=l1.next;
			}
			if(l2!=null){
				currentResult+=l2.val;
				l2=l2.next;
			}
			currentResult+= preResult;
			currentNode.next = new ListNode(currentResult%10);
			currentNode = currentNode.next;
			preResult = currentResult/10;
			
			
		}
		return head.next;
	
    }

}
