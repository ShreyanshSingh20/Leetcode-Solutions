class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int r=mat.length;
        int c=mat[0].length;
        
        PriorityQueue<int[]> pq=new 
            PriorityQueue<>((a,b)->(a[0]-b[0]));
        
        for(int i=0;i<c;i++){
            pq.add(new int[]{mat[0][i],0,i});
        }
        
        k--;
        while(k>0){
            int curr[]=pq.poll();
            int row=curr[1];int col=curr[2];
            if(row+1<r) pq.add(new int[]{mat[row+1][col],row+1,col});
            k--;
        }
        
        return pq.poll()[0];
    }
}