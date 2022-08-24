class Solution {
    public int getMaxLen(int[] arr) {
        
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;int lastZero=-1;
        
        int prod=1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                prod=1;
                lastZero=i;
                map.clear();
                continue;
            }
            
            if(arr[i]>0) prod*=1;
            else if(arr[i]<0) prod*=-1;
            
            if(prod>0){
                if(lastZero==-1) res=Math.max(res,i+1);
                else res=Math.max(res,i-lastZero);
            }else if(prod<0){
                if(map.containsKey(prod)){
                    int ind=map.get(prod);
                    res=Math.max(res,i-ind);
                }else{
                    map.put(prod,i);
                }
            }
        }
        
        return res;
    }
}