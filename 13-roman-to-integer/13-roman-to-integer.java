class Solution {
    public int romanToInt(String s) {
        char c[]=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);
        map.put('C',100);map.put('D',500);map.put('M',1000);
        
        int res=0;
        int n=c.length;int i=0;
        while(i<n){
            if(c[i]=='I'){
                if(i+1<n){
                    if(c[i+1]=='V') {res+=4;i+=2;}
                    else if(c[i+1]=='X') {res+=9;i+=2;}
                    else {res+=map.get(c[i]); i++;}
                }else{
                    res+=map.get(c[i]);
                    i++;
                }
            }else if(c[i]=='X'){
                if(i+1<n){
                    if(c[i+1]=='L') {res+=40;i+=2;}
                    else if(c[i+1]=='C') {res+=90;i+=2;}
                    else {res+=map.get(c[i]); i++;}
                }else{
                    res+=map.get(c[i]);
                    i++;
                }
            }else if(c[i]=='C'){
                if(i+1<n){
                    if(c[i+1]=='D') {res+=400;i+=2;}
                    else if(c[i+1]=='M') {res+=900;i+=2;}
                    else {res+=map.get(c[i]); i++;}
                }else{
                    res+=map.get(c[i]);
                    i++;
                }
            }else{
                res+=map.get(c[i]);
                i++;
            }
        }
        
        return res;
    }
}