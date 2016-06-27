package pl.jpelczar.pos_framework.model.barcode;

/**
 * Created by jpelczar on 25.06.16.
 */
public class UPC_A implements Barcode {

    private int leftNumericalDigit;
    private int rightNumericalDigit;

    public UPC_A() {
    }

    /**
     * @param leftNumericalDigit  - must be between 100 000 and 999 999
     * @param rightNumericalDigit - must be between 100 000 and 999 999
     * @throws Exception
     */
    public UPC_A(int leftNumericalDigit, int rightNumericalDigit) throws Exception {
        if (leftNumericalDigit < 999999 && rightNumericalDigit < 999999 && leftNumericalDigit > 100000 && rightNumericalDigit > 100000) {
            this.leftNumericalDigit = leftNumericalDigit;
            this.rightNumericalDigit = rightNumericalDigit;
        } else {
            throw new Exception("Left and Right numerical digit must be between 100 000 and 999 999");
        }
    }

    /**
     * @param barcodeString - must have LLLLLLDDDDDD format where L and D are digits between 0 and 9
     * @return new UPC-A barcode object
     * @throws Exception
     */
    public static UPC_A parseString(String barcodeString) throws Exception {
        if (barcodeString.length() != 12) {
            throw new Exception("Argument must have LLLLLLDDDDDD format where L and D are digits between 0 and 9");
        } else
            return new UPC_A(
                    Integer.parseInt(barcodeString.substring(0, 6)),
                    Integer.parseInt(barcodeString.substring(6, 12)));
    }

    @Override
    public String toString() {
        return String.valueOf(leftNumericalDigit) + rightNumericalDigit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UPC_A) {
            UPC_A eq = (UPC_A) obj;
            return (eq.getLeftNumericalDigit() == leftNumericalDigit)
                    && (eq.getRightNumericalDigit() == rightNumericalDigit);
        } else
            return false;
    }

    public int getLeftNumericalDigit() {
        return leftNumericalDigit;
    }

    public void setLeftNumericalDigit(int leftNumericalDigit) {
        this.leftNumericalDigit = leftNumericalDigit;
    }

    public int getRightNumericalDigit() {
        return rightNumericalDigit;
    }

    public void setRightNumericalDigit(int rightNumericalDigit) {
        this.rightNumericalDigit = rightNumericalDigit;
    }
}
