package lab.design.designpatterns.structural.bridge;

public class VectorRenderer implements Renderer{

    @Override
    public void drawCircle(int radius) {
        System.out.println("VectorRenderer Drawing Circle");
    }

    @Override
    public void drawRectangle(int a, int b) {

        System.out.println("VectorRenderer Drawing Rectangle");
    }
}
