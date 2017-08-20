package org.telegram.messenger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by ns on 20/08/2017.
 */
public class UtilitiesTest {
    @Mock
    SecureRandom random;
    @Mock
    DispatchQueue stageQueue;
    @Mock
    DispatchQueue globalQueue;
    @Mock
    DispatchQueue searchQueue;
    @Mock
    DispatchQueue phoneBookQueue;
    @InjectMocks
    Utilities utilities;

    private String plain1 = "spaghetti code";
    private String number = "42";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    /**
//     * Status: correctly throws exception.
//     * @throws UnsatisfiedLinkError
//     */
//    @Test
//    public void testUnpinBitmap() throws UnsatisfiedLinkError {
//        Utilities.unpinBitmap(null);
//        fail("Exception not thrown.");
//    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testParseInt() throws Exception {
        Integer result = Utilities.parseInt(number);
        Assert.assertEquals((Integer) 42, result);
        Assert.assertEquals(Integer.parseInt("42"), (int) result);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testParseLong() throws Exception {
        Long result = Utilities.parseLong(number);
        Assert.assertEquals(Long.valueOf(42), result);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testParseIntToString() throws Exception {
        String result = Utilities.parseIntToString("I need 1 spaghetti, please.");
        Assert.assertEquals("1", result);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testBytesToHex() throws Exception {
        String result = Utilities.bytesToHex(plain1.getBytes());
        Assert.assertEquals("73706167686574746920636F6465", result);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testHexToBytes() throws Exception {
        byte[] result = Utilities.hexToBytes("73706167686574746920636F6465");
        byte[] input = plain1.getBytes();
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(input));
        Assert.assertArrayEquals(input, result);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testIsGoodPrime() throws Exception {
        boolean result = Utilities.isGoodPrime("0".getBytes(), 0);
        Assert.assertFalse(result);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testIsGoodGaAndGb() throws Exception {
        BigInteger b1 = new BigInteger("13");
        BigInteger b2 = new BigInteger("13").nextProbablePrime();
        boolean result = Utilities.isGoodGaAndGb(b1, b2);
        Assert.assertTrue(result);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testArraysEquals() throws Exception {
        byte[] input = { 0, 1, 0, 1 };
        byte[] input2 = { 0, 1, 0, 1 };
        byte[] input3 = { 1, 0 };
        byte[] input4 = { 0, 1, 0 };
        boolean result = Utilities.arraysEquals(input, 0, input2, 0);
        boolean result2 = Utilities.arraysEquals(input, 0, input3, 0);
        boolean result3 = Utilities.arraysEquals(input3, 0, input4, 1);
        Assert.assertTrue(result);
        Assert.assertFalse(result2);
        Assert.assertEquals(true, result3);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testMD5() throws Exception {
        String result = Utilities.MD5(plain1);
        Assert.assertEquals("34d4966f222f1a7576d1ecb7faf370b4", result);
        Assert.assertFalse(plain1.equals(result));
    }
}
