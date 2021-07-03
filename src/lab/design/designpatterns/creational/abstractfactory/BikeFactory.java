package lab.design.designpatterns.creational.abstractfactory;

public class BikeFactory extends  VehicleFactory{

    boolean electric;

    public BikeFactory(boolean electric){
        this.electric=electric;
    }

    @Override
    public Vehicle buildVehicle(){

        if(electric)
            return new Bike("Electric");
        else
            return new Bike("Petrol");
    }
}
