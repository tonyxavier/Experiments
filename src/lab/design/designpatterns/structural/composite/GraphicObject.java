package lab.design.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GraphicObject {
    protected String name="Group";
    public String color;
    public List<GraphicObject> children=new ArrayList<>();


    public GraphicObject(){

    }

    public GraphicObject(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){

        StringBuilder sb =new StringBuilder();
        print(sb,0);
        return sb.toString();

    }


    private void print(StringBuilder stringBuilder, int depth){

        stringBuilder.append(String.join("", Collections.nCopies(depth,"*")))
                     .append(depth>0?" ":"")
                     .append((color==null||color.isEmpty())? "": color+" ")
                     .append(getName())
                     .append(System.lineSeparator());

        for(GraphicObject child:children){
            child.print(stringBuilder, depth+1);
        }

    }


}
