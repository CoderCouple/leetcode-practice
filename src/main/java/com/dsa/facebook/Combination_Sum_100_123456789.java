package com.dsa.facebook;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Combination_Sum_100_123456789 {

    public void getCombinationSum(String expression, int sum, int curr, int next, int target) throws ScriptException {

        if (next > 10 ) {

            if(sum == target &&  curr == 10){
                //System.out.println(curr);
            System.out.println(expression + " = " + sum);
            }
            return;
        }

        getCombinationSum(expression , sum, curr*10+next, next + 1, target);
        //if(num != 1){
        getCombinationSum(expression + " + " + curr, sum + curr, next, next + 1, target);
        //}
        getCombinationSum(expression+" - "+curr,sum-curr, next, next+1, target);

        //System.out.println(expression + " = "+ sum );
        //System.out.println(prev );

    }

    private int evaluateExpression(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (int) engine.eval(expression);
    }


    public static void main(String[] args) throws ScriptException {
        Combination_Sum_100_123456789 obj = new Combination_Sum_100_123456789();
        //obj.getCombinationSum("", 0, 1, 2, 100);
        //obj.getCombinationSum2("", 1, 100);
        obj.getCombinationSum("", 0, 1, 2, 100);

    }

    // TC: O(3^n) n: number of digits

    //The time complexity algorithm of this problem is interesting and whether it's easy to analyze can depend on the chosen solution.
    // The key to the analysis is noticing that at every place we have 3 choices ("+, "-", no-operation).
    // Since 3 is the branching factor, we are considering 3^n different strings at the end. Generating that takes

    // SC: O(n)   n: number of digits
    public void getCombinationSum2(String expression, int num, int target) throws ScriptException {
        if (num >= 10) {
            if (evaluateExpression(expression) == target) {
                System.out.println(expression + " = " + target);
            }
            return;
        }

        if (num != 1) {
            getCombinationSum2(expression + "+" + num, num + 1, target);
        }
        getCombinationSum2(expression + "-" + num, num + 1, target);
        getCombinationSum2(expression + "" + num, num + 1, target);
    }
}
