class Solution {
    public boolean makesquare(int[] arr) {
        
        int n=arr.length;
        int limit=(1<<n)-1;
        
        int sideLen=0;
        for(int x:arr) sideLen+=x;
        
        List<Integer> usedMasks=new ArrayList<>();
        
        HashMap<Integer,Boolean> map=new HashMap<>();
        
        if(sideLen%4!=0) return false;
        sideLen=sideLen/4;
        
        for(int i=0;i<=limit;i++){
            int mask=i;
            int subsetSum=0;
            for(int bit=0;bit<n;bit++){
                if((mask&(1<<bit))!=0) subsetSum+=arr[bit];
            }
            
            if(subsetSum==sideLen){
                for(int j=0;j<usedMasks.size();j++){
                    int usedMask=usedMasks.get(j);
                    if((usedMask&mask)==0){
                        int halfMask=usedMask|mask;
                        map.putIfAbsent(halfMask,true);
                        int xor=limit^halfMask;
                        if(map.containsKey(xor)&&map.get(xor)==true) return true;
                    }
                }
                usedMasks.add(mask);
            }
        }
        
        return false;
    }
}