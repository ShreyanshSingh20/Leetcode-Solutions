class Solution {
    public int wiggleMaxLength(int[] arr) {
        int n=arr.length;
        int dpUp[]=new int[n];
        int dpDown[]=new int[n];
        Arrays.fill(dpUp,Integer.MIN_VALUE);
        Arrays.fill(dpDown,Integer.MIN_VALUE);
        dpUp[0]=dpDown[0]=1;
        
        int res=1;
        
        for(int i=1;i<n;i++){
          
            //considering this element is a peak up element
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&dpDown[j]!=Integer.MIN_VALUE){
                    dpUp[i]=Math.max(dpUp[i],1+dpDown[j]);
                }
            }
            
            //considering this element is a peak down element
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]&&dpUp[j]!=Integer.MIN_VALUE){
                    dpDown[i]=Math.max(dpDown[i],1+dpUp[j]);
                }
            }
            
            res=Math.max(res,Math.max(dpUp[i],dpDown[i]));
        }
        
        return res;
    }
}