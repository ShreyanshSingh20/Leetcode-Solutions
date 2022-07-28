class Solution {
    public int shortestPath(int[][] grid, int k) {
        return solver(grid,k);
    }
    
    public int solver(int mat[][],int k){
        Queue<State> q=new ArrayDeque<>();
        HashSet<State> vis=new HashSet<>();
        State og=new State(0,0,k,0);
        q.add(og);vis.add(og);
        
        while(!q.isEmpty()){
            
            int size=q.size();
            
            for(int i=0;i<size;i++){
                State curr=q.poll();
                
                int x=curr.row;int y=curr.col;int currk=curr.k;int minSteps=curr.steps;
                if(x==mat.length-1&&y==mat[0].length-1) return minSteps;
                
                for(int j=0;j<4;j++){
                    int newx=x+offset[j][0];
                    int newy=y+offset[j][1];
                    
                    if(newx<0||newy<0||newx>=mat.length||newy>=mat[0].length) continue;
                    
                    int nextk=currk-mat[newx][newy];
                    State newState=new State(newx,newy,nextk,minSteps+1);
                    
                    if(nextk>=0&&!vis.contains(newState)){
                        vis.add(newState);
                        q.add(newState);
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int offset[][]={
        {0,1},{1,0},{0,-1},{-1,0}
    };
}


class State{
    int row;
    int col;
    int k;
    int steps;
    
    public State(int row,int col,int k,int steps){
        this.row=row;
        this.col=col;
        this.k=k;
        this.steps=steps;
    }
    
    @Override
    public int hashCode(){
        return (this.row+1)*(this.col+1)*(this.k);
    }
    
    @Override
    public boolean equals(Object another){
        
        if(!(another instanceof State)) return false;
        
        State state=(State)another;
        return (this.row==state.row)&&(this.col==state.col)&&(this.k==state.k);
    }
    
    // @Override
    // public String toString(){
    //     return String.format("%d %d %d",this.row,this.col,this.k);
    // }
}