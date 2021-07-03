package lab.ds.graph;


public abstract class Graph {

    boolean directed = false;

    public Graph() {

    }

    protected class Vertex {
        int key;
        int data; //In a more realistic design, it'll be of type Object or a custom type


        Vertex(int key, int data) {
            this.key = key;
            this.data = data;
        }

    }


    public abstract boolean isAdjacent(int x, int y);

    public abstract boolean isConnected(int x, int y);

    public abstract void addVertex(Vertex x);

    public abstract Vertex removeVertex(Vertex x);

    public abstract void addEdge(int x, int y);

    public abstract void addEdge(int x, int y, int weight);

    public abstract void removeEdge(int x, int y);

    public abstract void setVertexValue(int key, Object value);

    public abstract Object getVertexValue(int key);


}
