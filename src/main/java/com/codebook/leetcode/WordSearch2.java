package com.codebook.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordSearch2 {
    static class Trie {
        Trie[] children = new Trie[26];
        boolean endOfWord = false;
        String word;

        public void insert(String word){
            Trie curr = this;
            for(char ch : word.toCharArray()){
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new Trie();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.endOfWord = true;
            curr.word = word;
        }

        @Override
        public String toString() {
            return "Trie{" +
                   "children=" + Arrays.toString(children) +
                   ", endOfWord=" + endOfWord +
                   '}';
        }
    }

    private List<String> searchWords(char[][] matrix, String[] words){
        List<String> result = new LinkedList<>();
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                dfs(matrix, i, j, trie, result);
            }
        }
        return result;
    }

    private void dfs(char[][] matrix, int i, int j, Trie trie, List<String> result){
        if (i < 0 || j < 0 || i >= matrix[0].length || j >= matrix.length || trie.children[matrix[i][j] - 'a'] == null) {
            return;
        }

        if(trie.children[matrix[i][j] - 'a'].endOfWord){
            result.add(trie.children[matrix[i][j] - 'a'].word);
            return;
        }

        dfs(matrix, i+1, j, trie.children[matrix[i][j] - 'a'], result);
        dfs(matrix, i, j+1, trie.children[matrix[i][j] - 'a'], result);
        dfs(matrix, i-1, j, trie.children[matrix[i][j] - 'a'], result);
        dfs(matrix, i, j-1, trie.children[matrix[i][j] - 'a'], result);
        dfs(matrix, i+1, j+1, trie.children[matrix[i][j] - 'a'], result);
        dfs(matrix, i-1, j-1, trie.children[matrix[i][j] - 'a'], result);
    }

    public static void main(String[] args) {
        char[][] matrix = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        WordSearch2 wordSearch = new WordSearch2();
        System.out.println(wordSearch.searchWords(matrix, words));
    }
}
