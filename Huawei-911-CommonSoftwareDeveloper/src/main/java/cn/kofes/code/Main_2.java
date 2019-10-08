package cn.kofes.code;

import java.util.Scanner;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/09/11
 * desc  :
 * ==============================================
 * 华为 2020 届校园招聘 -- 软件题 -- 编程 2
 * 通过 100% 的测试用例
 * ==============================================
 * 题目描述：对数字，字符，字符串以及数字与字符串组合进行倒序排序。
 * ==============================================
 * </pre>
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String input = "I am an 20-years  out--standing @ * - stu- dent";
        String input = scanner.nextLine();
        String[] words = null;

        if (null != input) {
            if (!"".equals(input)) {
                input = wash2StandardStr(input);
                words = input.split("( )+");
                printDescWordList(words);
            } else {
                System.out.printf("");
            }
        } else {
            System.out.printf("");
        }
    }

    public static String wash2StandardStr(String str) {
        // Step.01 去掉非法字符
        String regex_ill = "[^(\\d|\\w|( )|-|(\\-\\-))]*";
        /**
         * Step.02 替换单独的 "-" 符号和 "--" 符号为空格
         * "-" 符号识别标志：-xxx、xxx- 或者 [空格]-[空格]
         *  "--" 符号识别标志：xxx--xxx
         */
        String regex_subLine = "([ ]+\\-)|(\\-[ ]+)|(--)";

        String str1 = str.replaceAll(regex_ill, "");
        String str2 = str1.replaceAll(regex_subLine, " ");

        return str2;
    }

    public static void printDescWordList(String[] src) {
        for (int i = src.length - 1; i >= 0; i--) {
            if (i > 0) {
                System.out.print(src[i] + " ");
            } else {
                System.out.print(src[i]);
            }

        }
    }
}
