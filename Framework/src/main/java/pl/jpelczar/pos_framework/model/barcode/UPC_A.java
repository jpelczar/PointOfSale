package pl.jpelczar.pos_framework.model.barcode;

/**
 * Created by jpelczar on 25.06.16.
 */
public class UPC_A implements Barcode {

    private int leftNumericalDigits;
    private int rightNumericalDigits;

    public UPC_A() {
    }

    /**
     * @param leftNumericalDigits  - must be between 100 000 and 999 999
     * @param rightNumericalDigits - must be between 100 000 and 999 999
     * @throws Exception
     */
    public UPC_A(int leftNumericalDigits, int rightNumericalDigits) throws Exception {
        if (leftNumericalDigits < 999999 && rightNumericalDigits < 999999 && leftNumericalDigits > 100000 && rightNumericalDigits > 100000) {
            this.leftNumericalDigits = leftNumericalDigits;
            this.rightNumericalDigits = rightNumericalDigits;
        } else {
            throw new Exception("Left and Right numerical digit must be between 100 000 and 999 999. Current is " + leftNumericalDigits + " and " + rightNumericalDigits);
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
        return String.valueOf(leftNumericalDigits) + rightNumericalDigits;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UPC_A) {
            UPC_A eq = (UPC_A) obj;
            return (eq.getLeftNumericalDigits() == leftNumericalDigits)
                    && (eq.getRightNumericalDigits() == rightNumericalDigits);
        } else
            return false;
    }

    public int getLeftNumericalDigits() {
        return leftNumericalDigits;
    }

    public void setLeftNumericalDigits(int leftNumericalDigits) {
        this.leftNumericalDigits = leftNumericalDigits;
    }

    public int getRightNumericalDigits() {
        return rightNumericalDigits;
    }

    public void setRightNumericalDigits(int rightNumericalDigits) {
        this.rightNumericalDigits = rightNumericalDigits;
    }
}
