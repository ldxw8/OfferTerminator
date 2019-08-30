package cn.kofes.code;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/08/30
 * desc :
 * ==============================================
 * 《剑指Offer——名企面试官精讲典型编程题》代码
 * ==============================================
 * 面试题 67：把字符串转换成整数
 * 题目：写一个函数 StrToInt()，实现把字符串转换成整数这个功能。
 * 当然，不能使用 atoi() 或者其他类似的库函数。
 * ==============================================
 * </pre>
 */
public class Str2Int {

    // 通用数值字符识别- 整型/浮点型，如：".5","1.", "1.0", "10", "-123", "-12.5", "-5." 和 "-.14"
    final static public String REGEX_DIGITAL_DECIMAL = "[+|-]?[0-9]*[.]?[0-9]*";

    private Boolean isValidDigitalStr = true;

    public int convertStr2Integer(String src) {

        int result = 0;

        if (null != src && !"".equals(src)) {

            // 匹配只含有整型数字的字符串
            String regex = REGEX_DIGITAL_DECIMAL;

            if (src.matches(regex)) {
                // 取得数字字符串中的每一个元素
                char[] src_array = src.toCharArray();

                for (int i = src_array.length - 1, j = 0; i >= 0; i--, j++) {
                    // 从个位数开始，累加计算得结果
                    if ('0' <= src_array[i] && '9' >= src_array[i]) {
                        result += (src_array[i] - '0') * Math.pow(10, j);
                    } else {
                        // 遇到符号进行转换
                        if (0 == i && '-' == src_array[0]) {
                            result *= -1;
                        }
                    }

                    // 溢出判别：缺少类型大小的判断
                    if (Integer.MIN_VALUE <= result && result >= Integer.MAX_VALUE) {
                        result = 0;
                        setValidDigitalStr(false);
                    }
                }
            } else {
                setValidDigitalStr(false);
            }

            setValidDigitalStr(false);
        }

        return result;
    }

    public void setValidDigitalStr(Boolean validDigitalStr) {
        isValidDigitalStr = validDigitalStr;
    }

    public Boolean getValidDigitalStr() {
        return isValidDigitalStr;
    }
}
