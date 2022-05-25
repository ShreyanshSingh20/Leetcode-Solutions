class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        List<Integer> sub=new ArrayList<>();
        sub.add(arr[0]);
        
        for(int i=1;i<n;i++){
            int num=arr[i];
            if(num>sub.get(sub.size()-1)){
                sub.add(num);
            }else{
                int j=binarySearch(sub,num);
                sub.set(j,num);
            }
        }
        
        return sub.size();
    }
    
    public int binarySearch(List<Integer> sub,int num){
        int left=0;
        int right=sub.size()-1;
        
        while(left<right){
            int mid=left+(right-left)/2;
            if(sub.get(mid)==num) return mid;
            if(sub.get(mid)<num) left=mid+1;
            else right=mid;
        }
        
        return left;
    }
}