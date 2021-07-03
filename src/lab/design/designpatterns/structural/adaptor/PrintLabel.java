package lab.design.designpatterns.structural.adaptor;

/*


Adaptor pattern creates an adaptor that can be plugged in the middle
In the below case, its much more cleaner to add a new public method, rather than changing the existing method
because changing breaks existing contract.

Mostly its better to add extra methods rather than changing the existing ones.


 */

public class PrintLabel {

    public void printLable(String orderId){

        System.out.println("Generating label using orderId in ItemId-transactionId format");

    }


    public void printLabelUsingNewOrderId(String newOrderId){

        printLable(OrderIdAdaptor.getLegacyOrderId(newOrderId));

    }

}
