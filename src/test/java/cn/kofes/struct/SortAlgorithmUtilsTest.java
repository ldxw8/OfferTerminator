package cn.kofes.struct;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortAlgorithmUtilsTest {

    @Test
    public void max() {
        Assert.assertEquals(SortAlgorithmUtils.max(0, 0), 0);
        Assert.assertEquals(SortAlgorithmUtils.max(-12, 12), 12);
        Assert.assertEquals(SortAlgorithmUtils.max(34, 12), 34);
        Assert.assertEquals(SortAlgorithmUtils.max(12, 34), 34);

    }

    @Test
    public void min() {
        Assert.assertEquals(SortAlgorithmUtils.max(0, 0), 0);
        Assert.assertEquals(SortAlgorithmUtils.min(-12, -34), -34);
        Assert.assertEquals(SortAlgorithmUtils.min(-12, 34), -12);
    }

}