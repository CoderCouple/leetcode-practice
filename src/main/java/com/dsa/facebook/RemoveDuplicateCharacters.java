package com.dsa.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateCharacters {


    // TC: O(n)
    // SC: O(n)
    List<String> removeDuplicates(List<String> input) {
        if (input == null) {
            return null;
        }
        List<String> output = new ArrayList<String>();
        Set<String> hash = new HashSet(input.size());
        for (String s : input) {
            if (!hash.contains(s)) {
                hash.add(s);
                output.add(s);
            }
        }
        return output;
    }
}
