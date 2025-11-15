package DFSAndBFS.RottingOranges;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length ; c++){
                if(grid[r][c] == 1){
                    freshOranges++;
                }
                if(grid[r][c] == 2){
                    q.add(new int[] {r, c});
                }
            }
        }
        int time = 0;
        while(!q.isEmpty() && freshOranges > 0){
            int len = q.size();
            int[][] fourDir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int i = 0; i < len; i++){
                int[] first = q.poll();
                int r = first[0];
                int c = first[1];
                for(int[] options : fourDir){
                    int row = r + options[0];
                    int col = c + options[1];
                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1){
                        continue;
                    }
                    grid[row][col] = 2;
                    q.add(new int[] {row, col});
                    freshOranges--;
                }
            }
            time += 1;
        }
        if(freshOranges > 0){
            return -1;
        }
        return time;
    }


}