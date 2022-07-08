class Solution {
    public boolean isRationalEqual(String s, String t) {
        return transform(s)==transform(t);
    }
    
    public double transform(String s){
        int ind=s.indexOf('(');
        if(ind>0){
            String base=s.substring(0,ind);
            String rep=s.substring(ind+1,s.length()-1);
            for(int j=0;j<=20;j++) base+=rep;
            return Double.valueOf(base);
        }
        return Double.valueOf(s);
    }
}