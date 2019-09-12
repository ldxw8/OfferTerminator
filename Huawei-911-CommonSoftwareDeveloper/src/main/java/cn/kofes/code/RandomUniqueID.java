package cn.kofes.code;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/09/12
 * desc  :
 * ==============================================
 * 华为研发工程师编程题
 * ==============================================
 * 题目地址：
 * https://www.nowcoder.com/questionTerminal/3245215fffb84b7b81285493eae92ff0
 *
 * 题目描述：
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
 * 他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作
 * 同一个测试用例里可能会有多组数据，希望大家能正确处理。
 *
 * Input:
 * n 输入随机数的个数
 * inputArray n 个随机整数组成的数组
 * Output:
 * OutputArray 输出处理后的随机整数
 * ==============================================
 * </pre>
 */
public class RandomUniqueID {
    // static 关键字声明是为了便于单元测试
    public static void main(String[] args) {
        Scanner scanner  = new Scanner( System.in );

            while ( scanner.hasNext() ) {

                int count = scanner.nextInt();

                /* 手动模式: 哈希表挑选不重复数字
                // 若 hashSize 不为素数，则自动扩容为素数单位的哈希表
                int hashSize = ( isPrimeNumber(count) )?count:getProximalPrimeNumber(count);
                // 初始化哈希表
                int[]  numbers = new int[hashSize];
                for (int i = 0; i < hashSize; i++) {
                    numbers[i] = -1;
                }
                for (int i = 0; i < count; i++) {
                    int number = scanner.nextInt();
                    saveUniqueID(numbers, number);
                }
                printAllID(numbers);
                */

                /* Set 有序不重复，且 TreeSet 为一颗红黑树 */
                TreeSet treeSet = new TreeSet();
                for (int i = 0; i < count; i++) {
                    treeSet.add(scanner.nextInt());
                }
                for (Iterator iterator = treeSet.iterator(); iterator.hasNext();) {
                    System.out.println(iterator.next());
                }


            }
    }

    public static void saveUniqueID(int[] hashtable, int number) {

        // 处理冲突的相关探测变量
        int d = 0, flag = -1;
        int dSum = 0, hcKey = 0;

        boolean isDuplicate = false;

        // 处理冲突 ( 二次探测再散列 )
        while (-1 != hashtable[hcKey = getHashKeyWithMod(number + dSum, hashtable.length)]
                && d <= hashtable.length / 2) {

            // 发生了冲突，检验冲突位置是否是相同元素
            if (hashtable[hcKey] == number) {
                isDuplicate = true;
                break; // 跳出最临近的循环体 -- while
            }

            if (flag < 0) d += 1;
            dSum = flag * d;
            flag = -flag;
        }

        if (!isDuplicate && number >= 1 && number <= 1000) {
            hashtable[hcKey % hashtable.length] = number;
            isDuplicate = false;
        }

        // 下一个元素进哈希表需要重置探测变量
        d = 0;
        flag = -1;
        dSum = 0;
        hcKey = 0;
    }

    /**
     * 判断目标数字是否为素数 (除了能被 1 和 自身整除的数)
     * @param num
     * @return 若数字为素数返回 True，否者为 False
     */
    public static boolean isPrimeNumber(int num) {
        boolean isPrimeNum = true;
        int condition = 0;

        if( num > 0 ) {
            condition= (int) Math.sqrt(num);

            for ( int i = 2; i <= condition; i++) {
                if ( 0 == num % i && i <= condition ) {
                    isPrimeNum = false;
                    break;
                }
            }
        } else {
            isPrimeNum = false;
        }

        return isPrimeNum;
    }

    /**
     * 计算得距离目标数字最近的素数或者是它本身
     * @param num 目标数字
     * @return 返回它本身或者比它大且最近的素数，小于 0 则返回状态位 -1
     */
    public static int getProximalPrimeNumber(int num) {

        int result = -1;

        if ( num > 0 ) {
            if ( isPrimeNumber(num) ) {
                result = num;
            } else {
                // 计算距离目标数字最近的素数
                result = num;
                while ( !isPrimeNumber(result) && result > 0 ) {
                    result += 1;
                }
            }
        }

        return result;
    }

    /**
     * 哈希函数 -- 除留余数法
     * @param number key ( + d)
     * @param hashSize 哈希表的大小
     * @return 返回哈希地址
     */
    public static int getHashKeyWithMod(int number, int hashSize) {
        return ( (number < 0) ? (number += hashSize) : number ) % hashSize;
    }

    public static void printAllID(int[] arrays) {

        int count = 0, count_deputy = 0;
        int pos = 0;

        for (int i = 0; i < arrays.length; i++) {
            if ( -1 != arrays[i] ) count += 1;
        }

        while ( count_deputy < count ) {
            for (int i = 0, min = 1000; i < arrays.length; i++) {
                if ( -1 != arrays[i] && arrays[i] < min ) {
                    min = arrays[i];
                    pos  = i;
                }
            }

            System.out.println(arrays[pos]);
            arrays[pos] = -1;
            count_deputy += 1;
        }
    }
}
