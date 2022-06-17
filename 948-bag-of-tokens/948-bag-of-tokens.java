class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        int l=0;int r=n-1;
        Arrays.sort(tokens);
        int score=0;int maxScore=0;
        while(l<=r){
            if(power>=tokens[l]){
                power-=tokens[l];
                score++;
                l++;
            }else if(score>=1){
                power+=tokens[r];
                score--;
                r--;
            }else{
                break;
            }
            maxScore=Math.max(score,maxScore);
        }
        
        return maxScore;
    }
}