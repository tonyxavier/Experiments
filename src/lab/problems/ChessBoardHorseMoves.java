package lab.problems;

import lab.utils.IndexPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ChessBoardHorseMoves {

    static int N=8;


    public static void main(String[] args) {

        ChessBoardHorseMoves board =new ChessBoardHorseMoves();
/*
        List<IndexPair> moves = board.generateAllValidMoves(2,3);

        System.out.println("Size:"+moves.size());
        for(IndexPair move:moves){
            System.out.println(move.row+","+move.col);
        }


*/
        int k=5;
        double[][][] memo = new double[k+1][N+1][N+1];
        for (int a=1;a<=k;a++)
            for (int b=1;b<=N;b++)
                for(int c=1;c<=N;c++)
                    memo[a][b][c]=-1.0;

        double p = board.calculateProbability(k,1,1);
        System.out.println("Prob:"+p);



        double p2 = board.calculateProbabilityMemoi(k,1,1,memo);
        System.out.println("Memop:"+p2);


    }

    public double calculateProbability(int k,int row,int col){

        if(k==0)
            return 1.0;

        List<IndexPair> moves = generateAllValidMoves(row,col);
        double probability=0;
        for(IndexPair move:moves){
                probability = probability + calculateProbability(k-1,move.row,move.col)/8;

        }
        return  probability;

    }

    public double calculateProbabilityMemoi(int k,int row,int col,double[][][] memo){

        if(k==0)
            return 1.0;

        List<IndexPair> moves = generateAllValidMoves(row,col);
        double probability=0;
        for(IndexPair move:moves){
            if(memo[k][move.row][move.col]>0){
                return memo[k][move.row][move.col];
            }
            else{
                probability = probability + calculateProbabilityMemoi(k-1,move.row,move.col,memo)/8;

            }
            memo[k][move.row][move.col]=probability;

        }
        return  probability;

    }


    public void calculateProbabilityIterative(int k,int row, int col){






    }



    public List<IndexPair> generateAllValidMoves(int row,int col){

        List<IndexPair> validMoves = new ArrayList<>();

        validMoves.add(new IndexPair(row+2,col+1));
        validMoves.add(new IndexPair(row+2,col-1));
        validMoves.add(new IndexPair(row-2,col+1));
        validMoves.add(new IndexPair(row-2,col-1));
        validMoves.add(new IndexPair(col+2,row+1));
        validMoves.add(new IndexPair(col+2,row-1));
        validMoves.add(new IndexPair(col-2,row+1));
        validMoves.add(new IndexPair(col-2,row-1));



        ListIterator<IndexPair> iter = validMoves.listIterator();
        while(iter.hasNext()){
            if(!isWithinBoard(iter.next())){
                iter.remove();
            }
        }

        return  validMoves;

    }



    private boolean isWithinBoard(IndexPair position){

        if(position.row>=1 && position.row<=N && position.col>=1 && position.col<=N)
            return true;
        else
            return false;

    }


}
