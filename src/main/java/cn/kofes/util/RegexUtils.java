package cn.kofes.util;

/*
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/08/30
 * desc :
 * Java 正则表达式参考：https://www.runoob.com/java/java-regular-expressions.html
 */
public class RegexUtils {

    /**
     * 数字匹配篇
     **/

    // 通用数值字符识别- 科学计数法，如："5e2","0.1e2", ".5e2", "-.5e10", "10E+10" 和 "-1E-16"
    final static public String REGEX_DIGITAL_SCIENTIFIC = "[+|-]?[0-9]*[.]?[0-9]*[e|E]{1}[+|-]?[0-9]+";
    // 通用数值字符识别- 整型/浮点型，如：".5","1.", "1.0", "10", "-123", "-12.5", "-5." 和 "-.14"
    final static public String REGEX_DIGITAL_DECIMAL = "[+|-]?[0-9]*[.]?[0-9]*";

}
