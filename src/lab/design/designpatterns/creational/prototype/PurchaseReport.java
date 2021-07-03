package lab.design.designpatterns.creational.prototype;

public class PurchaseReport extends AnalyticsReport{

    String timestamp;
    int[] purchasereport;

    @Override
    public PurchaseReport clone()throws CloneNotSupportedException{

        return (PurchaseReport) super.clone();
    }

}
