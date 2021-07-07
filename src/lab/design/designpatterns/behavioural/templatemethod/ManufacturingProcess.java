package lab.design.designpatterns.behavioural.templatemethod;


/* This is called a Template Method Pattern - An abstract class is able to define a
    general workflow using abstract methods, that is only implemented by its concrete classes.
    For example a CellPhoneManufacturingProcess can extend this abstract class and implement
    the methods. LaptopManufacturingProcess will have a different implementation.
    But the process flow/outline is defined in the abstract class itself.


    Probably the most important reason for abstract class to exist is to provide the ability to
    have template method pattern! Interface was not able to provide this feature.

 */


public abstract class ManufacturingProcess {

    private String processName;

    public  ManufacturingProcess (String processName){
        this.processName=processName;

    }

    protected abstract void assembleDevice();
    protected abstract void testDevice();
    protected abstract void packageDevice();
    protected abstract void storeDevice();

    public void launchProcess(){

        assembleDevice();
        testDevice();
        packageDevice();
        storeDevice();

    }



    }
