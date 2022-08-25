class Solution {
    public int longestSubarray(int[] arr, int limit) {
        
        int n=arr.length;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int l=0;int r=0;int res=1;
        for(r=0;r<n;r++){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            
            while(!map.isEmpty()&&Math.abs(map.firstKey()-map.lastKey())>limit&&l<r){
                int toRemove=arr[l];
                l++;
                int freq=map.get(toRemove);
                if(freq==1) map.remove(toRemove);
                else map.put(toRemove,freq-1);
            }
            
            res=Math.max(res,r-l+1);
        }
        
        return res;
    }
}