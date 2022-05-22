/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
//         int indeg[]=new int[n];
//         int outdeg[]=new int[n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i!=j&&knows(i,j)){
//                     indeg[j]=indeg[j]+1;
//                     outdeg[i]=outdeg[i]+1;
//                 }
//             }
//         }
        
//         for(int i=0;i<n;i++){
//             if(indeg[i]==n-1&&outdeg[i]==0) return i;
//         }
//         return -1;
        
        return smart(n);
        
    }
    
    public int smart(int n){
        int candidate=0;
        
        //If my candidate knows someone I will change my candidate
        for(int i=0;i<n;i++){
            if(i!=candidate&&knows(candidate,i)) candidate=i;
        }
        
        //If my candidate knows someone or someone does not know my candidate 
        //I will return -1;
        for(int i=0;i<n;i++){
            if(i!=candidate&&knows(candidate,i)||!knows(i,candidate)) return -1;
        }
        
        return candidate;
    }
}