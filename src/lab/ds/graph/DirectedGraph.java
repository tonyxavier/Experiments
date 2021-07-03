package lab.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DirectedGraph {

    HashMap<Integer, List<Edge>> adjascencyList=new HashMap<>();

    //This is a state related to each traversal, not a state of the Graph.
        //this state can be passed to dfs() as a parameter.


    private class Edge{

        int destination;
        int weight=1;

        public Edge(int destination){

            this.destination=destination;

        }

        public Edge(int destination,int weight){

            this.destination=destination;
            this.weight=weight;

        }

    }


    public List<Edge> createVertex(int data){

        List<Edge> list = new ArrayList<>();
        adjascencyList.put(data,list);
        return adjascencyList.get(data);

    }

    public void addEdge(int source,int destination, int weight, boolean directed){



            if(adjascencyList.get(source)!=null){
                adjascencyList.get(source).add(new Edge(destination,weight));
            }
            else {
                createVertex(source).add(new Edge(destination,weight));
            }


       if(!directed){

           if(adjascencyList.get(destination)!=null){
               adjascencyList.get(destination).add(new Edge(source,weight));
           }
           else {
               createVertex(destination).add(new Edge(source,weight));
           }


       }
    }


    //For disjoint graphs, the DFS will not cover all the nodes from starting node. So
    //the DFS need to iterate through each node.
    public void DFSDriver(){

        Set<Integer> nodes = adjascencyList.keySet();
        HashMap<Integer,Boolean> visited=new HashMap<Integer,Boolean>();


        for (Integer n:nodes){

            for(Edge e: adjascencyList.get(n)){

               dfs(n,visited);


            }

        }




    }


    public void dfs(Integer vertex,HashMap<Integer,Boolean> visited){


        visited.put(vertex,true);
        List<Edge> edges = adjascencyList.get(vertex);

        for(Edge edge:edges){

            int next = edge.destination;
            if(!visited.get(next))
                dfs(next,visited);

        }



    }








}
