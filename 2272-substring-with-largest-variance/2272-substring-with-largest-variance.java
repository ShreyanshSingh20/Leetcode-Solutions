/*https://leetcode.com/problems/substring-with-largest-variance/discuss/2038774/C++-O(1)-space-complexity-Kadane's-for-each-pair-of-characters
*/
class Solution {
    public int largestVariance(String s) {
        char c[]=s.toCharArray();
        
        int res=0;
        
        for(char highFreq='a';highFreq<='z';highFreq++){
            for(char lowFreq='a';lowFreq<='z';lowFreq++){
                // if(highFreq==lowFreq) continue;
                
                int hf=0;int lf=0;int ans=0;boolean abandoned=false;
                for(char ch:c){
                    if(ch==highFreq) hf++;
                    else if(ch==lowFreq) lf++;
                    
                    if(lf>0){
                        ans=Math.max(ans,hf-lf);
                    }else{
                        if(abandoned){
                            ans=Math.max(ans,hf-1);
                        }
                    }
                    
                    if(lf>hf){
                        lf=0;hf=0;abandoned=true;
                    }
                }
                res=Math.max(res,ans);
            }
        }
        
        return res;
    }
}