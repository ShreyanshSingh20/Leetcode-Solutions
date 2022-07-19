class Solution {
    public int lengthLongestPath(String input) {
        
        String arr[]=input.split("\n");
        Stack<Integer> s=new Stack<>();
        s.push(0);
        int maxLen=0;
        for(String x:arr){
            int numOfTabs=x.lastIndexOf("\t")+1;
            int level=numOfTabs+1;
            
            while(level<s.size()) s.pop();
            int currLen=s.peek()+x.length()-numOfTabs+1;
            s.push(currLen);
            if(x.contains(".")){
                maxLen=Math.max(maxLen,currLen-1);
            }
        }
        
        return maxLen;
    }
}