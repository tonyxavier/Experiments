package lab.design.designpatterns.creational.abstractfactory;

public class Car implements Vehicle{

    String type;

    public Car(String type){
        this.type=type;
    }

    public void drive(){
        if(type.equals("Electric"))
        System.out.println("Zzzzzzzzzz");
        else
            System.out.println("CaaaaaRRRRRRRRRRRRRR");
    }
}
