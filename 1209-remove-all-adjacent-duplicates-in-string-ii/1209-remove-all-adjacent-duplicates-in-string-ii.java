class Solution {
    public String removeDuplicates(String s, int k) {
        char c[]=s.toCharArray();
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(c[0],1));
        for(int i=1;i<c.length;i++){
            while(!stack.isEmpty()&&stack.peek().cnt>=k){
                int tmpk=k;
                while(!stack.isEmpty()&&tmpk>0){
                    stack.pop();
                    tmpk--;
                }
            }
            if(!stack.isEmpty()&&c[i]==stack.peek().ch){
                stack.push(new Pair(c[i],stack.peek().cnt+1));
            }else{
                 stack.push(new Pair(c[i],1));
            }
        }
        
        while(!stack.isEmpty()&&stack.peek().cnt>=k){
                int tmpk=k;
                while(!stack.isEmpty()&&tmpk>0){
                    stack.pop();
                    tmpk--;
                }
        }
        
        StringBuilder res=new StringBuilder();
        for(Pair x:stack) res.append(x.ch);
        
        return res.toString();
    }
}

class Pair{
    char ch;
    int cnt;
    public Pair(char ch,int cnt){
        this.ch=ch;
        this.cnt=cnt;
    }
}