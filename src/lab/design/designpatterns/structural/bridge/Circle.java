package lab.design.designpatterns.structural.bridge;

public class Circle extends Shape{

    int radius;

    public Circle(int rad){
       radius = rad;
    }


    @Override
    public void draw() {

        renderer.drawCircle(radius);
    }


}
