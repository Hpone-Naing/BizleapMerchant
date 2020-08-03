package com.bizleap.training.assignments;

import java.util.*;

public class ReverseWordsUsingStack {
	
	public String doApop(Stack<String> stack) {
		try {
			stack.pop();
		}catch(Exception e) {
		System.out.println("Exception occurs while popping the stack:"+e.getMessage());
		try {
			throw e;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		}		
		return null;
	}

	public String reverseString(String inputString) {
		String result="";
		Stack<String> stack=new Stack<String>();
		if(inputString != null) {
			for(String s:inputString.split("\\s+"))
			stack.push(s +" ");
		}
		int count=0;
		while(count++ <10) {
			String value=doApop(stack);
			result+=value !=null? value:"";
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			System.out.println(new ReverseWordsUsingStack().reverseString("Nice to meet you."));
		}catch(Exception e) {
			System.out.println("Reverse order ended with exception"+ e.toString());
		}
	}

}
