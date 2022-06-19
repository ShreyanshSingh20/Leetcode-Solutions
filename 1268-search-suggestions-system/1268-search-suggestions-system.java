class Solution {
    public List<List<String>> suggestedProducts(String[] arr, String word) {
        int n=arr.length;
		Trie trie=new Trie();
		for(int i=0;i<n;i++) {
			trie.insertString(arr[i]);
		}
		List<List<String>> res=trie.searchWord(word);
        if(res.size()<word.length()){
            int rem=word.length()-res.size();
            for(int i=0;i<rem;i++){
                res.add(new ArrayList<String>());
            }
        }
        return res;
    }
}

    class Node{
		Node arr[];
		TreeSet<String> treeSet;
		
		public Node() {
			arr=new Node[26];
			treeSet=new TreeSet<>();
		}
		
		public Node getChild(int i) {
			return arr[i];
		}
		
		public void setChild(int i,Node newNode) {
			arr[i]=newNode;
		}
		
		public void addWord(String word) {
			treeSet.add(word);
			while(treeSet.size()>3) {
				treeSet.remove(treeSet.last());
			}
		}
		
		public TreeSet<String> getTreeSet(){
			return treeSet;
		}
	}
	
     class Trie{
		Node rootNode;
		
		public Trie() {
			rootNode=new Node();
		}
		
		public void insertString(String word) {
			Node tempNode=rootNode;
			for(char c:word.toCharArray()) {
				int i=c-'a';
				if(tempNode.getChild(i)==null) {
					Node newNode=new Node();
					tempNode.setChild(i, newNode);
				}
				tempNode=tempNode.getChild(i);
				tempNode.addWord(word);
			}
		}
		
		public List<List<String>> searchWord(String word) {
			Node tempNode=rootNode;
			List<List<String>> res=new ArrayList<List<String>>();
			int pt=0;
			for(char c:word.toCharArray()) {
				int i=c-'a';
				if(tempNode.getChild(i)!=null) {
					tempNode=tempNode.getChild(i);
					res.add(new ArrayList<>());
					TreeSet<String> treeSet=tempNode.getTreeSet();
					while(!treeSet.isEmpty()) {
						res.get(pt).add(treeSet.pollFirst());
					}
					pt++;
				}else {
					return res;
				}
			}
			
			return res;
		}
	}