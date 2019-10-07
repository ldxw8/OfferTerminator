package cn.kofes.struct;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashSearchTest {

    @Test
    public void isPrimeNumber() {
        HashSearch hashSearch = new HashSearch();
        Assert.assertEquals(hashSearch.isPrimeNumber(0), false);
        Assert.assertEquals(hashSearch.isPrimeNumber(1), true);
        Assert.assertEquals(hashSearch.isPrimeNumber(2), true);
        Assert.assertEquals(hashSearch.isPrimeNumber(3), true);
        Assert.assertEquals(hashSearch.isPrimeNumber(6), false);
        Assert.assertEquals(hashSearch.isPrimeNumber(13), true);
        Assert.assertEquals(hashSearch.isPrimeNumber(25), false);
        Assert.assertEquals(hashSearch.isPrimeNumber(343), false);
    }

    @Test
    public void getProximalPrimeNumber() {
        HashSearch hashSearch = new HashSearch();
        Assert.assertEquals(hashSearch.getProximalPrimeNumber(0), -1);
        Assert.assertEquals(hashSearch.getProximalPrimeNumber(2), 2);
        Assert.assertEquals(hashSearch.getProximalPrimeNumber(3), 3);
        Assert.assertEquals(hashSearch.getProximalPrimeNumber(3), 3);
        Assert.assertEquals(hashSearch.getProximalPrimeNumber(99), 101);
    }

    @Test
    public void HashSearch() {
        int[] arrays = new int[]{1, 2, 3, 2, 4, 5, 2, 2, 9, 0, 5, 8, 2, 19, 0, 3, 4, 2, 0, 1, 1, 4, 3};
        HashSearch  hashSearch = new HashSearch(arrays,  arrays.length, 1);
        hashSearch.printHashTable();
    }
}