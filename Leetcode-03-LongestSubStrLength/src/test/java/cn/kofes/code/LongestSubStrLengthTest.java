package cn.kofes.code;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubStrLengthTest {

    @Test
    public void lengthOfLongestSubstring() {

        Assert.assertEquals(new LongestSubStrLength().lengthOfLongestSubstring("dvdf"), 3);
        Assert.assertEquals(new LongestSubStrLength().lengthOfLongestSubstring("pwwkew"), 3);
        Assert.assertEquals(new LongestSubStrLength().lengthOfLongestSubstring("abcabcbb"), 3);
        Assert.assertEquals(new LongestSubStrLength().lengthOfLongestSubstring("abba"), 2);

    }
}