package cn.kofes.code;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/08/31
 * desc  :
 * ==============================================
 * 《剑指Offer——名企面试官精讲典型编程题》代码
 * ==============================================
 * 面试题 3：找出数组中重复的数字
 * 题目：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字 2 或者 3。
 * ==============================================
 * </pre>
 */
public class DuplicationInArray {
    /**
     * 请找出数组中任意一个重复的数字 (下标筛数法)
     * 下标筛数学法决定了数组中数字的取值范围是 [0, n-1]
     * @param numbers 整型数组
     * @param length 数组的长度
     * @param duplication 返回任意重复的一个数字，赋值给 duplication[0]
     * @return True 输入有效且数组中存在重复的数字；False 其他情况
     */
    public static boolean duplicate(int numbers[],int length,int [] duplication) {

        boolean isDuplicate  = false;
        boolean isAllPositive  = true;

        if (  null != numbers && null != duplication ) {
            if ( length == numbers.length ) {
                // 下标筛数学法决定了数组中数字的取值范围是 [0, n-1]
                for (int number : numbers) {
                   if (number < 0 || number >= numbers.length) {
                       isAllPositive = false;
                       break;
                   }
                }

                if ( isAllPositive ) {
                    for (int i = 0; i < numbers.length; i++) {
                        while ( numbers[i] != i ) {
                            if ( numbers[i] == numbers[numbers[i]] ) {
                                duplication[0] = numbers[i];
                                isDuplicate = true;
                                break; // 跳出最临近的循环体 -- while
                            }

                            // 位运算：swap(numbers[i], numbers[numbers[i]]);
                            int tmp = numbers[i];
                            numbers[i] = numbers[i] ^ numbers[tmp];
                            numbers[tmp] = numbers[i] ^ numbers[tmp];
                            numbers[i] = numbers[i] ^ numbers[tmp];

                            // 中间变量交换两值
                            // int tmp = numbers[numbers[i]];
                            // numbers[numbers[i]] = numbers[i];
                            // numbers[i] = tmp;
                        }

                        if ( isDuplicate ) break; // 跳出最临近的循环体 -- for
                    }
                }

            }
        }

        return isDuplicate;
    }

    /**
     * 请找出数组中任意一个重复的数字 (哈希表筛数法)
     * 数组中数字的取值范围是 [0, Integer.MAX_VALUE]
     * @param numbers 整型数组
     * @param length 数组的长度
     * @param duplication 返回任意重复的一个数字，赋值给 duplication[0]
     * @return True 输入有效且数组中存在重复的数字；False 其他情况
     */
    public static boolean duplicateWithHash(int numbers[],int length,int [] duplication) {

        boolean isDuplicate  = false;
        boolean isAllPositive  = true;
        // 构建一个哈希表，利用冲突的特点，结合重复元素判定的方式，快速找出
        int[] hashTable = new int[length];

        if ( isAllPositive ) {
            if (  null != numbers && null != duplication ) {
                if ( length == numbers.length ) {

                    // 检索输入的数组中是非都为正整数
                    for (int i = 0, d = 1; i < numbers.length; i++) {

                        hashTable[i] = -1; // 初始化 HashTable

                        if ( numbers[i] < 0 ) {
                            isAllPositive = false;
                            break;
                        }
                    }

                    for (int i = 0, d = 1, f = 1; i < numbers.length; i++) {

                        // 哈希函数
                        int hKey = numbers[i] % length;
                        int rhKey = 0;

                        // 解决冲突 -- 双哈希函数探测法
                        while ( -1 != hashTable[hKey] ) {

                            // 发生了冲突，检验冲突位置是否是相同元素
                            if ( hashTable[hKey] == numbers[i] ) {
                                duplication[0] = numbers[i];
                                isDuplicate = true;
                                break;
                            }

                            rhKey = d^2;
                            rhKey *= f;

                            // 信号量改变
                            if( d <=  length/2 ) {
                                d += 1;
                            }
                            f *= -1;

                            hKey = (hKey + rhKey*d) % length;

                        }

                        hashTable[hKey] = numbers[i];

                        if ( isDuplicate ) break; // 跳出最临近的循环体 -- for
                    }
                }
            }
        }

        return isDuplicate;
    }

}
