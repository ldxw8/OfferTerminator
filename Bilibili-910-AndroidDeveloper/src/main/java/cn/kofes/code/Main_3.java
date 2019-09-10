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
public class Main_3 {

    public static void main(String[] args) {
            Scanner scanner = new Scanner( System.in );
            int capacity  = scanner.nextInt();
            int digital  =  scanner.nextInt();

            if ( capacity >=1 && capacity <= 500 && digital >=1 && digital <= 10000 ) {
                int[]  w = new int[digital + 1];
                int[]  v = new int[digital + 1];

                // Input some elems.
                for (int i = 1; i< digital+1;i++) {
                    w[i] = scanner.nextInt();
                    v[i] = scanner.nextInt();

                    if ( (w[i] >=1 && w[i] <= 50000) || (v[i] >= 1 && v[i] <= 10000) ) {
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
                            dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]] + v[i] );
                        }
                    }
                }
                System.out.println(dp[digital][capacity]);
            } else {

            }
    }
}
