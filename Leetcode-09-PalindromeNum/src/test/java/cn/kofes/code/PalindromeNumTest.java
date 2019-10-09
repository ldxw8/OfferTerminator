package cn.kofes.code;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumTest {

    @Test
    public void isPalindrome() {
        Assert.assertEquals( new PalindromeNum().isPalindrome(121), true );
        Assert.assertEquals( new PalindromeNum().isPalindrome(-121), false );
        Assert.assertEquals( new PalindromeNum().isPalindrome(0), true );
        Assert.assertEquals( new PalindromeNum().isPalindrome(123), false );
    }
}