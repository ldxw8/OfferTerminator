package cn.kofes.code;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicationInArrayTest {

    @Test
    public void duplicate() {

        // 传入数组的引用，使得运算数据返回主函数中
        int[]  result = {-1};

        Assert.assertEquals( DuplicationInArray.duplicate(null, 10, result), false);
        Assert.assertEquals( result[0], -1);

        Assert.assertEquals( DuplicationInArray.duplicate(null, 10, null), false);
        Assert.assertEquals( result[0], -1);

        int[]  arrays0 = {1, 2, 3, 5, 6, 4, 2, 3};
        Assert.assertEquals( DuplicationInArray.duplicate(arrays0, 5, result), false);
        Assert.assertEquals( result[0], -1);

        int[]  arrays1 = {1, 2, -1, 5, 10, 4, 2, 3};
        Assert.assertEquals( DuplicationInArray.duplicate(arrays1, arrays1.length, result), false);
        Assert.assertEquals( result[0], -1);

//        int[]  arrays2 = {1, 2, 3, 3, 2};
//        Assert.assertEquals( DuplicationInArray.duplicate(arrays2, arrays2.length, result), true);
//        Assert.assertEquals( result[0], 2);

        int[]  arrays3 = {2, 4, 2, 1, 4, 1};
        Assert.assertEquals( DuplicationInArray.duplicate(arrays3, arrays3.length, result), true);
        Assert.assertEquals( result[0], 2);
    }

    @Test
    public void duplicateWithHash() {

        // 传入数组的引用，使得运算数据返回主函数中
        int[]  result = {-1};

        Assert.assertEquals( DuplicationInArray.duplicateWithHash(null, 10, result), false);
        Assert.assertEquals( result[0], -1);

        Assert.assertEquals( DuplicationInArray.duplicateWithHash(null, 10, null), false);
        Assert.assertEquals( result[0], -1);

        int[]  arrays1 = {1, 2, -1, 5, 10, 4, 2, 3};
        Assert.assertEquals( DuplicationInArray.duplicateWithHash(arrays1, arrays1.length, result), false);
        Assert.assertEquals( result[0], -1);

        int[]  arrays2 = {2,4,8,1,4,3, 6, 2, 4};
        Assert.assertEquals( DuplicationInArray.duplicateWithHash(arrays2, arrays2.length, result), true);

        int[]  arrays3 = {2,4,8,1,56, 3, 6, 7, 90, 21, 7, 33, 35, 26, 210, 10, 102, 64, 37, 0, 2};
        Assert.assertEquals( DuplicationInArray.duplicateWithHash(arrays3, arrays3.length, result), true);

    }
}