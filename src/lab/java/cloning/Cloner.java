package lab.java.cloning;

public class Cloner {

    First first = new First();


    public Cloner() {
        // TODO Auto-generated constructor stub
    }


    public static void main(String args[]) throws CloneNotSupportedException {

        Cloner cloner = new Cloner();

        First copy = (First) cloner.first.clone();


        System.out.println("Copied: a-" + copy.a + " b-" + copy.third.b + " c-" + copy.third.c);

    }


}
