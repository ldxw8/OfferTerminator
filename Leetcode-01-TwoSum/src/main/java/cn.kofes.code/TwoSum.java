package cn.kofes.code;

import java.util.HashMap;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/10/09
 * desc  :
 * ==============================================
 * Leetcode-01-两数之和 (https://leetcode-cn.com/problems/two-sum/)
 * ==============================================
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * ==============================================
 * </pre>
 */
public class TwoSum {

    public int[] twoSum(int[] numts, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] sums = new int[]{0,0};

        int result = 0;

        if ( null != numts ) {
            for (int i = 0; i < numts.length; i++) {

                result = target - numts[i];

                // 利用 Map 键冲突的思想解题
                if ( hashMap.containsKey(numts[i]) || ( hashMap.containsKey(numts[i]) && hashMap.containsKey(result))  ) {

                    sums[0] = hashMap.get(numts[i]).intValue();
                    sums[1] = i;

                } else {
                    hashMap.put(result, i);
                }
            }
        }

        return sums;
    }

}
