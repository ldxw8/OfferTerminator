package cn.kofes.struct;

/*
 * author: Kofe
 * blog : https://www.kofes.cn
 * time : 2019/09/05
 * desc: 收集排序算法需要用到的通用函数
 * reference:
 * https://my.oschina.net/zuochaoli/blog/95466 (20 个位运算技巧)
 */
public class SortAlgorithmUtils {

    /**
     * 比较两整数的大小
     * @param i
     * @param j
     * @return i 返回 (i-j) 的差值 ( i>j 小于零；i==j 等于零；i>j 大于零 )
     */
    public static int compare(int i, int j) {
        return (i-j);
    }

    /**
     * 交换整型数组中两位置的数值 (位运算), 即位置 1 与 2 的数字呼唤
     * @param numbers 交换数值的目标数组
     * @param i 位置 1
     * @param j 位置 2
     */
    public static void swap(int[] numbers, int i, int j) {
        numbers[i] = numbers[i] ^ numbers[j];
        numbers[j] = numbers[i] ^ numbers[j];
        numbers[i] = numbers[i] ^ numbers[j];
    }

    /**
     * @param x
     * @param y
     * @return 选出整数 x, y 中的最大值
     */
    public static int max(int x, int y) {
        /* 如果 a >= b, (a-b) >> 31 为 0，否则为 -1 */
        return y & ((x - y) >> 31) | x & (~(x - y) >> 31);
    }

    /**
     * @param x
     * @param y
     * @return 选出整数 x, y 中的最小值
     */
    public static int min(int x, int y) {
        /* 如果 a >= b, (a-b) >> 31 为 0，否则为 -1 */
        return x & ((x - y) >> 31) | y & (~(x - y) >> 31);
    }

    /**
     * @param x
     * @param y
     * @return 求两个整数的平均值
     */
    public static int average(int x, int y) {
        return (x + y) >> 1;
    }

}
