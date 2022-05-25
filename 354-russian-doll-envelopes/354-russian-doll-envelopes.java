class Solution {
    public int maxEnvelopes(int[][] env) {
        int n = env.length;
		Arrays.sort(env, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
		List<Integer> sub=new ArrayList<>();
        sub.add(env[0][1]);
        
        for(int i=1;i<n;i++){
            int h=env[i][1];
            if(h>sub.get(sub.size()-1)){
                sub.add(h);
            }else{
                int j=binarySearch(sub,h);
                sub.set(j,h);
            }
        }
        
        return sub.size();
    }
    
    public int binarySearch(List<Integer> sub,int h){
        int left=0;
        int right=sub.size()-1;
        
        while(left<right){
            int mid=left+(right-left)/2;
            if(sub.get(mid)==h) return mid;
            if(sub.get(mid)<h) left=mid+1;
            else right=mid;
        }
        return left;
    }
}