package com.zjh.medium;

import java.util.*;

public class NumIslands200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };
        int i = new NumIslands200().numIslands(grid);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        //bfs
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

            }
        }


        //dfs
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == '1') {
//                    res++;
//                    dfs(grid, row, col, i, j);
//                }
//            }
//        }
        return res;
    }


    public void dfs(char[][] grid, int row, int col, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }
        dfs(grid, row, col, i + 1, j);
        dfs(grid, row, col, i - 1, j);
        dfs(grid, row, col, i, j + 1);
        dfs(grid, row, col, i, j - 1);
    }
}
