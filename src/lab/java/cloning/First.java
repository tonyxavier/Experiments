package lab.java.cloning;

class First implements Cloneable {

    int a;
    Third third = new Third();

    First() {
        a = 10;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }


    public void finalize() {

        third = null;//funeral - going to be buried, do the needful

    }


}
