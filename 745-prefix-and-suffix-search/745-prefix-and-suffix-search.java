class WordFilter {

		Trie trie=new Trie();
	    public WordFilter(String[] words) {
	        int n=words.length;
	        for(int i=0;i<n;i++) {
	        	String word=words[i];
	        	for(int j=0;j<words[i].length();j++) {
	        		String subString=words[i].substring(j, words[i].length());
	        		String toInsert=subString+"#"+word;
	        		trie.insert(toInsert, i);
	        	}
	        }
	    }
	    
	    public int f(String prefix, String suffix) {
	    	String toSearch=suffix+"#"+prefix;
	    	TreeSet<Integer> set=trie.search(toSearch);
	    	if(set.isEmpty()) return -1;
	    	return set.last();
	    }
	}
	
	class Node{
		Node arr[];
		TreeSet<Integer> set;
		
		public Node() {
			arr=new Node[256];
			set=new TreeSet<>();
		}
		
		public Node getChild(int i) {
			return arr[i];
		}
		
		public void setChild(int i,Node newNode) {
			arr[i]=newNode;
		}
		
		public void addIndex(int ind) {
			set.add(ind);
		}
		
		public TreeSet<Integer> getSet() {
			return set;
		}
	}
	
	class Trie{
		Node root;
		
		public Trie() {
			root=new Node();
		}
		
		public void insert(String s,int ind) {
			Node temp=root;
			for(char c:s.toCharArray()) {
				if(temp.getChild(c)==null) {
					Node newNode=new Node();
					temp.setChild(c,newNode);
				}
				temp=temp.getChild(c);
				temp.addIndex(ind);
			}
		}
		
		public TreeSet<Integer> search(String str){
			Node temp=root;
			for(char c:str.toCharArray()) {
				if(temp.getChild(c)==null) return new TreeSet<>();
				temp=temp.getChild(c);
			}
			return temp.getSet();
		}
	}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */