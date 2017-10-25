package leetcode;

import leetcode.Solution.ListNode;

public class Solution203 {

	public static void main(String[] args) {

		Solution solution = new Solution();
		Solution203 solution203 = new Solution203();
		ListNode node1 = solution.new ListNode(1);
		ListNode node2 = solution.new ListNode(2);
		node1.next = node2;
		ListNode node3 = solution.new ListNode(3);
		node2.next = node3;
		ListNode node4 = solution.new ListNode(3);
		node3.next = node4;
		ListNode node5 = solution.new ListNode(5);
		node4.next = node5;
		
		solution203.showList(node1);
		ListNode result = solution203.removeElements(node1, 3);
		solution203.showList(result);
	}
	
	public void showList(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode node1 = null, node2 = null;
		if (head == null) {
			return null;
		}
		while(head!=null && head.val == val){//find the first different node
			head = head.next;
		}
		if(head == null){
			return head;
		}
		node1 = head;
		node2 = node1.next;
		
		while(node2 !=null){
			while(node2!=null && node2.val == val){
				node2 = node2.next;
			}
			node1.next = node2;
			node1 = node1.next;
			if(node2==null){
				break;
			}
			node2 = node2.next;
		}
		
		return head;
		
	}
}
