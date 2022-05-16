class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n=tiles.length;
        Arrays.sort(tiles,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        
        int pt=0;
        int currMax=0;
        int ans=0;
        
        for(int i=0;i<n;i++){
            int end=tiles[i][0]+carpetLen-1;
            
            while(pt<n&&tiles[pt][1]<end){
                currMax+=(tiles[pt][1]-tiles[pt][0])+1;
                pt++;
            }
            
            if(pt==n||tiles[pt][0]>end){
                ans=Math.max(ans,currMax);
            }else{
                ans=Math.max(ans,currMax+end-tiles[pt][0]+1);
            }
            
            currMax-=(tiles[i][1]-tiles[i][0]+1);
        }
        
        return ans;
        
    }
}