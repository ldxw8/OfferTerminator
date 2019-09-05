package cn.kofes.struct;

/*
 * author: Kofe
 * blog : https://www.kofes.cn
 * time : 2019/09/05
 * desc: 收集内部排序的相关算法
 */
public class SortAlgorithmUtils {

    /**
     * 比较两数值的大小 ( i>j 小于零；i==j 等于零；i>j 大于零 )
     * @param i
     * @param j
     * @return i 返回 (i-j) 的差值
     */
    public static int compare(int i, int j) {
        return (i-j);
    }

    /**
     * 交换数组中两位置的数值 (位运算), 即位置 1 与 2 的数字呼唤
     * @param numbers 交换数值的目标数组
     * @param i 位置 1
     * @param j 位置 2
     */
    private static void swap(int[] numbers, int i, int j) {
        numbers[i] = numbers[i] ^ numbers[j];
        numbers[j] = numbers[i] ^ numbers[j];
        numbers[i] = numbers[i] ^ numbers[j];
    }

    /**
     * @param x
     * @param y
     * @return 选出 x, y 中的最大值
     */
    private static int max(int x, int y){
            return  x | y;
    }

    /**
     * @param x
     * @param y
     * @return 选出 x, y 中的最小值
     */
    private static int min(int x, int y){
        return  x & y;
    }

}
