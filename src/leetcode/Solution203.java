package leetcode;


public class Solution203 {

	public static void main(String[] args) {

		Solution203 solution203 = new Solution203();
		ListNode node1  = LinkedListUtil.makeList(new int[]{1,2,3,3,5});
		
		LinkedListUtil.showList(node1);
		ListNode result = solution203.removeElements(node1, 3);
		LinkedListUtil.showList(result);
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
