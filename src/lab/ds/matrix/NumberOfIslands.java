package lab.ds.matrix;

import lab.utils.IndexPair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {

   // int numberOfIslands=0;
    int[][]matrix = {{0,1,1,0,0},
            {1,1,0,0,1},
            {1,0,1,1,0},
            {1,1,0,0,0}};

     boolean[][] visited = new boolean[matrix.length][matrix[0].length];



    public static void main(String[] args) {

        NumberOfIslands island = new NumberOfIslands();
        int count = island.findNumberOfIslands();
        System.out.println(count);

    }

    public int findNumberOfIslands(){

        int numberOfIslands=0;
        Queue<IndexPair> queue = new LinkedList<>();

        for(int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[0].length;j++) {

                if(visited[i][j] || matrix[i][j]==0)
                    continue;

                queue = new LinkedList<>();
                queue.add(new IndexPair(i,j));
                boolean first=true;
                while (!queue.isEmpty()) {

                    if(first){
                        numberOfIslands++;
                        first=false;
                    }

                    IndexPair current = queue.poll();
                    if(visited[current.row][current.col])
                        continue;;

                    visited[current.row][current.col]=true;

                    List<IndexPair> neighbours = getValidNeighbours(current);

                    for (IndexPair neighbour :neighbours){
                         if(matrix[neighbour.row][neighbour.col]==1)
                             queue.add(neighbour);

                    }
                }


            }

  return numberOfIslands;

    }

    private List<IndexPair> getValidNeighbours(IndexPair position){

        List<IndexPair> neighbours = new ArrayList<>();

        IndexPair top = new IndexPair(position.row-1,position.col);
        IndexPair right = new IndexPair(position.row,position.col+1);
        IndexPair below = new IndexPair(position.row+1,position.col);
        IndexPair left = new IndexPair(position.row,position.col-1);


        if(isValidIndex(top))
            neighbours.add(top);
        if (isValidIndex(right))
            neighbours.add(right);
        if(isValidIndex(below))
            neighbours.add(below);
        if (isValidIndex(left))
            neighbours.add(left);

       return neighbours;

    }


    private boolean isValidIndex(IndexPair postion){

        if(postion.row<0 || postion.row>=matrix.length || postion.col<0 || postion.col>=matrix[0].length)
            return false;
        else
            return true;
    }


}
