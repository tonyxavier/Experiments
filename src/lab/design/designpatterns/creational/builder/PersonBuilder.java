package lab.design.designpatterns.creational.builder;

/* Builder pattern lets the developer build an onject step by step,
  rather than providing a counstructor having so many arguments
  StringBuilder is an example in Java
  Builder pattern is suitable when most of the properties are not  mandatory.
  If you allow building of object without the mandatory parameters, that can create problem.
 */
public class PersonBuilder {


    String aadhaar;
    int height;
    String name;

    public PersonBuilder( String aadhaar){
        this.aadhaar = aadhaar;

    }

    public PersonBuilder height(int height){
        this.height=height;
        return  this;
    }

    public PersonBuilder name(String name){
        this.name=name;
        return  this;
    }


    public String toString(){

        return "Hello "+name;
    }



}
