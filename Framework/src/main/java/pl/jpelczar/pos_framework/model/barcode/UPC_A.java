package pl.jpelczar.pos_framework.model.barcode;

/**
 * Created by jpelczar on 25.06.16.
 */
public class UPC_A implements Barcode {

    private int leftNumericalDigit;
    private int rightNumericalDigit;

    public UPC_A() {
    }

    public UPC_A(int leftNumericalDigit, int rightNumericalDigit) {
        this.leftNumericalDigit = leftNumericalDigit;
        this.rightNumericalDigit = rightNumericalDigit;
    }

    public static UPC_A parseString(String barcodeString) {
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
