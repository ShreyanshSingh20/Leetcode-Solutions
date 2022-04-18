class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int r=mat.length;
        int c=mat[0].length;
        int psum[][]=new int[r+1][c+1];
        psum[1][1]=mat[0][0];
       
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                psum[i][j]=mat[i-1][j-1]+(psum[i-1][j]+psum[i][j-1]-psum[i-1][j-1]);
            }
        }
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int r1=1;r1<=r;r1++){
            for(int r2=1;r2<=r1;r2++){
                map.clear();
                for(int col=1;col<=c;col++){
                    int subMatSum=psum[r1][col]-psum[r2-1][col];
                    if(subMatSum==target) cnt++;
                    int key=subMatSum-target;
                    if(map.containsKey(key)){
                        cnt+=map.get(key);
                    }
                    map.putIfAbsent(subMatSum,0);
                    map.put(subMatSum,map.get(subMatSum)+1);
                }
            }
        }
        
        return cnt;
    }
}