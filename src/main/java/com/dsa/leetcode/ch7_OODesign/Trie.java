package com.dsa.leetcode.ch7_OODesign;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    /** Initialize your data structure here. */
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts PowerOfTwo word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchWord(word);
        return node != null && node.isEndOfWord;
    }


    public TrieNode searchWord(String word) {
        TrieNode curr = root;
        for(Character c: word.toCharArray()){
            if(!curr.neighbours.containsKey(c)){
                return null;
            }
            curr = curr.neighbours.get(c);
        }
        return curr;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchWord(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        //[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
        t.insert("app");
        System.out.println(t.search("app"));
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
