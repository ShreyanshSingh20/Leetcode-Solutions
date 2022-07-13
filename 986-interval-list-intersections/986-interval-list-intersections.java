class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int n=firstList.length;
        int m=secondList.length;
        
        List<int[]> res=new ArrayList<>();
        
        int i=0;int j=0;
        while(i<n&&j<m){
            int start1=firstList[i][0];int end1=firstList[i][1];
            int start2=secondList[j][0];int end2=secondList[j][1];
            // System.out.println(i+" "+j);
            if(end1>=start2&&end2>=start1){//intersection is possible
                int left=Math.max(start1,start2);
                int right=Math.min(end1,end2);
                res.add(new int[]{left,right});
                if(end1>=end2) j++;
                else if(end1<end2) i++;
            }else if(end1>=end2) j++;
            else i++;
            
        }
        
        int mat[][]=new int[res.size()][2];
        for(int k=0;k<mat.length;k++){
            mat[k][0]=res.get(k)[0];
            mat[k][1]=res.get(k)[1];
        }
        
        return mat;
    }
}