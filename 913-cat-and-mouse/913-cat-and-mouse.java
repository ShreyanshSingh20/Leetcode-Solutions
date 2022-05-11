class Solution {
    int[][][] dp;
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        dp = new int[4*n][n][n];
        for(int i=0; i<dp.length; i++) for(int j=0;  j<dp[0].length; j++) Arrays.fill(dp[i][j],-1);
        return seach(graph, 0, 1,2);
    }
    // t is which step, x is mouse location, y is cat location
    int seach(int[][] graph, int t, int x, int y){
        if (t == graph.length * 4) return 0;
        if (x == y) return dp[t][x][y] = 2;
        if (x == 0) return dp[t][x][y] = 1;
        if (dp[t][x][y] != -1) return dp[t][x][y];
         int who = t % 2;
         boolean flag;
        if (who == 0) { // mouse's turn
            flag = true; // by default, is cat win
            for (int i = 0; i < graph[x].length; i++) {
                int nxt = seach(graph, t + 1, graph[x][i], y);
                if (nxt == 1) return dp[t][x][y] = 1;
                else if (nxt != 2) flag = false;
            }
            if (flag) return dp[t][x][y] = 2;
            else return dp[t][x][y] = 0;
        }
        else { // cat's turn
            flag = true; // by default is mouse win
            for (int i = 0; i < graph[y].length; i++)
                if (graph[y][i] != 0) {
                    int nxt = seach(graph, t + 1, x, graph[y][i]);
                    if (nxt == 2) return dp[t][x][y] = 2;
                    else if (nxt != 1) flag = false;
                }
            if (flag) return dp[t][x][y] = 1;
            else return dp[t][x][y] = 0;
        }
    }
}