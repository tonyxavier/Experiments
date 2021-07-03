package lab.design.designpatterns.creational.builder;

public class BuilderDemo {

    public static void main(String args[]){

        PersonBuilder person = new PersonBuilder("2134 5432 4567");
         String p = person.height(172)
                .name("Kranti").toString();

        System.out.println(p);

    }
}
