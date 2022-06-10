class Solution {
    public int lengthOfLongestSubstring(String s) {
        char c[]=s.toCharArray();
        if(c.length==0) return 0;
        int l=0;int maxLen=1;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int r=0;r<c.length;r++){
            map.put(c[r],map.getOrDefault(c[r],0)+1);
            while(map.size()!=r-l+1){
                int freq=map.get(c[l]);
                if(freq==1) map.remove(c[l]);
                else map.put(c[l],freq-1);
                l++;
            }
            if(r-l+1==map.size()) maxLen=Math.max(maxLen,r-l+1);
            // System.out.println(maxLen);
        }
        
        return maxLen;
    }
}

// b-2 c-1 a-1