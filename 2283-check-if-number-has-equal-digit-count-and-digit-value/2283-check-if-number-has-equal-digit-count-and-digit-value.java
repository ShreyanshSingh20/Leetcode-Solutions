class Solution {
    public boolean digitCount(String num) {
        char c[]=num.toCharArray();
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<c.length;i++) {
			map.put(c[i]-'0', map.getOrDefault(c[i]-'0', 0)+1);
		}
        
        for(int i=0;i<c.length;i++){
            int freq=c[i]-'0';
            int dig=i;
            if(!map.containsKey(dig)&&freq>0) return false;
            if(!map.containsKey(dig)) continue;
            // System.out.println(dig+" "+map.get(dig));
            if(map.get(dig)!=freq) return false;
        }
        
        return true;
    }
}