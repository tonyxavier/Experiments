package lab.design.designpatterns.creational.abstractfactory;

public class AbsDemo {



    public static void main(String[] args){


        VehicleFactory factory = FactoryProducer.getVehicleFactory("Bike","Electric");

         Vehicle v= factory.buildVehicle();
         v.drive();

    }
}
