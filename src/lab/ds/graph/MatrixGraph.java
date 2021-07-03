package lab.ds.graph;

import java.util.ArrayList;

//A Graph implementation using Adjacency Matrix.
//Adjacency Matrix can be used when the graph is dense and new elements are not added dynamically.
//The graph is NOT directed
public class MatrixGraph {

    int[][] adjMatrix = null;
    int numberOfVertices = 0;


    public MatrixGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjMatrix = new int[numberOfVertices][numberOfVertices];

    }


    public static void main(String[] args) {

        MatrixGraph graph = new MatrixGraph(6);

        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);
        graph.addEdge(4, 6);
        graph.addEdge(3, 6);


        graph.printMatrix();


        System.out.println(graph.isAdjacent(6, 2));
        System.out.println(graph.isAdjacent(2, 6));
        System.out.println(graph.isAdjacent(4, 2));


        ArrayList<Integer> neighbours = graph.getNeighbours(1);

        for (int v : neighbours) {
            System.out.print(v + " ");

        }


    }


    private void printMatrix() {

        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean isAdjacent(int x, int y) {
        if (adjMatrix[x - 1][y - 1] > 0)
            return true;
        else
            return false;

    }

    public ArrayList<Integer> getNeighbours(int x) {


        ArrayList<Integer> neighbours = new ArrayList<Integer>();

        for (int i = 0; i < numberOfVertices; i++) {
            if (adjMatrix[x - 1][i] > 0)
                neighbours.add(i + 1);

        }

        return neighbours;

    }


    public void addEdge(int x, int y, int weight) {

        adjMatrix[x - 1][y - 1] = weight;
        adjMatrix[y - 1][x - 1] = weight;


    }

    public void addEdge(int x, int y) {

        adjMatrix[x - 1][y - 1] = 1;
        adjMatrix[y - 1][x - 1] = 1;

    }

    public void removeEdge(int x, int y) {

        adjMatrix[x - 1][y - 1] = 0;
        adjMatrix[y - 1][x - 1] = 0;

    }


}
