class Solution {
    public int catMouseGame(int[][] graph) {
        int n=graph.length;
        int dp[][][]=new int[n+1][n+1][5*n+1];
        for(int x[][]:dp){
            for(int y[]:x){
                Arrays.fill(y,-1);
            }
        }
        
        return solver(graph,1,2,0,dp);
    }
    
    public int solver(int mat[][],int mousePos,int catPos,int time,int dp[][][]) {
		
		if(time==5*mat.length) return 0;
		if(mousePos==0) return dp[mousePos][catPos][time]=1;
		if(catPos==mousePos) return dp[mousePos][catPos][time]=2;
		
		if(dp[mousePos][catPos][time]!=-1) return dp[mousePos][catPos][time];
		
		int turn=time%2;
		
		
		if(turn==0) {//mouse's turn
			boolean flag=true;//cat wins
			for(int i=0;i<mat[mousePos].length;i++) {
				int ans=solver(mat, mat[mousePos][i], catPos, time+1, dp);
				if(ans==1) return dp[mousePos][catPos][time]=1;
				else if(ans!=2) flag=false;
			}
			if(flag) return dp[mousePos][catPos][time]=2;
			else return dp[mousePos][catPos][time]=0;
		}else {//cat's turn
			boolean flag=true;//mouse wins
			for(int i=0;i<mat[catPos].length;i++) {
                if(mat[catPos][i]==0) continue;
				int ans=solver(mat, mousePos, mat[catPos][i], time+1, dp);
				if(ans==2) return dp[mousePos][catPos][time]=2;
				else if(ans!=1) flag=false;
			}
			if(flag) return dp[mousePos][catPos][time]=1;
			else return dp[mousePos][catPos][time]=0;
		}
		
	}
}