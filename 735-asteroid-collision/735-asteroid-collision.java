class Solution {
    public int[] asteroidCollision(int[] arr) {
        
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        
        for(int i=0;i<n;i++){
            if(arr[i]>0) s.push(arr[i]);
            else{
                while(!s.isEmpty()&&Math.abs(arr[i])>s.peek()&&s.peek()>0){
                    s.pop();
                }
                
                if(!s.isEmpty()&&Math.abs(arr[i])==s.peek()&&s.peek()>0){
                    s.pop();
                    continue;
                }
                
                if(!s.isEmpty()&&Math.abs(arr[i])<s.peek()&&s.peek()>0){
                    continue;
                }
                
                s.push(arr[i]);
            }
        }
        
        int res[]=new int[s.size()];
        int pt=0;
        for(int x:s){
            res[pt]=x;
            pt++;
        }
        return res;
    }
}