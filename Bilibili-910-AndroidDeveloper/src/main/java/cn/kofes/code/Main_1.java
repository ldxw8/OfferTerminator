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
public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        String str = scanner.nextLine();
        String regex= "[A-Z]+";

        if ( null != str && !"".equals(str) ) {
           if ( str.matches(regex) ) {
               System.out.printf( getMaxSquenceStr(str) );
           } else {
               System.out.printf("");
           }
        }

    }

    public static String getMaxSquenceStr(String src) {

        char[]  tmp = src.toCharArray();
        int posStart = 0, posEnd =0, max  = 1;
        int posStart_1= 0, posEnd_1 = 0, max_1 = 1;

        boolean swi = true, swi_sub = true, swi_sub_1 = true;

        for (int i = 0;i < tmp.length-1; i++) {
            if (swi) {
                // 首次比较分支
                if (0 == tmp[i + 1] - tmp[i]) {
                    if ( swi_sub ) {
                        posStart = i;
                        swi_sub = false;
                    }
                    posEnd = i + 1;
                } else {
                    swi = false;
                }
                max = posEnd - posStart + 1;
            } else {
                if (0 == tmp[i + 1] - tmp[i]) {
                    if ( swi_sub_1 ) {
                        posStart_1 = i;
                        swi_sub_1 = false;
                    }
                    posEnd_1 = i + 1;
                } else {
                    // 与目前最大的子串比较
                    max_1 = posEnd_1 - posStart_1 + 1;

                    if (max_1 > max) {
                        max = max_1;    // 检索到新的最大子串
                        posStart = posStart_1; // 新的最大子串的起始坐标
                        posEnd = posEnd_1; // 新的最大子串的结束坐标
                        // swi = true;         // 最大子串分支锁
                        // swi_sub = true; // 启始坐标锁
                    }

                    swi_sub_1 = true; // 启始坐标锁
                }
            }
        }

        // 上述条件分支中，缺少最后一个子串也是连续的情况检验
        if( (max_1 = posEnd_1 - posStart_1 + 1) > max ) {
            max = max_1;    // 检索到新的最大子串
            posStart = posStart_1; // 新的最大子串的起始坐标
            posEnd = posEnd_1; // 新的最大子串的结束坐标
        }

        StringBuilder stringBuider = new StringBuilder();

        for (int i = posStart;i<=posEnd;i++) {
            stringBuider.append(tmp[i]);
        }

        return stringBuider.toString();
    }
}
