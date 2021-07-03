package lab.problems.arrays;

public class BuySell {

    public BuySell() {
        // TODO Auto-generated constructor stub
    }


    public static void main(String args[]) {


        int[] p = {105, 60, 75, 125, 108, 150, 40};

        int[] buySell = maximumProfit_On2(p);

        System.out.println("Buy at:" + buySell[0]);

        System.out.println("Sell at:" + buySell[1]);


        System.out.println("______________________________________");

        buySell = maximumProfit_On(p);

        //System.out.println("Buy at:"+buySell[0]);

        //System.out.println("Sell at:"+buySell[1]);


    }


    //O(n^2) solution
    public static int[] maximumProfit_On2(int[] prices) {


        int[][] pMat = new int[prices.length][prices.length];

        int[] buySellPrices = new int[2];

        if (prices.length < 1)
            return null;
        else if (prices.length == 1) {
            buySellPrices[0] = buySellPrices[1] = prices[0];
        }


        int maxProfit = 0;
        int maxi = 0, maxj = 0;
        int profit = 0;


        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (i < j)//buy price comes before sell price
                {

                    profit = prices[j] - prices[i];

                    if (profit > maxProfit) {
                        maxProfit = profit;
                        maxi = i;
                        maxj = j;

                    }


                }
            }


        }

        buySellPrices[0] = prices[maxi];
        buySellPrices[1] = prices[maxj];

        return buySellPrices;


    }


    public static int[] maximumProfit_On(int[] prices) {

        int maxDifference = prices[1] - prices[0], minSoFar = prices[0];

        int[] buySellPrices = new int[2];

        int iBuy = 0, iSell = 1;

        for (int i = 1; i < prices.length; i++) {


            if (prices[i] - minSoFar > maxDifference && i > iBuy) {
                maxDifference = prices[i] - minSoFar;
                iSell = i;

            }

            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
                iBuy = i;
            }


        }

        buySellPrices[0] = minSoFar;
        buySellPrices[1] = prices[iSell];

        System.out.println("Max diff" + maxDifference);


        return buySellPrices;


    }


}
