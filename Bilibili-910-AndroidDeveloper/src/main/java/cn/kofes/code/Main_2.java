package cn.kofes.code;

import java.util.Scanner;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/09/10
 * desc  :
 * ==============================================
 * Bilibili 2020 届秋季校园招聘 -- Android 方向笔试卷（二）-- 编程 2
 * ==============================================
 * 题目描述：检索两字符是否有包含或者相等关系
 * ==============================================
 * </pre>
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String regex= "[A-Z|a-z]+";

        boolean result  = false;

        if ( null != s1 && null != s2 ) {
            if ( s1.matches(regex) && s2.matches(regex) ) {
                if ( !s1.equals(s2) ) {
                    result = isEqualStr(s1, s2);
                } else {
                    result = true;
                }
            }
        }

        System.out.printf(""+result);

    }

    public static boolean isEqualStr(String  s1, String s2) {

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int choice  =  (str1.length >= str2.length)?0:1;

        boolean result = false;

        switch (choice) {
            case 0: // str2 为较小长度的子串
                result = isEqualCharArray(str1, str2);
                break;
            case 1: // str1 为较小长度的子串
                result = isEqualCharArray(str2, str1);
                break;
        }
        return result;
    }

    /**
     * 检索两字符数组是否有包含或者相等关系
     * @param former 表示长度较大的字符数组
     * @param latter 长度较小的字符数组
     * @return 若 former 和 latter 有包含或者相等关系，返回 True；其他  False
     */
    public static boolean isEqualCharArray(char[] former, char[] latter) {
        boolean result = false;
        for (int i = 0, j = 0; i < former.length; i++) {
            if (former[i] == latter[j]) {
                if (latter.length == j + 1) {
                    result = true;
                    break;
                }
                j += 1;
            } else {
                j = 0;
            }
        }
        return result;
    }
}
