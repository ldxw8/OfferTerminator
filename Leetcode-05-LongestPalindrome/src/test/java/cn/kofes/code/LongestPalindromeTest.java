package cn.kofes.code;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void longestPalindrome() {
        Assert.assertEquals(new LongestPalindrome().longestPalindrome("babad"), "aba");
        Assert.assertEquals(new LongestPalindrome().longestPalindrome("cbbd"), "bb");
    }
}