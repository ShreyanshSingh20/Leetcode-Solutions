class MyCalendar {
    

    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(map.isEmpty()) {map.put(start,end-1); return true;}
        Integer lower=map.lowerKey(end);
        if(lower==null) {
            map.put(start,end-1);
            return true;
        }
        int val=map.get(lower);
        if(val>=start) return false;
        else{
            map.put(start,end-1);
            return true;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */