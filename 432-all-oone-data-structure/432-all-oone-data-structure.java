class AllOne {

    HashMap<String,Integer> map;
    TreeMap<Integer,HashSet<String>> tmap;
    public AllOne() {
        this.map=new HashMap<>();
        this.tmap=new TreeMap<>();
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
            int oldFreq=map.get(key);
            tmap.get(oldFreq).remove(key);
            if(tmap.get(oldFreq).isEmpty()) tmap.remove(oldFreq);
            int newFreq=oldFreq+1;
            map.put(key,newFreq);
            tmap.putIfAbsent(newFreq,new HashSet<String>());
            tmap.get(newFreq).add(key);
        }else{
            map.put(key,1);
            tmap.putIfAbsent(1,new HashSet<String>());
            tmap.get(1).add(key);
        }
    }
    
    public void dec(String key) {
        if(map.containsKey(key)){
            int oldFreq=map.get(key);
            tmap.get(oldFreq).remove(key);
            if(tmap.get(oldFreq).isEmpty()) tmap.remove(oldFreq);
            int newFreq=oldFreq-1;
            if(newFreq==0) {map.remove(key); return;}
            map.put(key,newFreq);
            tmap.putIfAbsent(newFreq,new HashSet<String>());
            tmap.get(newFreq).add(key);
        }
    }
    
    public String getMaxKey() {
        if(tmap.isEmpty()) return "";
        if(tmap.get(tmap.lastKey()).isEmpty()) return "";
        Iterator e=tmap.get(tmap.lastKey()).iterator();
        while(e.hasNext()){
            return (String)e.next();
        }
        return "";
    }
    
    public String getMinKey() {
        if(tmap.isEmpty()) return "";
        if(tmap.get(tmap.firstKey()).isEmpty()) return "";
        Iterator e=tmap.get(tmap.firstKey()).iterator();
        while(e.hasNext()){
            return (String)e.next();
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */