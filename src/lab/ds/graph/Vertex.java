package lab.ds.graph;

public class Vertex {

        int key;
        int data; //In a more realistic design, it'll be of type Object or a custom type


        public Vertex(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public Vertex(int data) {

        this.data = data;
    }

    }

