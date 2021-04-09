package com.dsa.facebook;

public class Q_322_Coin_Denomination_Change {

    public int coinChange(int[] coins, int amount) {
        return coinChangeHelper(coins, amount, coins.length-1, 0);
    }
    public int coinChangeHelper(int[] coins, int amount, int index, int currCount) {
        if(amount == 0){
            return currCount;
        }

        for(int  i = index; i>= 0; i--){
           if(amount - coins[i] >=0)
               currCount = currCount +1 + coinChangeHelper(coins,amount-coins[i], i, currCount+1);
        }

        return currCount;
    }

    public static void main(String[] args) {
        Q_322_Coin_Denomination_Change obj = new Q_322_Coin_Denomination_Change();
        System.out.println(obj.coinChange(new int[]{1,2,5}, 11));
    }
}
