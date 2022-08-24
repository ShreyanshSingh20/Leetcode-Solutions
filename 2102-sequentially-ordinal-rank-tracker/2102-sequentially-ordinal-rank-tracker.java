class SORTracker {
    TreeSet<Location> locations = new TreeSet<>(); 
    Location lastReturned = new Location("", Integer.MAX_VALUE); // Last returned (or equivalent)
    
    public void add(String name, int score) {
        Location location = new Location(name, score);
        locations.add(location);
        
		// If the new location is before the last returned, we need to update the pointer
        if (location.compareTo(lastReturned) < 0) {
            lastReturned = locations.lower(lastReturned);
        }
    }
    
    public String get() {
        // Update the pointer
        lastReturned = locations.higher(lastReturned);
        
        return lastReturned.name;
    }
    
 class Location implements Comparable<Location> {
        String name;
        int score;
        
        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public int compareTo(Location l) {
            // Sort by score (desc), then name (asc)
            return score != l.score ? -Integer.compare(score, l.score) : name.compareTo(l.name);
        }
    }
}