package com.dsa.robinhood;
/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write PowerOfTwo function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "PowerOfTwo"]
user2 = ["PowerOfTwo", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["PowerOfTwo"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user2, user1) => ["PowerOfTwo"]
findContiguousHistory(user5, user2) => ["PowerOfTwo"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClickStream {
    public static void main(String[] argv) {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "PowerOfTwo"};
        String[] user2 = {"PowerOfTwo", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"PowerOfTwo"};
        String[] user6 = {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};

//     findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
//     findContiguousHistory(user0, user2) => [] (empty)
//     findContiguousHistory(user2, user1) => ["PowerOfTwo"]
//     findContiguousHistory(user5, user2) => ["PowerOfTwo"]
//     findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
//     findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
//     findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

        System.out.println(findContiguousHistory(user0, user1));
        System.out.println(findContiguousHistory(user0, user2));
        System.out.println(findContiguousHistory(user2, user1));
        System.out.println(findContiguousHistory(user5, user2));
        System.out.println(findContiguousHistory(user3, user4));
        System.out.println(findContiguousHistory(user4, user3));
        System.out.println(findContiguousHistory(user3, user6));


    }

    public static List<String> findContiguousHistory(String [] array1 , String [] array2){

        String [] longArray = array1;
        String [] shortArray = array2;


        if(array1.length < array2.length){
            shortArray = array1;
            longArray = array2;
        } else {
            shortArray = array2;
            longArray = array1;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<longArray.length; i++){
            map.put(longArray[i],i);
        }

        List<String> result = new ArrayList<>();

        for(int i=0; i<shortArray.length; i++){
            List<String> curr = new ArrayList<>();
            String str = shortArray[i];
            if(map.containsKey(str)){
                int index = map.get(str);
                int k = i;
                while(index < longArray.length && k< shortArray.length){
                    if(longArray[index].equalsIgnoreCase(shortArray[k])){
                        curr.add(shortArray[k]);
                    } else break;
                    index++;
                    k++;
                }
                if(result.size() < curr.size()){
                    result = curr;
                }
            }
        }

        return result;
    }
}
