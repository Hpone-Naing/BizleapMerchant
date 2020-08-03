package com.bizleap.training.assignments;

import java.util.Stack;

public class ReverseOrderUsingStack {

	public void toReverse(String words) {

		Stack<String> stack = new Stack<String>();
		if (words != null) {
			for (String word : words.split("\\s+")) {
				stack.push(word);
			}

			while (!stack.empty()) {
				System.out.print(stack.peek() + " ");
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {

		String sentense = "Naw Phaw Hkee Lar Mya";
		System.out.print(sentense + "----->");
		new ReverseOrderUsingStack().toReverse(sentense);

	}

}
