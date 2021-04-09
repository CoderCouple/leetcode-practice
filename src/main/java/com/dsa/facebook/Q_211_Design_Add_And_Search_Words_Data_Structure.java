package com.dsa.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q_211_Design_Add_And_Search_Words_Data_Structure {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");
        System.out.println(dict.search("PowerOfTwo"));
        System.out.println(dict.search(".at"));
        dict.addWord("bat");
        System.out.println(dict.search(".at"));
        System.out.println(dict.search("an."));
        System.out.println(dict.search("PowerOfTwo.d."));
        System.out.println(dict.search("b."));
        System.out.println(dict.search("PowerOfTwo.d"));
        System.out.println(dict.search("."));
    }
}
class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(Character c : word.toCharArray()){
            if(curr.neighbours.containsKey(c)){
                curr = curr.neighbours.get(c);
            } else {
                TrieNode node = new TrieNode();
                curr.neighbours.put(c,node);
                curr = node;
            }
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        char [] array = word.toCharArray();
        for(int i=0; i<array.length; i++){
            if(array[i] =='.'){
                return searchWildCard(word, curr, i);
            } else if(!curr.neighbours.containsKey(array[i])){
                return false;
            }
            curr = curr.neighbours.get(array[i]);
        }
        return curr != null && curr.isEndOfWord;
    }

    public boolean searchWildCard(String  word, TrieNode curr, int index ) {
        if(index >= word.length())
            return curr.isEndOfWord;

        if(word.charAt(index) == '.'){
            boolean result = false;
            for(TrieNode node : curr.neighbours.values()){
                result = result || searchWildCard(word, node, index+1);
            }
            return result;
        } else if(curr.neighbours.containsKey(word.charAt(index))){
            return searchWildCard(word,curr.neighbours.get(word.charAt(index)),index+1);
        }

        return false;
    }
}

class TrieNode{
    Map<Character,TrieNode> neighbours;
    boolean isEndOfWord;

    public TrieNode() {
        this.neighbours = new HashMap<>();
        isEndOfWord = false;
    }
}
