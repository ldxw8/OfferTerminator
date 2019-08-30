package cn.kofes.code;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Str2IntTest {

    @Test
    public void convertStr2Integer() {
        Str2Int str2Int = new Str2Int();
        Assert.assertEquals(str2Int.convertStr2Integer(null), 0);
        Assert.assertEquals(str2Int.convertStr2Integer(""), 0);
        Assert.assertEquals(str2Int.convertStr2Integer("+1234567"), 1234567);
        Assert.assertEquals(str2Int.convertStr2Integer("-1234567"), -1234567);
        Assert.assertEquals(str2Int.convertStr2Integer("1234567"), 1234567);
        Assert.assertEquals(str2Int.convertStr2Integer("1234567890"), 1234567890);
        Assert.assertEquals(str2Int.convertStr2Integer("+1234567890"), 1234567890);
        Assert.assertEquals(str2Int.convertStr2Integer("-1234567890"), -1234567890);
    }
}