class Solution {
    public long maximumBooks(int[] books) {
        
        int n=books.length;
        Stack<Integer> s=new Stack<>();
        
        long curr=0;long res=0;
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&books[s.peek()]>books[i]-(i-s.peek())){
                int j=s.pop();
                curr-=sum(books[j],s.isEmpty()?j+1:(j-s.peek()));
            }
            curr+=sum(books[i],s.isEmpty()?i+1:i-s.peek());
            s.push(i);
            res=Math.max(res,curr);
        }
        
        return res;
    }
    
    public long sum(long num,int cnt){
        long og=(num*(num+1))/2;
       if(num>cnt){
           return og-(((num-cnt)*(num-cnt+1))/2);
       }else{
           return og;
       }
    }
}