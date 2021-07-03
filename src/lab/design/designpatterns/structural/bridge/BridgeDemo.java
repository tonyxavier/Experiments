package lab.design.designpatterns.structural.bridge;

/*

Bridge Pattern - Reply on abstractions and aggregation(has a) to avoid an explosion in the number of concrete classes.

Without an abstraction for Renderer, it would have resulted in an explosion in the
number of concrete classes like CircleVectorRenderer, CircleRasterRenderer, RectangleVectorRenderer, RectangleRasterRenderer etc.
 */


public class BridgeDemo {
    public static void main(String[] args) {


          Circle circle = new Circle(5);
          VectorRenderer renderer = new VectorRenderer();
          circle.setRenderer(renderer);
          circle.draw();



          Rectangle rectangle = new Rectangle(3,7);
          RasterRenderer rasterRenderer = new RasterRenderer();
          rectangle.setRenderer(rasterRenderer);
          rectangle.draw();


    }
}
