package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//You can copy this directly into coderpad
//         2---4
//        /\
//       1  \
//       \   \
//        3---5---6
//
//        getFriends(1) --> [2, 3]
//        getFriends(4) --> [2]
//
//        getMutualFriends(1, 4) --> [2]
//        getMutualFriends(1, 5) --> [2, 3]
//        getMutualFriends(1, 6) --> []
//
//        getPYMK(1) --> [5, 4]
//        getPYMK(5) --> [1, 4]


public class FriendOfFriend {

    public List<Integer> getFriends(int id) {
        List<Integer> result = new ArrayList<>();
        switch (id) {
            case 1 : result = Arrays.asList(2, 3); break;
            case 2 : result = Arrays.asList(1, 4, 5); break;
            case 3 : result = Arrays.asList(1, 5); break;
            case 4 : result = Arrays.asList(2); break;
            case 5 : result = Arrays.asList(2, 3, 6);break;
            case 6 : result = Arrays.asList(5); break;
        }
        return result;
    }

    public  List<Integer> getMutualFriends(int id1, int id2){
        List<Integer> mutualFriends = new ArrayList<>();
        Set<Integer> friendSet1 = new HashSet<>(getFriends(id1));
        for(int id: getFriends(id2))
            if(friendSet1.contains(id))
                mutualFriends.add(id);

        return mutualFriends;
    }

    public  List<Integer> getPotentialFriends(int id){
        List<Integer> potentialFriends = new ArrayList<>();

        return potentialFriends;
    }

    public static void main(String[] args) {
        FriendOfFriend obj = new FriendOfFriend();

        //getFriends
        System.out.println(obj.getFriends(1));
        System.out.println(obj.getFriends(4));
        System.out.println("=====================");

        //getMutualFriends
        System.out.println(obj.getMutualFriends(1,4));
        System.out.println(obj.getMutualFriends(1,5));
        System.out.println(obj.getMutualFriends(1,6));
        System.out.println("=====================");

        //getPotentialFriends
        System.out.println(obj.getPotentialFriends(1));
        System.out.println(obj.getPotentialFriends(5));

    }
}
