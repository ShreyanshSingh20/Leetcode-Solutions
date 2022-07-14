class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        return solver(arr,k)-solver(arr,k-1);
    }
    
    public int solver(int arr[],int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;int res=0;
        for(int r=0;r<arr.length;r++){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size()>k){
                int freq=map.get(arr[l]);
                if(freq==1) map.remove(arr[l]);
                else map.put(arr[l],freq-1);
                l++;
            }
            res+=(r-l+1);
        }
        return res;
    }
}