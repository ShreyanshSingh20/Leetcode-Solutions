class SORTracker {
    
    TreeSet<Location> set;
    Location lastUsed=new Location("",Integer.MAX_VALUE);

    public SORTracker() {
        this.set=new TreeSet<>();
    }
    
    public void add(String name, int score) {
        Location newLocation=new Location(name,score);
        set.add(newLocation);
        
        if(newLocation.compareTo(lastUsed)<0){
            lastUsed=set.lower(lastUsed);
        }
    }
    
    public String get() {
        
        lastUsed=set.higher(lastUsed);
        return lastUsed.name;
    }
    
    class Location implements Comparable<Location>{
        String name;
        int score;

        public Location(String name,int score){
            this.name=name;
            this.score=score;
        }

        public int compareTo(Location l1){
            return score==l1.score?name.compareTo(l1.name):(-Integer.compare(score,l1.score));
        }
    }
    
}





/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */