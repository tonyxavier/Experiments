package lab.design.designpatterns.structural.composite;


/*

The inention of Composite pattern is to have the ability to treat a single element as well as a collection of elements
in a uniform manner. That means Foo and List<Foo> will have the same API

For example, in PowerPoint, you can have a single shape or a group of shapes, can be worked on by the same set of operations, like drag, format etc.

 */


public class CompositeDemo {

    public static void main(String[] args) {

        GraphicObject drawing = new GraphicObject("Top Level");
        drawing.setName("My drawing");
        drawing.children.add(new Square("Yellow"));
        drawing.children.add(new Circle("Red"));

        GraphicObject blueGroup = new GraphicObject("Blue Group");
        blueGroup.children.add(new Circle("Blue"));
        blueGroup.children.add(new Square("Blue"));

        drawing.children.add(blueGroup);

        System.out.println(drawing);
    }
}
