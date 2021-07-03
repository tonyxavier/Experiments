package lab.problems.arrays;


//There are petrol pumps 1 to n in circular fashion.
//Each pump has a stock[i] litres
//one pump to next takes distance[i] litres of petrol 
//Find "a" starting point such that you can make a round trip.

public class PetrolPump {


    public static void main(String args[]) {

        int[] stock = {5, 3, 8, 5, 2};

        int[] distance = {4, 3, 6, 7, 3};


        //	int pos=getStartingPoint_On2(stock,distance);
        int pos = getStartingPoint_On(stock, distance);

        if (pos != -1) {
            System.out.println("Full circle is possible from " + pos);
        } else {
            System.out.println("Full circle is NOT possible");
        }


    }


    //No matter where you start from, every iteration has a point where the
    //balance in the tank is least(may be -ve or +ve). If you start from the
    //point after this point it is guaranteed that you will have a +ve balance always.
    public static int getStartingPoint_On(int[] stock, int[] distance) {

        int minBalance = Integer.MAX_VALUE, balance = 0, startingPosition = 0;
        for (int i = 0; i < stock.length; i++) {
            balance += stock[i] - distance[i];
            if (balance < minBalance) {
                minBalance = balance;
                startingPosition = (i + 1) % stock.length;
            }
        }
        if (balance >= 0)
            return startingPosition;
        else
            return -1;
    }


    //For each starting point check if you can make a path such that tank balance is +ve
    public static int getStartingPoint_On2(int[] stock, int[] distance) {
        int size = stock.length;

        for (int i = 0; i < size; i++) {
            int balance = stock[i] - distance[i];
            int j = i;
            while (balance >= 0) {
                if (j == size - 1) {
                    j = 0;
                } else {
                    j++;
                }

                balance = balance + (stock[j] - distance[j]);


                //Full circle completed
                //balance is positive and j has traversed through all the nodes from i
                if ((balance >= 0) && (i == 0 && j == size - 1) || (j == i - 1)) {

                    return i;

                }

            }


        }


        return -1;

    }


}
