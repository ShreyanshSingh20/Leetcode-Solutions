class Solution {
		public int minimumLengthEncoding(String[] words) {
			int n = words.length;
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair(words[i], words[i].length()));
            }

            Collections.sort(list, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.len - o2.len;
                }
            });
            
			Trie trie = new Trie();
			for (int i = 0; i < n; i++) {
				StringBuilder s = new StringBuilder(list.get(i).str);
				String rev = s.reverse().toString();
				trie.insert(rev);
			}

			String called = trie.caller();
            // System.out.println(called);
			return (called.length());
		}
	}

	class Node {
		Node arr[];
		String finString;
        boolean eow;

		public Node() {
			arr = new Node[26];
			finString = null;
            eow=false;
		}

		public Node getChild(int i) {
			return arr[i];
		}

		public void setChild(int i, Node newNode) {
			arr[i] = newNode;
		}

		public void setString(String str) {
			this.finString = str;
		}
        
        public void markTrue(){
            this.eow=true;
        }
        
        public void markFalse(){
            this.eow=false;
        }
        
        public boolean getEOW(){
            return eow;
        }
	}

	class Trie {
		Node root;
		StringBuilder res;
		Node tempNode;

		public Trie() {
			root = new Node();
			res = new StringBuilder();
			this.tempNode = root;
		}

		public void insert(String str) {
			Node temp = root;
			for (char c : str.toCharArray()) {
				if (temp.getChild(c - 'a') == null) {
					Node newNode = new Node();
					temp.setChild(c - 'a', newNode);
				}
				temp = temp.getChild(c - 'a');
                if(temp.getEOW()==true) temp.markFalse();
			}
			temp.setString(str);
            temp.markTrue();
		}

		public String caller() {
			dfs(tempNode);
			return res.toString();
		}

		public void dfs(Node node) {

			for (int i = 0; i < 26; i++) {
				if (node.getChild(i) != null) {
					dfs(node.getChild(i));
				}
			}

			if (node.finString!=null&&node.getEOW()) {
				res.append(node.finString);
				res.append("#");
			}

		}
	}

class Pair {
		String str;
		int len;

		public Pair(String str, int len) {
			super();
			this.str = str;
			this.len = len;
		}

	}