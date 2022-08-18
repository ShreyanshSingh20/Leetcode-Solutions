class Solution {
    List<List<Integer>> res;
    List<Integer> sub;
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        this.res=new ArrayList<>();
        this.sub=new ArrayList<>();
        solver(0,arr);
        return res;
    }
    
    public void solver(int i,int arr[]){
        if(i==arr.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(arr[i]);
        solver(i+1,arr);
        if(sub.size()>0) sub.remove(sub.size()-1);
        while(i+1<arr.length&&arr[i]==arr[i+1]) i++;
        solver(i+1,arr);
    }
}