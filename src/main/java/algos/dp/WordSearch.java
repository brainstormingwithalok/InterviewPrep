package main.java.algos.dp;

/*
https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        //Expected->true
        String word = "ABCCED";
        System.out.println(exist(board, word));
        //Expected false
        String word1 = "ABBASGSAG";
        System.out.println(exist(board, word1));

    }


    public static boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && isPresent(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return result;
    }


    public static boolean isPresent(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = isPresent(board, i, j + 1, count + 1, word) ||
                isPresent(board, i, j - 1, count + 1, word) ||
                isPresent(board, i + 1, j, count + 1, word) ||
                isPresent(board, i - 1, j, count + 1, word);
        board[i][j] = temp;
        return found;
    }

}
