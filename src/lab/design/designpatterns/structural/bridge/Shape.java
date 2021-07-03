package lab.design.designpatterns.structural.bridge;

public abstract class Shape {
    protected Renderer renderer = new VectorRenderer(); //default behaviour


    public abstract void draw();
    public void setRenderer(Renderer renderer){
        this.renderer=renderer;
    }


}
