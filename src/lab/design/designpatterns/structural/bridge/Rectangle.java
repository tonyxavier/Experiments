package lab.design.designpatterns.structural.bridge;

public class Rectangle extends Shape{

    int a,b;



    public Rectangle(int a, int b){
        this.a=a;
        this.b=b;

    }

    @Override
    public void draw() {

        renderer.drawRectangle(a,b);

    }


}
