class Solution {
    public String orderlyQueue(String s, int k) {
        int n=s.length();
        if(k==1){
            String str=s+s;
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(str.substring(i,i+n));
            }
            Collections.sort(list);
            return list.get(0);
        }else{
            char c[]=s.toCharArray();
            Arrays.sort(c);
            StringBuilder res=new StringBuilder();
            for(char x:c) res.append(x);
            return res.toString();
        }
    }
}