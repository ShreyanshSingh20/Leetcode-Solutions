class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        
        int n=arr.length;
        int psum[]=new int[n];
        psum[0]=arr[0];
        for(int i=1;i<n;i++) psum[i]=psum[i-1]+arr[i];
        for(int i=0;i<n;i++){
            psum[i]=psum[i]%k;
            if(psum[i]<0){
                psum[i]=(psum[i]+k);
            }
        }
        
        // for(int x:psum) System.out.print(x+" ");
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int res=0;
        for(int i=0;i<n;i++){
            // if(psum[i]==0) {res++; continue;}
            if(map.containsKey(psum[i])){
                res+=map.get(psum[i]);
            }
            map.put(psum[i],map.getOrDefault(psum[i],0)+1);
        }
        
        return res;
        
    }
}