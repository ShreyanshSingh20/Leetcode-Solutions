class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;int m=nums2.length;
        List<List<Integer>> res=new ArrayList<>();
        long limit=Math.min(k,(long)n*(long)m);
        k=(int)limit;
        for(int i=0;i<k;i++){
            res.add(new ArrayList<>());
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        for(int i=0;i<m;i++){
            pq.add(new int[]{0,i,nums1[0]+nums2[i]});
        }
        int pt=0;
        while(k>0){
            int curr[]=pq.poll();
            // System.out.println(curr[0]+" "+curr[1]+" "+curr[2]);
            res.get(pt).add(nums1[curr[0]]);
            res.get(pt).add(nums2[curr[1]]);
            if(curr[0]+1<n){
                pq.add(new int[]{1+curr[0],curr[1],nums1[1+curr[0]]+nums2[curr[1]]});
            }
            k--;
            pt++;
        }
        
        return res;
    }
}