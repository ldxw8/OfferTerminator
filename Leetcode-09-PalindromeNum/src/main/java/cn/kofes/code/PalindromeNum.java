package cn.kofes.code;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/10/09
 * desc  :
 * ==============================================
 * Leetcode-09-最长回文串
 * https://leetcode-cn.com/problems/palindrome-number/
 * ==============================================
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * ==============================================
 * </pre>
 */
public class PalindromeNum {

    public boolean isPalindrome(int x) {
        int src = x;
        int sum = 0, time = 1;
        boolean result = false;

        if ( x > 0 ) {
            if ( (0 != x%10) || (x > 10e9 &&  x%10 <= 2) ) {

                // 获取 x 是多少位数
                int i = 0;
                while ( src != 0 ) {
                    src /= 10;
                    time = (int) Math.pow(10, i++);
                }
                // 重新赋值 src
                src = x;

                while ( src != 0 ) {
                    int mod = src % 10;
                    src /= 10;
                    sum += (mod * time);
                    time /= 10;
                }

                // 完成数字高低位逆转过程，判断两数是否还相等
                result = ( sum == x );
            }
        } else if ( 0 == x ) {
            result = true;
        }

        return result;
    }

}
