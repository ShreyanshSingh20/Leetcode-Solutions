class Solution {
    public int longestValidParentheses(String str) {
        char c[]=str.toCharArray();
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        
        int res=0;
        
        for(int i=0;i<c.length;i++){
            if(c[i]=='(') s.push(i);
            else{
                s.pop();
                if(s.isEmpty()){
                    s.push(i);
                }else{
                    res=Math.max(res,i-s.peek());
                }
            }
        }
        
        return res;
    }
}