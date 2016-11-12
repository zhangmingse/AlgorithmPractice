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
		ListNode head = null;
		ListNode currentNode = null;
		int l1_len = 0;
		int l2_len = 0;
		currentNode = l1;
		while (currentNode != null) {
			l1_len++;
			currentNode = currentNode.next;
		}
		currentNode = l2;
		while (currentNode != null) {
			l2_len++;
			currentNode = currentNode.next;
		}
		if (l1_len == 0 && l2_len == 0)
			return null;

		currentNode = null;
		ListNode[] new_nodes = null;
		int maxlen = 0;
		if (l1_len > l2_len) {
			new_nodes = new ListNode[l1_len + 1];
			maxlen = l1_len + 1;
		} else {
			new_nodes = new ListNode[l2_len + 1];
			maxlen = l2_len + 1;
		}
		for (int i = 0; i < maxlen; i++) {
			new_nodes[i] = new ListNode(0);
		}
		for (int i = 0; i < maxlen - 1; i++) {
			new_nodes[i].next = new_nodes[i + 1];
		}
		head = new_nodes[0];
		currentNode = head;
		ListNode preNode = head;//the node just before current node

		while (l1 != null || l2 != null || preResult != 0) {
			currentResult = 0;
			if (l1 != null) {
				currentResult += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				currentResult += l2.val;
				l2 = l2.next;
			}
			currentResult += preResult;
			if (currentResult > 9) {
				preResult = currentResult / 10;
				currentResult = currentResult % 10;
			} else {
				preResult = 0;
			}
			currentNode.val = currentResult;
			preNode = currentNode;
			currentNode = currentNode.next;
		}
		preNode.next = null;
		return head;
	}

}
