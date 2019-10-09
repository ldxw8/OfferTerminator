package cn.kofes.code;

import java.util.*;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/10/09
 * desc  :
 * ==============================================
 * Leetcode-03-无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * ==============================================
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * ==============================================
 * </pre>
 */
public class LongestSubStrLength {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> hashSet = new HashSet();
        int max = 0, j = 0, posStart = 0;

        if ( null != s  && !"".equals(s)  ) {
            while ( j < s.length() ){
                if (!hashSet.contains(s.charAt(j))) {
                    hashSet.add(s.charAt(j++)); // 添加后推进 1
                    max = Math.max(max, hashSet.size());
                } else {
                    // 顺序移除直至目标字符
                    hashSet.remove(s.charAt(posStart++));
                }
            }
        }

        return max;
    }

}
