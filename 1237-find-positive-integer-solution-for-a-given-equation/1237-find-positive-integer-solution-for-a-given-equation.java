/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

/*
Staircase Problem
Rephrase the problem:
Given a matrix, each row and each column is increasing.
Find all coordinates (i,j) that A[i][j] == z
*/

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        
        List<List<Integer>> list=new ArrayList<>();
        int x=1;int y=1000;
        while(x<=1000&&y>0){
            int val=customfunction.f(x,y);
            if(val<z) x++;
            else if(val>z) y--;
            else list.add(Arrays.asList(x++,y--));
        }
        return list;
    }
}