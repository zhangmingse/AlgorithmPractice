package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
	public static void main(String[] args) {
		Solution225 solution225 = new Solution225();
		Solution225.MyStack mystack = solution225.new MyStack();
		mystack.push(1);
		mystack.push(3);
		mystack.push(4);
		System.out.println(mystack.pop());
		System.out.println(mystack.top());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		
	}

	class MyStack {

		Queue<Integer> queueA = null;
		Queue<Integer> queueB = null;
		Queue<Integer> currentQueue = null;
		Queue<Integer> anotherQueue = null;

		/** Initialize your data structure here. */
		public MyStack() {
			queueA = new LinkedList<>();
			queueB = new LinkedList<>();
			currentQueue = queueA;
			anotherQueue = queueB;
		}

		/** Push element x onto stack. */
		public void push(int x) {
			currentQueue.add(x);
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			Integer integer = currentQueue.poll();
			while (!currentQueue.isEmpty()) {
				anotherQueue.add(integer);
				integer = currentQueue.poll();
			}
			Queue<Integer> temp = currentQueue;
			currentQueue = anotherQueue;
			anotherQueue = temp;

			return integer;

		}

		/** Get the top element. */
		public int top() {
			Integer integer = currentQueue.poll();
			while (!currentQueue.isEmpty()) {
				anotherQueue.add(integer);
				integer = currentQueue.poll();
			}
			anotherQueue.add(integer);

			Queue<Integer> temp = currentQueue;
			currentQueue = anotherQueue;
			anotherQueue = temp;

			return integer;
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return currentQueue.isEmpty();
		}
	}
}
