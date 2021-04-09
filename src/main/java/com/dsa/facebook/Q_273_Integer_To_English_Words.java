package com.dsa.facebook;

public class Q_273_Integer_To_English_Words {

    public String numberToWords(int num) {
        String [] unit = new String[]          {"", "One", "Two", "Three","Four", "Five", "Six", "Seven", "Eight", "Nine" };
        String [] lessThanTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        String [] decades = new String[]       {"","","Twenty","Thirty","Forty","Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
        String [] sign = new String[]          {"Positive", "Negative" };

        StringBuilder sb = new StringBuilder();
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        if(num == 0)
            return "Zero";

        if(num < 0){
            sb.append(sign[1]).append(" ");
            num = num * -1;
        } else {
            sb.append(sign[0]).append(" ");
        }

        if(num >= billion){
            sb.append(resolveTriplet(num/billion, unit, lessThanTwenty, decades));
            sb.append(" Billion ");
            num = num % billion;
        }

        if(num >= million){
            sb.append(resolveTriplet(num/million, unit, lessThanTwenty, decades));
            sb.append(" Million ");
            num = num % million;
        }

        if(num >= thousand){
            sb.append(resolveTriplet(num/thousand, unit, lessThanTwenty, decades));
            sb.append(" Thousand ");
            num = num % thousand;
        }

        if (num >= 0)
            sb.append(resolveTriplet(num, unit, lessThanTwenty, decades));

        return sb.toString().trim();
    }

    public  String resolveTriplet(int triplet, String [] unit, String [] lessThanTwenty, String [] decades) {
        StringBuilder sb = new StringBuilder();
        if(triplet >= 100){
            sb.append(unit[triplet/100]);
            sb.append(" Hundred ");
            triplet = triplet % 100;
        }

        if(triplet < 20 && 10 <= triplet){
            sb.append(lessThanTwenty[triplet%10]);
        } else if( triplet < 10){
            sb.append(unit[triplet]);
        } else {
            sb.append(decades[triplet/10]).append(" ").append(unit[triplet%10]);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Q_273_Integer_To_English_Words obj = new Q_273_Integer_To_English_Words();
        System.out.println(obj.numberToWords(-12345));
    }
}
