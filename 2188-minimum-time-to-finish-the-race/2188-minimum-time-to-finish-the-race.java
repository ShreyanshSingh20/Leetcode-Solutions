class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        long bestTime[]=new long[1001];
        Arrays.fill(bestTime,Long.MAX_VALUE);
        
        int maxLaps=Integer.MIN_VALUE;
        for(int x[]:tires){
            int fi=x[0];
            int ri=x[1];
            long currLapTime=fi;
            long time=fi;
            for(int lap=1;lap<=numLaps&&currLapTime<changeTime+fi;lap++){
                if(time<bestTime[lap]){
                    bestTime[lap]=time;
                }
                
                maxLaps=Math.max(maxLaps,lap);
                currLapTime*=ri;
                time+=currLapTime;
            }
        }
        
        Long dp[]=new Long[numLaps+1];
        return (int)solver(numLaps,maxLaps,bestTime,changeTime,dp);
    }
    
    public long solver(int numLaps,int maxLaps,long bestTime[],int changeTime,Long dp[]){
        
        if(numLaps==0){
            return -1*changeTime;
        }
        
        if(dp[numLaps]!=null) return dp[numLaps];
        
        long res=Long.MAX_VALUE;
        for(int lap=1;lap<=Math.min(numLaps,maxLaps);lap++){
            long mini=bestTime[lap]+changeTime+solver(numLaps-lap,maxLaps,bestTime,changeTime,dp);
            res=Math.min(res,mini);
        }
        
        return dp[numLaps]=res;
    }
}