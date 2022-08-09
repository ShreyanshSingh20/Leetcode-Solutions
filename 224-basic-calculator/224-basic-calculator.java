class Solution {
    public int calculate(String str) {
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ') continue;
            sb.append(str.charAt(i));
        }
        char c[]=sb.toString().toCharArray();
        Stack<Integer> s=new Stack<>();
        
        int res=0;int sign=1;
        
        for(int i=0;i<c.length;i++){
            if(c[i]>=48&&c[i]<=57){
                int num=c[i]-'0';
                while(i+1<c.length&&c[i+1]>=48&&c[i+1]<=57){
                    num=num*10+(c[i+1]-'0');
                    i++;
                }
                
                res+=(num*sign);
            }else if(c[i]=='-'){
                sign=-1;
            }else if(c[i]=='+'){
                sign=1;
            }else if(c[i]=='('){
                s.push(res);
                s.push(sign);
                res=0;
                sign=1;
            }else if(c[i]==')'){
                res=(res*s.pop())+s.pop();
            }
        }
        
        return res;
    }
}