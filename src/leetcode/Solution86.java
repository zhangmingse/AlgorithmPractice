package leetcode;

public class Solution86 {

	public static void main(String[] args) {

		ListNode head = LinkedListUtil.makeList(new int[] { 1, 4, 3, 2, 5, 2 });

		LinkedListUtil.showList(head);

		Solution86 solution86 = new Solution86();

		head = solution86.partition(head, 3);

		LinkedListUtil.showList(head);
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode lower_head = null, lower_current = null;
		ListNode upper_head = null, upper_current = null;
		ListNode orig_list_current = null;

		orig_list_current = head;
		if (orig_list_current.val < x) {
			lower_head = orig_list_current;
			lower_current = lower_head;

			orig_list_current = orig_list_current.next;
			while (orig_list_current != null) {

				if (orig_list_current.val >= x) {
					break;
				}
				lower_current = orig_list_current;
				orig_list_current = orig_list_current.next;

			}
			if (orig_list_current == null) {
				return lower_head;
			} else {
				upper_head = orig_list_current;
				upper_current = upper_head;

				orig_list_current = orig_list_current.next;
				while (orig_list_current != null) {
					if (orig_list_current.val < x) {
						break;
					}
					upper_current = orig_list_current;
					orig_list_current = orig_list_current.next;
				}
			}
		} else {
			upper_head = orig_list_current;
			upper_current = orig_list_current;

			orig_list_current = orig_list_current.next;
			while (orig_list_current != null) {
				if (orig_list_current.val < x) {
					break;
				}
				upper_current = orig_list_current;
				orig_list_current = orig_list_current.next;
			}
			if (orig_list_current == null) {
				return upper_head;
			} else {
				lower_head = orig_list_current;
				lower_current = lower_head;

				orig_list_current = orig_list_current.next;
				while (orig_list_current != null) {
					if (orig_list_current.val >= x) {
						break;
					}
					lower_current = orig_list_current;
					orig_list_current = orig_list_current.next;
				}
			}

		}
		while (orig_list_current != null) {
			if (orig_list_current.val < x) {
				lower_current.next = orig_list_current;
				lower_current = lower_current.next;
			} else {
				upper_current.next = orig_list_current;
				upper_current = upper_current.next;
			}

			orig_list_current = orig_list_current.next;
		}

		upper_current.next = null;
		lower_current.next = upper_head;

		return lower_head;

	}
}
