package org.telegram.messenger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.telegram.PhoneFormat.CallingCodeInfo;

/**
 * Created by ns on 20/08/2017.
 */
public class CallingCodeInfoTest {

    CallingCodeInfo cci = new CallingCodeInfo();
    private String code1;
    private String code2;
    private String code3;
    private String code4;
    private String code5;
    private String code6;
    private String code7;
    private String code8;

    @Before
    public void setUp() throws Exception {
        code1 = "+12025550121";
        code2 = "12025550121";
        code3 = " 120 255 50 121";
        code4 = "0612345678";
        code5 = "+31612345678";
        code6 = "003112345678";
        code7 = "+31 12345678";
        code8 = "yyyyy";
    }

    /**
     *  Status: OK. Simply prefixes everything with an extra space.
     * @throws Exception
     */
    @Test
    public void format() throws Exception {
        String result1 = cci.format(code1);
        String result2 = cci.format(code2);
        String result3 = cci.format(code3);
        String result4 = cci.format(code4);
        String result5 = cci.format(code5);
        String result6 = cci.format(code6);
        String result7 = cci.format(code7);
        String result8 = cci.format(code8);
        System.out.println("[" + code1 + "] vs. [" + result1 + "]\n["
                + code2 + "] vs. [" + result2 + "]\n["
                + code3 + "] vs. [" + result3 + "]\n["
                + code4 + "] vs. [" + result4 + "]\n["
                + code5 + "] vs. [" + result5 + "]\n["
                + code6 + "] vs. [" + result6 + "]\n["
                + code7 + "] vs. [" + result7 + "]\n["
                + code8 + "] vs. [" + result8 + "]");
    }

//    /**
//     * Status: OK. Does not validate anything for some reason.
//     * @throws Exception
//     */
//    @Test
//    public void isValidPhoneNumber() throws Exception {
//        Boolean result1 = cci.isValidPhoneNumber(code1);
//        Boolean result2 = cci.isValidPhoneNumber(code2);
//        Boolean result3 = cci.isValidPhoneNumber(code3);
//        Boolean result4 = cci.isValidPhoneNumber(code4);
//        Boolean result5 = cci.isValidPhoneNumber(code5);
//        Boolean result6 = cci.isValidPhoneNumber(code6);
//        Boolean result7 = cci.isValidPhoneNumber(code7);
//        Boolean result8 = cci.isValidPhoneNumber(code8);
//        System.out.println(result1 + " " + result2 + " " + result3 + " "
//                + result4 + " " + result5 + " " + result6 + " " + result7 + " " + result8);
//        Assert.assertTrue(result1);
//        Assert.assertTrue(result2);
//        Assert.assertTrue(result3);
//        Assert.assertTrue(result4);
//        Assert.assertTrue(result5);
//        Assert.assertTrue(result6);
//        Assert.assertTrue(result7);
//        Assert.assertTrue(result8);
//    }

}