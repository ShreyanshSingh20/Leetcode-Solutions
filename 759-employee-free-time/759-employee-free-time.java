/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> list) {
        int n=list.size();
        ArrayList<Pair> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<list.get(i).size();j++){
                a.add(new Pair(list.get(i).get(j).start,list.get(i).get(j).end));
            }
        }
        
        Collections.sort(a,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1,Pair o2){
                return (o1.s==o2.s)?o1.e-o2.e:o1.s-o2.s;
            }
        });
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        List<Interval> res=new ArrayList<>();
        pq.add(a.get(0).e);
        for(int i=1;i<a.size();i++){
            int s=a.get(i).s;
            int e=a.get(i).e;
            boolean fndone=false;
            while(!pq.isEmpty()&&s>pq.peek()){
                if(fndone==false){
                    res.add(new Interval(pq.peek(),s));
                    fndone=true;
                }
                pq.poll();
            }
            pq.add(e);
        }
        
        return res;
    }
    
    class Pair{
        int s;
        int e;
        
        public Pair(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
}