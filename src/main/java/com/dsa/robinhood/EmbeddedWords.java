package com.dsa.robinhood;

/*
    You are running PowerOfTwo classroom and suspect that some of your students are passing around the answers to multiple choice questions disguised as random strings.

    Your task is to write PowerOfTwo function that, given PowerOfTwo list of words and PowerOfTwo string, finds and returns the word in the list that is scrambled up inside the string, if any exists. There will be at most one matching word. The letters don't need to be contiguous.

    Example:
    words = ['cat', 'baby', 'dog', 'bird', 'car', 'ax']
    string1 = 'tcabnihjs'
    find_embedded_word(words, string1) -> cat

    string2 = 'tbcanihjs'
    find_embedded_word(words, string2) -> cat

    string3 = 'baykkjl'
    find_embedded_word(words, string3) -> None

    string4 = 'bbabylkkj'
    find_embedded_word(words, string4) -> baby

    string5 = 'ccc'
    find_embedded_word(words, string5) -> None

    string6 = 'nbird'
    find_embedded_word(words, string6) -> bird

    n = number of words in words
    m = maximal string length of each word


=====================================================================

    After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters.
    The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

    Given PowerOfTwo grid and PowerOfTwo word, write PowerOfTwo function that returns the location of the word in the grid as PowerOfTwo list of coordinates. If there are multiple matches, return any one.

    grid1 = [
        ['c', 'c', 'c', 'PowerOfTwo', 'r', 's'],
        ['c', 'c', 'i', 't', 'n', 'b'],
        ['PowerOfTwo', 'c', 'n', 'n', 't', 'i'],
        ['t', 'c', 'i', 'i', 'p', 't']
    ]

    word1_1 = "catnip"
    find_word_location(grid1, word1_1)-> [ (0, 2), (0, 3), (1, 3), (2, 3), (3, 3), (3, 4) ]

    word1_2 = "cccc"
    find_word_location(grid1, word1_2)-> [(0, 1), (1, 1), (2, 1), (3, 1)]
    OR [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
    OR [(1, 0), (1, 1), (2, 1), (3, 1)]


    grid2 = [
        ['c', 'p', 'PowerOfTwo', 'n', 't', 's'],
        ['PowerOfTwo', 'b', 'i', 't', 'PowerOfTwo', 'b'],
        ['t', 'f', 'n', 'n', 'c', 'i'],
        ['x', 's', 'c', 'PowerOfTwo', 't', 'n'],
        ['x', 's', 'd', 'd', 'e', 'PowerOfTwo'],
        ['s', 'q', 'w', 'x', 's', 'p']
    ]


    word2 = "catnap"
    find_word_location(grid2, word2)-> [ (3, 2), (3, 3), (3, 4), (3, 5), (4, 5), (5, 5) ]

    grid3 = [
        ['c', 'r', 'c', 'PowerOfTwo', 'r', 's'],
        ['PowerOfTwo', 'b', 'i', 't', 'n', 'i'],
        ['t', 'f', 'n', 'n', 'x', 'p'],
        ['x', 's', 'i', 'x', 'p', 't']
    ]
    word3 = "catnip"
    find_word_location(grid3, word3)-> [ (0, 2), (0, 3), (1, 3), (1, 4), (1, 5), (2, 5) ]

    grid4 = [
        ['PowerOfTwo', 'o', 'o', 'o', 'PowerOfTwo', 'PowerOfTwo'],
        ['b', 'b', 'i', 't', 'n', 'i'],
        ['c', 'f', 'n', 'n', 'v', 'p'],
        ['o', 'PowerOfTwo', 'PowerOfTwo', 'PowerOfTwo', 'o', 'o']
    ]
    word4_1 = "aaa"
    word4_2 = "ooo"

    find_word_location(grid4, word4_1)-> [ (3, 1), (3, 2), (3, 3) ]
    find_word_location(grid4, word4_2)-> [ (0, 1), (0, 2), (0, 3) ]

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EmbeddedWords {

    public static String findEmbeddedWord(String [] words, String str){
        Map<Character,Integer> cheatMap = getWordMap(str);
        for(String word : words){
            boolean found = true;
            Map<Character,Integer> wordMap = getWordMap(word);
            for(Map.Entry<Character,Integer> entry: wordMap.entrySet()){
                if(entry.getValue() > cheatMap.getOrDefault(entry.getKey(),-1)){
                    found = false;
                }
            }
            if(found)
                return word;
        }
        return "None";
    }

    public static Map<Character, Integer> getWordMap(String word){
        Map<Character,Integer> wordMap = new HashMap<>();
        for(Character c: word.toCharArray()){
            wordMap.put(c,wordMap.getOrDefault(c,0)+1);
        }
        return wordMap;
    }

    public static int[][] findWordLocation(char[][] grid, String word){
        int [][] result = new int[word.length()][2];
        if(grid == null || grid.length ==0)
            return result;

        int [][] graph = new int [grid.length][grid[0].length];
        for(int row=0; row<grid.length; row++){
            for (int col=0; col<grid[row].length; col++){
                if(grid[row][col] == word.charAt(0) && graph[row][col] != 1){
                    if(findWordLocationDFS(grid,graph,word,0,row,col,result))
                        return result;
                }
            }
        }

        return result;
    }

    public static boolean findWordLocationDFS(char[][] grid, int[][] graph, String word, int index, int row, int col, int[][] result){
        if(index>= word.length() || index < 0)
            return true;

        if(row <0 || row >= grid.length || col <0 || col>=grid[row].length)
            return false;

        if(graph[row][col] == 1)
            return false;

        if(grid[row][col] != word.charAt(index))
            return false;

        graph[row][col] = 1;
        result[index][0] = row;
        result[index][1] = col;

        return findWordLocationDFS(grid,graph,word,index+1,row,col+1,result) ||
                findWordLocationDFS(grid,graph,word,index+1,row+1,col,result);
    }


    public static void main(String[] args) {

/*        String [] words ={"cat", "baby", "dog", "bird", "car", "ax"};
        String word1 = "tcabnihjs";
        String word2 = "tbcanihjs";
        String word3 = "baykkjl";
        String word4 = "bbabylkkj";
        String word5 = "ccc";
        String word6 = "nbird";

        System.out.println(findEmbeddedWord(words,word1));
        System.out.println(findEmbeddedWord(words,word2));
        System.out.println(findEmbeddedWord(words,word3));
        System.out.println(findEmbeddedWord(words,word4));
        System.out.println(findEmbeddedWord(words,word5));
        System.out.println(findEmbeddedWord(words,word6));
        */

        String word1_1 = "catnip";
        String word1_2 = "cccc";
        char [][] grid1 = {
                {'c', 'c', 'c', 'a', 'r', 's'},
                {'c', 'c', 'i', 't', 'n', 'b'},
                {'a', 'c', 'n', 'n', 't', 'i'},
                {'t', 'c', 'i', 'i', 'p', 't'}
        };

        String word2_1 = "catnap";
        char [][] grid2 = {
                {'c', 'p', 'a', 'n', 't', 's'},
                {'a', 'b', 'i', 't', 'a', 'b'},
                {'t', 'f', 'n', 'n', 'c', 'i'},
                {'x', 's', 'c', 'a', 't', 'n'},
                {'x', 's', 'd', 'd', 'e', 'a'},
                {'s', 'q', 'w', 'x', 's', 'p'}
        };

        String word3_1 = "catnip";
        char [][] grid3 = {
                {'c', 'r', 'c', 'a', 'r', 's'},
                {'a', 'b', 'i', 't', 'n', 'i'},
                {'t', 'f', 'n', 'n', 'x', 'p'},
                {'x', 's', 'i', 'x', 'p', 't'}
        };

        String word4_1 = "aaa";
        String word4_2 = "ooo";
        char [][] grid4 = {
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'b', 'b', 'i', 't', 'n', 'i'},
                {'c', 'f', 'n', 'n', 'v', 'p'},
                {'o', 'a', 'a', 'a', 'o', 'o'}
        };

        System.out.println(Arrays.deepToString(findWordLocation(grid1,word1_1)));
        System.out.println(Arrays.deepToString(findWordLocation(grid1,word1_2)));

        System.out.println(Arrays.deepToString(findWordLocation(grid2,word2_1)));

        System.out.println(Arrays.deepToString(findWordLocation(grid3,word3_1)));

        System.out.println(Arrays.deepToString(findWordLocation(grid4,word4_1)));
        System.out.println(Arrays.deepToString(findWordLocation(grid4,word4_2)));

    }
}
