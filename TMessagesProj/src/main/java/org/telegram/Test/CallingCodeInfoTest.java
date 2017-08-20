package org.telegram.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.telegram.PhoneFormat.CallingCodeInfo;

import static org.junit.Assert.*;

/**
 * Created by ns on 20/08/2017.
 */
public class CallingCodeInfoTest {

    CallingCodeInfo cci = new CallingCodeInfo();
    String code1;
    String code2;
    String code3;

    @Before
    public void setUp() throws Exception {
//        code1 = "+12025550121";
//        code2 = "12025550121";
//        code3 = "120 255 50 121";
        code1 = "0612345678";
//        code2 = "+31612345678";
//        code3 = "003112345678";
        code2 = "+31 12345678";
        code3 = "yyyyy";
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void format() throws Exception {
        String result1 = cci.format(code1);
        String result2 = cci.format(code2);
        String result3 = cci.format(code3);
        System.out.println(result1 + "\n" + result2 + "\n" + result3);
    }

    /**
     * Status: OK. Does not validate anything for some reason.
     * @throws Exception
     */
    @Test
    public void isValidPhoneNumber() throws Exception {
        Boolean result1 = cci.isValidPhoneNumber(code1);
        Boolean result2 = cci.isValidPhoneNumber(code2);
        Boolean result3 = cci.isValidPhoneNumber(code3);
        System.out.println(result1 + " " + result2 + " " + result3);
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }

}