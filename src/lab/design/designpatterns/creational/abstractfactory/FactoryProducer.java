package lab.design.designpatterns.creational.abstractfactory;

public class FactoryProducer {

    public static VehicleFactory getVehicleFactory(String type, String fuel){

        if(type.equals("Car") && fuel.equals("Electric")){
            return  new CarFactory(true);
        }
        else if(type.equals("Car") && fuel.equals("Petrol")){
            return  new CarFactory(false);
        }
        else if(type.equals("Bike") && fuel.equals("Petrol")){
            return  new BikeFactory(false);
        }
        else if(type.equals("Bike") && fuel.equals("Electric")){
            return  new BikeFactory(true);
        }
        else
            return  null;

    }

}
