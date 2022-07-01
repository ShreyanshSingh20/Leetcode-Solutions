class Solution {
    public int maximumUnits(int[][] arr, int truckSize) {
        int n=arr.length;
        double mat[][]=new double[n][3];
        for(int i=0;i<n;i++){
            mat[i][0]=(double)arr[i][0];
            mat[i][1]=(double)arr[i][1];
            mat[i][2]=((double)arr[i][0])/((double)(arr[i][0]*arr[i][1]));
        }
        
        Arrays.sort(mat,(a,b)->Double.compare(a[2],b[2]));
        
        double res=0;
        for(int i=0;i<n;i++){
            if(truckSize==0) break;
            int numOfBoxes=(int)mat[i][0];
            int points=(int)mat[i][1];
            if(numOfBoxes<=truckSize){
                truckSize-=numOfBoxes;
                res+=numOfBoxes*points;
            }else{
                res+=truckSize*points;
                truckSize=0;
            }
        }
        
        return (int)res;
    }
}