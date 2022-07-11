class Solution {
    public int validSubarraySize(int[] arr, int threshold) {
        
        int n=arr.length;
        int left[]=new int[n];
        int right[]=new int[n];
        
        Stack<Integer> a=new Stack<>();
        for(int i=0;i<n;i++) left[i]=i;
        for(int i=0;i<n;i++){
            while(!a.isEmpty()&&arr[a.peek()]>=arr[i]){
                a.pop();
            }
            left[i]=a.isEmpty()?0:a.peek()+1;
            a.push(i);
        }
        
        Stack<Integer> b=new Stack<>();
        for(int i=0;i<n;i++) right[i]=i;
        for(int i=n-1;i>=0;i--){
            while(!b.isEmpty()&&arr[b.peek()]>=arr[i]){
                b.pop();
            }
            right[i]=b.isEmpty()?n-1:b.peek()-1;
            b.push(i);
        }
        
        // for(int x:arr) System.out.print(x+" ");
        // System.out.println();
        // for(int x:left) System.out.print(x+" ");
        // System.out.println();
        // for(int x:right) System.out.print(x+" ");
        // System.out.println();
        
        for(int i=0;i<n;i++){
            int size=right[i]-left[i]+1;
            int min=arr[i];
            int comp=threshold/size;
            if(min>comp) return size;
        }
        
        return -1;
    }
}