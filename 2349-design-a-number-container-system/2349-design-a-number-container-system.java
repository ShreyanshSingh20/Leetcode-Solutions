class NumberContainers {

    TreeMap<Integer,Integer> index;
    TreeMap<Integer,TreeSet<Integer>> map;
    public NumberContainers() {
        this.index=new TreeMap<>();
        this.map=new TreeMap<>();
    }
    
    public void change(int ind, int number) {
        if(index.containsKey(ind)){
            int num=index.get(ind);
            map.get(num).remove(ind);
            index.put(ind,number);
            map.putIfAbsent(number,new TreeSet<Integer>());
            map.get(number).add(ind);
        }else{
            index.put(ind,number);
            map.putIfAbsent(number,new TreeSet<Integer>());
            map.get(number).add(ind);
        }
    }
    
    public int find(int number) {
        if(!map.containsKey(number)) return -1;
        if(map.containsKey(number)&&map.get(number).isEmpty()) return -1;
        return map.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */