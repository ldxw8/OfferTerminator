package cn.kofes.struct;

/*
 * author: Kofe
 * blog : https://www.kofes.cn
 * time : 2019/09/05
 * desc: 收集内部排序的相关算法
 */
public class SortAlgorithmUtils {

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

}
