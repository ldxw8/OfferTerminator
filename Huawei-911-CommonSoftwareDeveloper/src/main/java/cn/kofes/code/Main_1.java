package cn.kofes.code;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );

        // A={1,3,5}, B={2,4,6},R=1
        // A={1 , 3 ,5} , B ={ 2,4, 6},R=1
        String src =  scanner.nextLine();
        String[]  inputStr = null;
        int[][] inputNum  = new int[3][];

        if ( null != src && !"".equals(src) ) {
            inputStr = getStr2StandardInputStr(src);

            // todo
            // 将抽取出数字存入标注化输入集
            // printIntArray(getSingleDigitalElement(input));
            for (int i = 0; i < inputStr.length; i++) {
                inputNum[i] = new int[50];
                inputNum[i] = getSingleDigitalElement(inputStr[i]);
            }

        } else {
            System.out.println("");
        }

    }

    /**
     * 根据输入集的字符串，导出所 "需要" 的字符串格式
     * 例如："A={1,3,5},B={2,4,6},R=1" --> "1,3,5},2,4,6},1" --> {"1,3,5", "2,4,6", "1"}
     * @param str
     * @return
     */
    public static String[] getStr2StandardInputStr(String str) {


        // 去掉基本承载变量的变量名、赋值符号以及 "{"
        String regex = "([A-Z|a-z]+[ ]*[=][ ]*[\\{]?)";
        String tmp = str.replaceAll(regex, "");

        String regex_split = "[}]{1}[ ]*[\\,]{1}";

        return tmp.split(regex_split);
    }

    /**
     * 标准化输入集 (整型数组储存起来)，例如: 3,4,5 --> {3, 4, 5}
     * @param str
     * @return
     */
    public static int[] getSingleDigitalElement(String str) {

        String regex = "[ ]*[\\,]+[ ]*";

        String[] tmp = str.split(regex);

        int[] nums = new int[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            nums[i] = Integer.parseInt( tmp[i].trim() );
        }

        return nums;
    }

    public static void printIntArray(int[] arrays) {
        for (int num : arrays) {
            System.out.printf(num + " ");
        }
    }
}
