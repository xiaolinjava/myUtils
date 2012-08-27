package com.validation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ErrorStack {
	private Map<String, LinkedList<String>> errorMap = new HashMap<String, LinkedList<String>>();

	public void push(String bindPath, String errMsg) {
		LinkedList<String> errorStack = errorMap.get(bindPath);
		if (errorStack == null) {
			errorStack = new LinkedList<String>();
		}
		errorStack.push(errMsg);
		errorMap.put(bindPath, errorStack);
	}

	public String pop(String bindPath) {
		LinkedList<String> errorStack = errorMap.get(bindPath);
		if (errorStack != null) {
			return errorStack.pop();
		}
		return "";
	}

	public Map<String, LinkedList<String>> getErrorMap() {
		return errorMap;
	}
	
}
