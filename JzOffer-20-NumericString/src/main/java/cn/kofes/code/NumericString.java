package cn.kofes.code;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/08/30
 * desc  :
 * ==============================================
 * 《剑指Offer——名企面试官精讲典型编程题》代码
 * ==============================================
 * 面试题 20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值 (包括整数和小数)。
 * 例如 “+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值。
 * 但 “12e”、“1e3.14”、“1.2.3”、“+-5” 及 “12e+5.4” 都不是。
 * ==============================================
 * </pre>
 */
public class NumericString {

    // 通用数值字符识别- 科学计数法，如："5e2","0.1e2", ".5e2", "-.5e10", "10E+10" 和 "-1E-16"
    final static public String REGEX_DIGITAL_SCIENTIFIC = "[+|-]?[0-9]*[.]?[0-9]*[e|E]{1}[+|-]?[0-9]+";
    // 通用数值字符识别- 整型/浮点型，如：".5","1.", "1.0", "10", "-123", "-12.5", "-5." 和 "-.14"
    final static public String REGEX_DIGITAL_DECIMAL = "[+|-]?[0-9]*[.]?[0-9]*";

    public static boolean isNumeric(char[] str) {

        boolean isNumeric = false;
        String strs = null;

       if ( null != str ) {
           strs = String.copyValueOf(str);

           if ( !"".equals(strs) ) {
               String regex_scientific = REGEX_DIGITAL_SCIENTIFIC;
               String regex_decimal = REGEX_DIGITAL_DECIMAL;

               if (strs.matches(regex_decimal) || strs.matches(regex_scientific)) {
                   isNumeric = true;
               }
           }
       }

        return isNumeric;
    }

}
