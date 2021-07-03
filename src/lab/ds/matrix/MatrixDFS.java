package lab.ds.matrix;

import lab.utils.IndexPair;

public class MatrixDFS {

 //int M=4,N=5;
    int[][] matrix = {{1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20}};

    int ROW_SIZE=matrix.length,COL_SIZE=matrix[0].length;
    boolean[][] visited = new boolean[ROW_SIZE][COL_SIZE];
    int[] values = new int[ROW_SIZE*COL_SIZE];
    int i = 0;

    public static void main(String[] args) {

        MatrixDFS dfs = new MatrixDFS();

        dfs.DFS(new IndexPair(0,0));

        for(int n: dfs.values)
            System.out.println(n);


    }


    public void DFS(IndexPair position){

        if(!isValidIndex(position) || visited[position.row][position.col]==true)
            return;


        visited[position.row][position.col]=true;
        values[i++]=matrix[position.row][position.col];

        DFS(new IndexPair(position.row-1,position.col)); //Top
        DFS(new IndexPair(position.row,position.col+1));//Right
        DFS(new IndexPair(position.row+1,position.col));//Below
        DFS(new IndexPair(position.row,position.col-1));//Left

    }




    private boolean isValidIndex(IndexPair index){

        if(index.row<0 || index.row>=ROW_SIZE || index.col<0 || index.col>=COL_SIZE)
            return false;
        else
            return true;

    }



}
