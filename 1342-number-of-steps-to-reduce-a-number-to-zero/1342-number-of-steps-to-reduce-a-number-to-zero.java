class Solution {
    public int numberOfSteps(int num) {
        String str = Integer.toBinaryString(num);
        char c[]=str.toCharArray();
        int res=0;
        for(int bit=c.length-1;bit>=0;bit--){
            if(c[bit]=='1') res+=2;
            else res++;
        }
        return res-1;
    }
    
   
}