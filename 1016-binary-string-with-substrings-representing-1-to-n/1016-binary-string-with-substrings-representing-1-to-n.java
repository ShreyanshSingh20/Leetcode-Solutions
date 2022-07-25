class Solution {
    public boolean queryString(String s, int n) {
        
        HashSet<Integer> set=new HashSet<>();
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<c.length;j++){
                if(j-i+1>=32) continue;
                sb.append(c[j]);
                int num=Integer.parseInt(sb.toString(),2);
                if(num>=1&&num<=n) set.add(num);
            }
        }
        
        if(set.size()==n) return true;
        return false;
    }
}