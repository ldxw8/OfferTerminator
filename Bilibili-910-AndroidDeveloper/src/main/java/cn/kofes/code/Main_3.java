package cn.kofes.code;

import java.util.Scanner;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/09/10
 * desc  :
 * ==============================================
 * Bilibili 2020 届秋季校园招聘 -- Android 方向笔试卷（二）-- 编程 3
 * ==============================================
 * 题目描述：
 * 有 N 件物品和一个容量为 V 的背包。第 i 件物品的价值是 C[i]，重量是 W[i]。
 * 求解将哪些物品装入背包可使价值总和最大。
 * 输入描述：
 * 输入第一行数目 N V ( 1<= N <= 500 && 1 <= V <= 10000 )
 * 输入 N 行，输入两个数字 C W 代表价值和重量 ( 1<= V <= 50000 && 1 <= V <= 10000 )
 * 输出描述：输出最大价值
 * Input:
 * 5 10
 * 8 6
 * 10 4
 * 4 2
 * 5 4
 * 5 3
 * Output:
 * 19
 * ==============================================
 * </pre>
 */
public class Main_3 {
    // static 关键字声明是为了便于单元测试
    public static void main(String[] args) {
            Scanner scanner = new Scanner( System.in );
            int digital  =  scanner.nextInt();
            int capacity  = scanner.nextInt();

            if ( capacity >=1 && capacity <= 500 && digital >=1 && digital <= 10000 ) {
                int[]  w = new int[digital + 1];
                int[]  v = new int[digital + 1];

                // Input some elems.
                for (int i = 1; i< digital+1;i++) {
                    w[i] = scanner.nextInt();
                    v[i] = scanner.nextInt();

                    if ( (w[i] <1 && w[i] > 50000) || (v[i] <1 && v[i] > 10000) ) {
                        System.out.println(0);
                        return;
                    }
                }

                int[][] dp = new int[digital + 1][capacity + 1];

                for (int i = 1; i < digital + 1; i++) {
                    for (int j = 1; j <= capacity; j++) {
                        if (w[i] > j) {
                            dp[i][j] = dp[i-1][j];
                        } else {
                            dp[i][j] = Math.max( dp[i-1][j],dp[i-1][j-w[i]] + v[i] );
                        }
                    }
                }
                System.out.println(dp[digital][capacity]);
            } else {
                System.out.println(0);
            }
    }
}
