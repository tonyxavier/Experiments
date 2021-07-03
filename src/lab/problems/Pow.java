package lab.problems;

public class Pow {


    public static void main(String[] args) {

        Pow math = new Pow();
        int n=2147483647; double x=0.00001;



        System.out.println(math.powOptimizedIterative(x,n));
        System.out.println(Math.pow(x,n));
      //  System.out.println(math.pow(x,n));

    }


    public double powOptimizedIterative(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        double current_product = x;
        for (int i = n; i > 0; i = i/2) {
            if ((i % 2) == 1) {
                result = result * current_product;
            }
            current_product = current_product * current_product;
        }
        return result;
    }



    public double powOPtimizedRecursive(double x,int n){

        if(n<0) {
            x = 1 / x;
            n=-1*n;
        }

        if(n==0)
            return 1.0;

        if(n==1)
            return x;

       int half = n/2;

       if(n%2==0){
            return powOPtimizedRecursive(x,half)*powOPtimizedRecursive(x,half);
       }
       else{

           return powOPtimizedRecursive(x,half)*powOPtimizedRecursive(x,half)*x;
       }


    }

    //This solution has an illusion of being better. But it isn't
    public double powRecursive(double x, int n){

        if(x==0.0)
            return 0.0;

        if(n==0)
            return 1.0;
        if (n==1)
            return x;

        if(n==-1)
            return 1/x;

        if(n>1)
            return powRecursive(x,n-1)*x;

       // if(n<-1)
            return powRecursive(x,n+1)*(1/x);

    }

    public double powBruteForce(double x,int n){


        double result = 1.0;

        if(n==0) {
            return 1.0;
        }
        else if(n<0){

            for(int i=-1;i>=n;i--){
                result = result*(1/x);

            }

            return result;

        }
        else{
            for (int i = 1; i <= n; i++) {
                result = result * x;
            }
            return result;
        }

    }
}
