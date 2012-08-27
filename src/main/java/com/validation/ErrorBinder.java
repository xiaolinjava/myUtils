package com.validation;


import java.util.LinkedList;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public class ErrorBinder {

	public static void bindError(ErrorStack stack, BindingResult bindingResult) {
		if (stack == null) {
			return;
		}
		Map<String, LinkedList<String>> errorMap = stack.getErrorMap();
		if (errorMap != null) {
			for (String bindPath : errorMap.keySet()) {
				String errorMsg = stack.pop(bindPath);
				bindingResult.rejectValue(bindPath, "", errorMsg);
			}
		}
	}

   public static void bindError(ErrorStack stack, Model model) {
		if (stack == null) {
			return;
		}
		Map<String, LinkedList<String>> errorMap = stack.getErrorMap();
		if (errorMap != null) {
			for (String bindPath : errorMap.keySet()) {
				String errorMsg = stack.pop(bindPath);
				model.addAttribute(bindPath, errorMsg);
			}
		}
	}
}
