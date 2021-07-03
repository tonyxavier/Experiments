package lab.ds.graph;

import java.util.HashMap;
import java.util.Set;

import lab.ds.graph.ListGraph.Edge;
import lab.ds.graph.ListGraph.Vertex;

public class UndirectedGraph extends ListGraph {


    public static void main(String args[]) {

        UndirectedGraph graph = new UndirectedGraph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);


        graph.connect(0, 1, 4);
        graph.connect(0, 7, 8);
        graph.connect(1, 2, 8);
        graph.connect(1, 7, 11);
        graph.connect(2, 3, 7);
        graph.connect(2, 5, 4);
        graph.connect(2, 8, 2);
        graph.connect(3, 4, 9);
        graph.connect(3, 5, 14);
        graph.connect(4, 5, 10);
        graph.connect(5, 6, 2);
        graph.connect(6, 7, 1);
        graph.connect(6, 8, 6);
        graph.connect(7, 8, 7);


        //DFS result will change based on the order in which edges are added.
        //graph.DepthFirstSearch(0);

        //	graph.BreadthFirstSearch(0);


        graph.shortestPathDijktras(0);


    }

    public void connect(int source, int destination, int weight) {

        Vertex vsource = adjacencyList.get(source);

        Edge e = new Edge(source, destination, weight);
        vsource.neighbours.add(e);

        Vertex vdestination = adjacencyList.get(destination);
        e = new Edge(destination, source, weight);

    }


    public void shortestPathDijktras(int source) {

        HashMap<Integer, Boolean> spt = new HashMap<Integer, Boolean>();
        HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();

        Set<Integer> vertices = adjacencyList.keySet();
        for (Integer i : vertices) {
            distance.put(i, Integer.MAX_VALUE);
            spt.put(i, false);
        }

        distance.put(source, 0);


        int count = 0;
        int graphSize = getSize();

        //At each step 1 vertex is added to the shortest path tree.
        //Repeat until N nodes are added where N is the size of the graph
        while (count < graphSize) {

            //Choose a vertex with minimum distance from source which is not yet added to the shortest path tree
            int min = minDistance(distance, spt, vertices);
            Vertex v = adjacencyList.get(min);


            //Add the selected vertex to the shortest path tree
            spt.put(min, true);


            //Calculate the new distance for each neighbor of v
            for (Edge e : v.neighbours) {
                int node = e.destination;

                if (spt.get(node) == false && distance.get(node) > distance.get(v.key) + e.weight) {
                    distance.put(node, distance.get(v.key) + e.weight);

                }


            }


            count++;
        }


        printShortestDistances(distance, vertices);

    }


    private int minDistance(HashMap<Integer, Integer> distance, HashMap<Integer, Boolean> spt, Set<Integer> vertices) {

        int min = Integer.MAX_VALUE;
        int minVertex = Integer.MIN_VALUE;//The vertex which is to be considered next - return value


        for (Integer key : vertices) {

            int dist = distance.get(key);

            if (spt.get(key) == false && dist < min) {
                min = dist;
                minVertex = key;


            }


        }


        return minVertex;


    }


    private void printShortestDistances(HashMap<Integer, Integer> distance, Set<Integer> vertices) {


        for (Integer key : vertices) {

            System.out.println("Distance to vertex " + key + " is" + distance.get(key));


        }


    }

}
