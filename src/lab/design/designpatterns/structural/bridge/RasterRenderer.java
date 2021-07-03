package lab.design.designpatterns.structural.bridge;

public class RasterRenderer implements Renderer{

    @Override
    public void drawCircle(int radius) {
        System.out.println("RasterRenderer Drawing Circle");
    }

    @Override
    public void drawRectangle(int a, int b) {

        System.out.println("RasterRenderer Drawing Rectangle");
    }
}
