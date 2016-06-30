package pl.jpelczar.pos_app.output.printer;

import pl.jpelczar.pos_app.base.Presenter;
import pl.jpelczar.pos_framework.model.Receipt;
import pl.jpelczar.pos_framework.model.ReceiptProduct;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jpelczar on 29.06.16.
 */
public class PrinterPresenter extends Presenter<PrinterMvpView> {
    public PrinterPresenter(PrinterMvpView mvpView) {
        super(mvpView);
    }

    public String convertReceipt(Receipt receipt) {
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(receipt.getDate());
        stringBuilder.append("Date: ").append(dateFormat.format(calendar.getTime())).append("\n");

        stringBuilder.append("Name").append("\t")
                .append("Price").append("\t")
                .append("Quantity").append("\t")
                .append("Total").append("\n");

        String name;
        for (ReceiptProduct rp : receipt.getProductList()) {
            name = rp.getProduct().getName();
            if (name.length() > 12) name = name.substring(0, 9).concat("...");
            stringBuilder.append(name).append("\t")
                    .append(rp.getProduct().getPrice()).append("\t")
                    .append(rp.getQuantity()).append("\t")
                    .append(rp.getTotalPrice()).append("\n");
        }
        stringBuilder.append("Total price: ").append(String.format("%10.2f", receipt.getTotalPrice()));
        return stringBuilder.toString();
    }
}
