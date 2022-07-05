/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=10005;
        
        while(low<=high){
            int mid=(low+high)/2;
            int elem=reader.get(mid);
            if(elem==target) return mid;
            if(elem<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        return -1;
    }
}