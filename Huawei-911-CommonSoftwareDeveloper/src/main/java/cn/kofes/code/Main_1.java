package cn.kofes.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/10/08
 * desc  :
 * ==============================================
 * 华为 2020 届校园招聘 -- 软件题 -- 编程 1
 * ==============================================
 * 题目描述：
 * 数轴 X 有两个点的序列 A = {A1, A2, ...., Am} 和 B = {B1, B2, ...., Bm},
 * Ai 和 Bj 均为正整数，A、B 已经从小到大排好序，A、B 均肯定不为空。
 * 给定一个距离 R (正整数)，列出同时满足如下条件的所有 (Ai，Bj) 数对。
 * 1) Ai <= Bj
 * 2) Ai，Bj 距离小于等于 R。
 *     如果 Ai 找不到 R 范围内的 Bj，则列出距它最近的一个 Bj，
 *     当然此种情况仍然要满足 (1)；
 *     如果仍然找不到就丢弃 Ai。
 * ==============================================
 * </pre>
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );

        // A={1,3,5}, B={2,4,6},R=1
        // A ={ 1,3 , 5 } , B= { 2,4 , 6 } ,R = 1
        // A ={ 1,3 , 5,7 } , B= { 2,4 , 6,10 } ,R = 1

        String src =  scanner.nextLine();
        String[]  inputStr = null;
        List<Integer>[] inputNum  = new List[3];

        if ( null != src && !"".equals(src) ) {
            inputStr = getStrVarables(src);
            for (int i = 0; i < inputStr.length; i++) {
                inputNum[i] = getIntVarables(inputStr[i]);
                // printIntArray(getIntVarables(inputStr[i]));
            }

            calculator(inputNum);
        }
    }

    public static void calculator(List<Integer>[] list) {

        Integer R = list[2].get(0);
        Integer min = Integer.MAX_VALUE, pos = 0;
        Boolean swi  = false;

        for (int i = 0; i < list[0].size(); i++) { // A

            for (int j = 0; j < list[1].size(); j++) { // B
                if ( list[1].get(j) >= list[0].get(i)  ) { // Bj <= Ai
                    if ( (list[1].get(j) - list[0].get(i)) <= R ) {
                        // Ai，Bj 距离小于等于 R
                        System.out.print("(" + list[0].get(i) + "," + list[1].get(j) + ")");
                        // 找到了直接跳出继续下一个 Ai
                        break;
                    } else {
                        // 如果 Ai 找不到 R 范围内的 Bj，则列出距它最近的一个 Bj
                        Integer tmp = 0;
                        if ( (tmp = list[1].get(j) - list[0].get(i)) < min ) {
                            swi = true;
                            min = tmp;
                            pos = j;
                        }
                    }
                } else {
                    continue;
                }
            }

            if ( swi ) {
                System.out.print("(" + list[0].get(i) + "," + list[1].get(pos) + ")");
            }

        }
    }

    /**
     * 根据输入集的字符串，导出 A, B, R 变量集的字符串
     * 例如："A={1,3,5},B={2,4,6},R=1" --> "1,3,5},2,4,6},1" --> {"1,3,5", "2,4,6", "1"}
     * @param str 未经格式化的输入集字符串
     * @return A, B, R 变量集的字符串
     */
    public static String[] getStrVarables(String str) {

        // Step.01: 去掉基本承载变量的变量名、赋值符号以及 "{"
        String regex = "([A-Z|a-z]+[ ]*[=][ ]*[\\{]?)";
        String tmp = str.trim().replaceAll(regex, "");

        // Step.02: 剩余 "}," 作为分割符来获取 A, B, R 的变量集
        String regex_split = "[}]{1}[ ]*[\\,]{1}";

        return tmp.split(regex_split);
    }

    /**
     * 标准化变量集 (整型数组储存起来)，例如: 3,4,5 --> {3, 4, 5}
     * @param str 变量集字符串数组，例如：{"1,3,5", "2,4,6", "1"}
     * @return 变量集整型 List
     */
    public static List<Integer> getIntVarables(String str) {

        String regex = "[ ]*[\\,]+[ ]*";
        String[] tmp = str.split(regex);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < tmp.length; i++) {
            list.add( Integer.parseInt(tmp[i].trim()) );
        }

        return list;
    }

    public static void printIntArray(List<Integer> list) {
        for (int num : list) {
            System.out.printf(num + " ");
        }
    }
}
