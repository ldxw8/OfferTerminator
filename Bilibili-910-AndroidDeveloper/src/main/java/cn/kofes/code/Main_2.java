package cn.kofes.code;

import java.util.Scanner;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/09/10
 * desc  :
 * ==============================================
 * 题目
 * ==============================================
 * 描述
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
                    result = isEqual(s1, s2);
                } else {
                    result = true;
                }
            }
        }

        System.out.printf(""+result);

    }

    public static boolean isEqual(String  s1, String s2) {

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        if (str1.length <= str2.length) {
            // str1 是子串
            for ( int i = 0;i<str2.length;i++ ) {
                for (int j  = 0;j<str1.length;j++) {

                }
            }
        } else {
            // str2 是子串
            for ( int i = 0;i<str1.length;i++ ) {
                for (int j  = 0;j<str2.length;j++) {

                }
            }
        }

        return false;
    }
}
