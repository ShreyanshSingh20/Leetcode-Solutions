class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;int maxScore=0;int currScore=0;
        for(int r=0;r<n;r++){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            currScore+=arr[r];
            while(map.size()!=r-l+1){
                currScore-=arr[l];
                int freq=map.get(arr[l]);
                if(freq==1) map.remove(arr[l]);
                else map.put(arr[l],freq-1);
                l++;
            }
            maxScore=Math.max(maxScore,currScore);
        }
        
        return maxScore;
    }
}