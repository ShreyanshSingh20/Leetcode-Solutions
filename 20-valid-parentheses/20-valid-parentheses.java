class Solution {
    public boolean isValid(String str) {
        
        char c[]=str.toCharArray();
        Stack<Character> s=new Stack<>();
        
        for(int i=0;i<c.length;i++){
            if(c[i]==')'||c[i]=='}'||c[i]==']'){
                if(!s.isEmpty()&&isMatch(c[i],s.peek())){
                    s.pop();    
                }else return false;
            }else{
                s.push(c[i]);
            }
        }
        
        return s.isEmpty();
    }
    
    public boolean isMatch(char a,char b){
        if(a==')'&&b=='(') return true;
        if(a==']'&&b=='[') return true;
        if(a=='}'&&b=='{') return true;
        
        return false;
    }
}





