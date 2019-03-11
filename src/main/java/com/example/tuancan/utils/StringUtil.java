package com.example.tuancan.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private StringUtil() {
        //doNothing;
    }

    //判断字符串是否为空
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    //比较字符串是否相等
    public static boolean stringEquals(String str1, String str2) {
        return stringEquals(str1, str2, true);
    }

    //判断字符串是否匹配
    public static boolean stringEquals(String str1, String str2, boolean ignoreCase) {
        boolean result = false;
        try {
            //同时为空，视为相同， null和空字符串视为相同
            if (isNullOrEmpty(str1) && isNullOrEmpty(str2)) {
                return true;
            }
            if (!isNullOrEmpty(str1)) {
                if (ignoreCase) {
                    result = str1.equalsIgnoreCase(str2);
                } else {
                    result = str1.equals(str2);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    //判断是否符合正则表达式
    public static boolean isMatch(String regex, String orginal) {
        if (orginal == null || orginal.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(orginal);
        return matcher.matches();
    }

    //判断是否为正整数
    public static boolean isPositiveInteger(String orginal) {
        return isMatch("^\\+?[1-9]\\d*$", orginal);
    }

    //判断是否为负整数
    public static boolean isNegativeInteger(String orginal) {
        return isMatch("^-[1-9]\\d*$", orginal);
    }

    //判断是否全为数字
    public static boolean isWholeNumber(String orginal) {
        return isMatch("^[+-]?0$", orginal);
    }

    //判断是否全为整数
    public static boolean isInteger(String orginal) {
        return isPositiveInteger(orginal) || isNegativeInteger(orginal);
    }

    //是否为正浮点数
    public static boolean isPositiveDecimal(String orginal) {
        return isMatch("^\\+?[0]\\.[1-9]*$^\\+?[1-9]\\d*\\.\\d*$", orginal);
    }

    //是否为负浮点数
    public static boolean isNegativDecimal(String orginal) {
        return isMatch("^-[0]\\.[1-9]*$|^-[1-9]\\d*\\.\\d*$", orginal);
    }

    //是否为浮点数
    public static boolean isDecimal(String orginal) {
        return isMatch("^[-+]?\\d+\\.\\d*$|^[-+]?\\d*\\.\\d+$", orginal);
    }

    //是否为数字
    public static boolean isNumber(String orginal) {
        return isWholeNumber(orginal) || isDecimal(orginal);
    }

    //是否从数字开始
    public static boolean isStartWithNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(str.charAt(0) + "");
        return matcher.matches();
    }

    //是否包含特殊字符
    public static boolean isContainAnyPuncyuation(String str) {
        Pattern pattern = Pattern.compile("[`~!@#$^&*()+|{}':;',\\[\\].<>/~!@#【】：“》？：；]");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
