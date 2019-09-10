package cn.kofes.struct;

/*
 * author: Kofe
 * blog : https://www.kofes.cn
 * time : 2019/09/06
 * desc: 哈希表查找 ( 储存结构以及相关算法 )
 */
public class HashSearch {

    final static int EMPTY_POS = -1;

    private  int[] hashTable = null;

    public  HashSearch() {
        // None
    }

    /**
     * 顺序结构的哈希表 ( 用于存储的哈希表 )
     * @param numbers 需要存放的数字集合
     * @param hashSize 哈希表的大小
     * @param conflict 冲突解决：1 二次线性再散列；2 线性再散列
     */
    public  HashSearch(int[] numbers,  int hashSize, int conflict) {

        // 若 hashSize 不为素数，则自动扩容为素数单位的哈希表
        hashSize = ( isPrimeNumber(hashSize) )?hashSize:getProximalPrimeNumber(hashSize);

        // 初始化 HashTable
        hashTable = new int[hashSize];
        for (int i = 0; i < hashSize; i++) {
            hashTable[i] = EMPTY_POS;
        }

        // 处理冲突的相关探测变量
        int d = 0, flag = -1;
        int dSum = 0, hcKey = 0;

        for (int number : numbers) {

            // 处理冲突 ( 二次探测再散列 )
            while (EMPTY_POS != hashTable[ hcKey = getHashKeyWithMod(number + dSum, hashSize) ] && d <= hashSize / 2) {
                if (flag < 0) d += 1;
                dSum = flag * d;
                flag = -flag;
            }

            hashTable[ hcKey % hashSize ] = number;

            // 下一个元素进哈希表需要重置探测变量
            d = 0; flag = -1; dSum = 0; hcKey = 0;
        }
    }

    /**
     * 从顺序结构的哈希表中查找目标数字
     * @param num 需要寻找的目标数字
     * @return 若找到则返回下标 i，其他情况返回 -1
     */
    public int searchInHash(int num) {
        int result =  -1;

        // TODO 把查询的补充完毕

        return result;
    }

    /**
     * 判断目标数字是否为素数 (除了能被 1 和 自身整除的数)
     * @param num
     * @return 若数字为素数返回 True，否者为 False
     */
    public boolean isPrimeNumber(int num) {
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
    public int getProximalPrimeNumber(int num) {

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
    public int getHashKeyWithMod(int number, int hashSize) {
        return ( (number < 0) ? (number += hashSize) : number ) % hashSize;
    }

    /* 打印哈希表 */
    public void printHashTable() {
        for (int i = 0; i< hashTable.length;i++) {
            System.out.println( i + "\t" + hashTable[i]);
        }
    }

}
