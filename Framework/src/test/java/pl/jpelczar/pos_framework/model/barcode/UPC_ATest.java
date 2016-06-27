package pl.jpelczar.pos_framework.model.barcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jpelczar on 25.06.16.
 */
public class UPC_ATest {

    private UPC_A barcode;
    private int leftNumericalDigit = 907836;
    private int rightNumericalDigit = 376206;
    private String pattern;

    @Before
    public void setUp() throws Exception {
        barcode = new UPC_A(leftNumericalDigit, rightNumericalDigit);
        pattern = String.valueOf(leftNumericalDigit) + rightNumericalDigit;

    }

    @Test(expected = Exception.class)
    public void exceptionTest() throws Exception {
        new UPC_A(12, 45);
    }

    @Test
    public void toStringTest() throws Exception {
        Assert.assertEquals(pattern, barcode.toString());
    }

    @Test
    public void parseStringTest() throws Exception {
        Assert.assertEquals(barcode, UPC_A.parseString(pattern));
    }

}