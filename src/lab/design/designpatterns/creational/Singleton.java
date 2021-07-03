package lab.design.designpatterns.creational;

public class Singleton {

    private static Singleton theonlyOne;


    private Singleton() {
    }


    public static Singleton getInstance() {

        if (theonlyOne == null) {

            synchronized (Singleton.class) {
                if (theonlyOne == null)
                    theonlyOne = new Singleton();

            }

        }

        return theonlyOne;

    }


}
