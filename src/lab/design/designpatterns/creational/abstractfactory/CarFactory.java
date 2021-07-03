package lab.design.designpatterns.creational.abstractfactory;

public class CarFactory extends VehicleFactory{

     boolean electric;

     public CarFactory(boolean electric){
         this.electric=electric;
     }

@Override
    public Vehicle buildVehicle(){

        if(electric)
        return new Car("Electric");
        else
        return new Car("Petrol");
    }
}
