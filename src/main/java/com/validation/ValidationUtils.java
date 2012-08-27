package com.validation;

import java.util.Collection;

import com.utils.string.StringUtils;

public class ValidationUtils {

	public static void rejectIfEmpty(String target, String bindPath, ErrorStack errorStack, String errMsg) {
		if (StringUtils.isEmpty(target)) {
			errorStack.push(bindPath, errMsg);
		}
	}

	public static void rejectIfNotMatchRegx(String target, String bindPath, String regx, ErrorStack errorStack,
			String errMsg) {
		if (target == null) {
			errorStack.push(bindPath, errMsg);
			return;
		}
		if (!target.matches(regx)) {
			errorStack.push(bindPath, errMsg);
		}
	}

	public static void rejectIfIncorrectPhoneOrTelPhone(String target, String bindPath, ErrorStack errorStack,
			String errMsg) {
		if (target == null || target.equals("")) {
			errorStack.push(bindPath, errMsg);
			return;
		}
		final String regxForPhone = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$";
		final String regxForTelPhone = "^\\d{3,4}-\\d{7,8}(-\\d{3,4})?$";
		if (!target.matches(regxForPhone) && !target.matches(regxForTelPhone)) {
			errorStack.push(bindPath, errMsg);
		}
	}

	public static void rejectIfNotMatchLegth(String target, String bindPath, int minLen, int maxLen,
			ErrorStack errorStack, String errMsg) {
		if (target == null) {
			errorStack.push(bindPath, errMsg);
			return;
		}
		if (target.length() < minLen || target.length() > maxLen) {
			errorStack.push(bindPath, errMsg);
		}
	}

	public static void rejectIfNotMatchCount(String target, String bindPath, int minCount, int maxCount,
			ErrorStack errorStack, String errMsg) {
		try {
			Integer value = Integer.valueOf(target);
			if (value < minCount || value > maxCount) {
				errorStack.push(bindPath, errMsg);
			}
		} catch (NumberFormatException ex) {
			errorStack.push(bindPath, errMsg);
		}
	}

	public static void rejectIfIncorrectPhoneNumber(String target, String bindPath, ErrorStack errorStack, String errMsg) {
		String regxForValiteMobile = "^((\\+{0,1}86){0,1})1[0-9]{10}";
		rejectIfNotMatchRegx(target, bindPath, regxForValiteMobile, errorStack, errMsg);
	}

	public static void rejectIfIncorrectEmailAddr(String target, String bindPath, ErrorStack errorStack, String errMsg) {
		String regxForValiteEmailAddr = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		rejectIfNotMatchRegx(target, bindPath, regxForValiteEmailAddr, errorStack, errMsg);
	}

	public static void rejectIfIncorrectAmount(String target, String bindPath, ErrorStack errorStack, String errMsg) {
		final String regxForValiteAmount = "^({0,1}|\\+{0,1})[0-9]+(\\.{0,1}[0-9]+)$";
		rejectIfNotMatchRegx(target, bindPath, regxForValiteAmount, errorStack, errMsg);
	}

	public static void rejectIfSpecialCharacter(String target, String bindPath, ErrorStack errorStack, String errMsg) {
		String regxForSpecialCharacter = "^[a-zA-Z\u4e00-\u9fa5][a-zA-Z \u4e00-\u9fa5]+$";
		rejectIfNotMatchRegx(target, bindPath, regxForSpecialCharacter, errorStack, errMsg);
	}

	public static void rejectIfIncorrectZipCode(String target, String bindPath, ErrorStack errorStack, String errMsg) {
		String regxForSpecialCharacter = "[1-9]\\d{5}(?!\\d)";
		rejectIfNotMatchRegx(target, bindPath, regxForSpecialCharacter, errorStack, errMsg);
	}

	public static void rejectIfConllectionIsEmpty(Collection<?> collection, String bindPath, ErrorStack errorStack,
			String errMsg) {
		if (collection == null || collection.isEmpty()) {
			errorStack.push(bindPath, errMsg);
		}
	}
}