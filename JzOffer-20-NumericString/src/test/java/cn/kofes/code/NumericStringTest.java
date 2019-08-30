package cn.kofes.code;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumericStringTest {

    @Test
    public void isNumeric() {
        Assert.assertEquals( NumericString.isNumeric(null), false);
        Assert.assertEquals( NumericString.isNumeric("".toCharArray()), false);
        Assert.assertEquals( NumericString.isNumeric("-123.12".toCharArray()), true);
        Assert.assertEquals( NumericString.isNumeric("-1E-16".toCharArray()), true);
        Assert.assertEquals( NumericString.isNumeric("12e".toCharArray()), false);
    }
}