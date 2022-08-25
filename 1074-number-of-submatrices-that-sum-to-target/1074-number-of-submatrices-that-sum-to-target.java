class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int r=matrix.length;
        int c=matrix[0].length;
        
        int psum[][]=new int[r+1][c+1];
        for(int i=1;i<r+1;i++){
            for(int j=1;j<c+1;j++){
                psum[i][j]=(matrix[i-1][j-1]+psum[i-1][j]+psum[i][j-1])-psum[i-1][j-1];
            }
        }
        
        // for(int i=0;i<=r;i++){
        //     for(int j=0;j<=c;j++){
        //         System.out.print(psum[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int r1=1;r1<r+1;r1++){
            for(int r2=1;r2<=r1;r2++){
                map.clear();
                for(int j=1;j<c+1;j++){
                    int sum=psum[r1][j]-psum[r2-1][j];
                    int sub=sum-target;
                    if(map.containsKey(sub)){
                        res+=map.get(sub);
                    }
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
                if(map.containsKey(target)) res+=map.get(target);
            }
        }
        
        return res;
    }
}