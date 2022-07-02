class Solution {
    
    public long mod=1_000_000_007;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        //getting the max horizontal length
        long maxHoz=Long.MIN_VALUE;
        int lenHoz=horizontalCuts.length;
        for(int i=0;i<lenHoz;i++){
            if(i==0){
                maxHoz=Math.max(maxHoz,horizontalCuts[i]);
                continue;
            }
            maxHoz=Math.max(maxHoz,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        maxHoz=Math.max(maxHoz,h-horizontalCuts[lenHoz-1]);
        
        //getting the max vertical length
        long maxVer=Long.MIN_VALUE;
        int lenVer=verticalCuts.length;
        for(int i=0;i<lenVer;i++){
            if(i==0){
                maxVer=Math.max(maxVer,verticalCuts[i]);
                continue;
            }
            maxVer=Math.max(maxVer,verticalCuts[i]-verticalCuts[i-1]);
        }
        maxVer=Math.max(maxVer,w-verticalCuts[lenVer-1]);
        
        // System.out.println(maxHoz+" "+maxVer);
        
        return (int)mul(maxHoz,maxVer);
    }
    
    public long mul(long x,long y){
        return (x*y)%mod;
    }
}