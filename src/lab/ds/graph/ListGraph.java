package lab.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


//Assumes that the key for vertices are from 1 to V (number of vertices)

public class ListGraph {

    int V;//Number of vertices


    HashMap<Integer, Vertex> adjacencyList;
    //In a more realistic implementation a HashMap may be better, because in that case the key wont be ArrayList indices for direct access.


    public ListGraph() {

        adjacencyList = new HashMap<Integer, Vertex>();

    }

    protected class Vertex {

        int key;
        Object data;
        ArrayList<Edge> neighbours;


        Vertex(int key, Object data) {
            this.key = key;
            this.data = data;
            neighbours = new ArrayList<Edge>();

        }


    }

    protected class Edge {

        int source, destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;

        }


    }


    public static void main(String args[]) {

        ListGraph graph = new ListGraph();

        graph.addVertex(0);

        graph.addVertex(1);

        graph.addVertex(2);

        graph.addVertex(3);


        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);


//		System.out.println(graph.isAdjacent(1,3));


        //graph.DepthFirstSearch(0);


        graph.BreadthFirstSearch(2);


    }


    public boolean isAdjacent(int x, int y) {

        Vertex vx = adjacencyList.get(x);
        Vertex vy = adjacencyList.get(y);


        for (Edge e : vx.neighbours) {

            if (e.destination == y) {
                return true;
            }


        }


        for (Edge e : vy.neighbours) {

            if (e.destination == x) {
                return true;
            }


        }

        return false;

    }


    public int getSize() {
        return adjacencyList.size();
    }

    public void addVertex(int key, Object data) {

        adjacencyList.put(key, new Vertex(key, data));


    }

    public void addVertex(int key) {

        adjacencyList.put(key, new Vertex(key, null));


    }


    public void addEdge(int source, int destination, int weight) {

        Vertex vsource = adjacencyList.get(source);

        Edge e = new Edge(source, destination, weight);

        vsource.neighbours.add(e);

    }


    //No weight
    public void addEdge(int source, int destination) {

        Vertex vsource = adjacencyList.get(source);

        Edge e = new Edge(source, destination, 0);

        vsource.neighbours.add(e);


    }


    public void DepthFirstSearch(int source) {

        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        DFS(source, visited);

    }

    private void DFS(int source, HashMap<Integer, Boolean> visited) {

        System.out.println(source + " ");
        visited.put(source, true);

        Vertex v = adjacencyList.get(source);

        for (Edge e : v.neighbours) {
            int nextNode = e.destination;

            if (visited.get(nextNode) == null) {
                DFS(nextNode, visited);
            }


        }


    }


    public void BreadthFirstSearch(int source) {

        Queue<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();


        queue.add(source);


        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.println(current + " ");

            visited.put(current, true);

            Vertex v = adjacencyList.get(current);

            for (Edge e : v.neighbours) {

                int dest = e.destination;

                if (visited.get(dest) == null && (!queue.contains(dest))) {
                    queue.add(dest);
                }


            }

        }


    }

    //Prim's algorithm
    public void minimumSpanningTree() {


    }


    //Dijkstra�s
    public void shortestPath() {

    }


}
