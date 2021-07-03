package lab.design.designpatterns.creational.prototype;

public abstract class AnalyticsReport implements Cloneable{

   @Override
   public AnalyticsReport clone() throws CloneNotSupportedException{

       return (AnalyticsReport) super.clone();

   }

}
