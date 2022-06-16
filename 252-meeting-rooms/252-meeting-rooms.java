class Solution {
    public boolean canAttendMeetings(int[][] mat) {
        int n=mat.length;
        Arrays.sort(mat,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        
        int maxEndTime=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int start=mat[i][0];
            int end=mat[i][1];
            if(start<maxEndTime) return false;
            maxEndTime=Math.max(maxEndTime,end);
        }
        
        return true;
    }
}