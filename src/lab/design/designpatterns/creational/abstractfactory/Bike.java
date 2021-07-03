package lab.design.designpatterns.creational.abstractfactory;

public class Bike implements Vehicle{
    String type;

    public Bike(String type){
        this.type=type;
    }

    public void drive(){
        if(type.equals("Electric"))
            System.out.println("BbbbZzzzzzzzzz");
        else
            System.out.println("BiiiiiiKKKKKKKKKK");
    }

}
