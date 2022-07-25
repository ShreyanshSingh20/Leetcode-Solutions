class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        HashSet<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);
        
        int cnt[]=new int[33];
        
        long res=0;
        
        Iterator e=set.iterator();
        while(e.hasNext()){
            int num=(int)e.next();
            int numOfSetBits=0;
            for(int bit=0;bit<32;bit++){
                if(isSet(num,bit)) numOfSetBits++;
            }
            cnt[numOfSetBits]++;
        }
        
        for(int i=0;i<=32;i++){
            if(cnt[i]>0&&2*i>=k) res+=((long)cnt[i]*cnt[i]);
            for(int j=i+1;j<=32;j++){
                if(cnt[i]==0||cnt[j]==0) continue;
                if(i+j>=k){
                    res+=((long)2*(long)cnt[i]*(long)cnt[j]);
                }
            }
        }
        
        return res;
    }
    
    public boolean isSet(int num,int bit){
        return (num&(1<<bit))!=0?true:false;
    }
}