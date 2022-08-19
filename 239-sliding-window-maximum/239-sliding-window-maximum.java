class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        List<Integer> res=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int n=arr.length;
        int l=0;int r=0;
        for(r=0;r<n;r++){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(r-l+1>k){
                int freq=map.get(arr[l]);
                if(freq==1) map.remove(arr[l]);
                else map.put(arr[l],freq-1);
                l++;
            }
            if(r-l+1==k){
                res.add(map.lastKey());
            }
        }
        
        int ans[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        
        return ans;
    }
}