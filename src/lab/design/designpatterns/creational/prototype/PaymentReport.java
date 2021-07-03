package lab.design.designpatterns.creational.prototype;


/*

Prototype pattern is used for object creation when the creation is very expensive.
For example, lets say the object is a report which is a costly DB operation.
If a copy of the report is enough, protype pattern can be used to create a copy of the report, instead of a new report.

 */

import lab.Test;

public class PaymentReport extends AnalyticsReport{

    String timestamp;
    int[] paymentreport;


    @Override
    public PaymentReport clone()throws CloneNotSupportedException{

        return (PaymentReport) super.clone();

    }

}
