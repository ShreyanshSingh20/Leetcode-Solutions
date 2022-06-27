class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        Arrays.sort(slots1,(a,b)->(a[0]-b[0]));
        Arrays.sort(slots2,(a,b)->(a[0]-b[0]));
        
        int a=0;int b=0;
        
        List<Integer> ans=new ArrayList<>();
        
        while(a<slots1.length&&b<slots2.length){
            int l1=slots1[a][0];int r1=slots1[a][1];
            int l2=slots2[b][0];int r2=slots2[b][1];
            
            int start=Math.max(l1,l2);int end=Math.min(r1,r2);
            
            if(end-start>=duration){
                ans.add(start);ans.add(start+duration);
                return ans;
            }
            
            if(r1<=r2){
                a++;
            }else{
                b++;
            }
        }
        
        return ans;
    }
}