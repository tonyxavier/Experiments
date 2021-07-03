package lab.problems.sorting;


//Input is a list of cordinate points {[2,3],[4,5],[6,7]}
//Return k nearest points in the order of its distance from origin. Formula for distance sqrt(x*x+y*y)


import java.util.ArrayList;
import java.util.List;

public class SortByDistanceFromOrigin {


    public List<Point> calculateDistanceFromOrigin(List<Point> points,int k) {

    MinHeap minHeap = new MinHeap(points.size());
    List<Point> result=new ArrayList<>();


        for (Point point :points){
           minHeap.insert(new Distance(point, Math.sqrt(point.x*point.x + point.y*point.y)));
        }



        for(int i=0;i<k;i++)
            result.add(minHeap.remove().point);


        return result;


    }


    private class Point {

        int x, y;


        public Point(int x, int y) {

            this.x = x;
            this.y = y;

        }


    }


    private class MinHeap{

        double[] minHeap;

        public MinHeap(int size){

            minHeap = new double[size];
        }


        public void insert(Distance distance){


        }

        public Distance remove(){


            return  null;
        }

    }


    private class Distance{

        Point point;
        double distance;

        public Distance(Point point,double distance){
            this.point=point;
            this.distance=distance;


        }

    }


}