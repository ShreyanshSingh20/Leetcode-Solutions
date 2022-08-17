class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        
        int n=arr.length;
        Arrays.sort(arr);
        
        List<List<Integer>> list=new LinkedList<>();int pt=-1;
        
        for(int i=0;i<n-1;i++){
            if(i>0&&arr[i]==arr[i-1]) continue;
            int l=i+1;int r=n-1;
            
            while(l<r){
                if(arr[i]+arr[l]+arr[r]==0){
                    list.add(new LinkedList<Integer>());
                    pt++;
                    list.get(pt).add(arr[i]);
                    list.get(pt).add(arr[l]);
                    list.get(pt).add(arr[r]);
                    l++;r--;
                    while(l<r&&arr[l]==arr[l-1]) l++;
                    while(l<r&&arr[r]==arr[r+1]) r--;
                }else if(arr[i]+arr[l]+arr[r]<0){
                    l++;
                    while(l<r&&arr[l]==arr[l-1]) l++;
                }else if(arr[i]+arr[l]+arr[r]>0){
                    r--;
                    while(l<r&&arr[r]==arr[r+1]) r--;
                }
            }
        }
        
        return list;
    }
}