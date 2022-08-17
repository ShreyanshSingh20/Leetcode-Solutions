class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> list=new LinkedList<>();int pt=-1;
        
        for(int i=0;i<n-3;i++){
            if(i>0&&arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&arr[j]==arr[j-1]) continue;
                int l=j+1;int r=n-1;
                long req=(long)target-((long)arr[i]+(long)arr[j]);
                
                while(l<r){
                    if(arr[l]+arr[r]==req){
                        list.add(new LinkedList<Integer>());
                        pt++;
                        list.get(pt).add(arr[i]);
                        list.get(pt).add(arr[j]);
                        list.get(pt).add(arr[l]);
                        list.get(pt).add(arr[r]);
                        l++;r--;
                        while(l<r&&arr[l]==arr[l-1]) l++;
                        while(r>l&&arr[r]==arr[r+1]) r--;
                    }else if(arr[l]+arr[r]<req){
                        l++;
                        while(l<r&&arr[l]==arr[l-1]) l++;
                    }else{
                        r--;
                        while(r>l&&arr[r]==arr[r+1]) r--;
                    }
                }
            }
        }
        
        return list;
        
    }
}