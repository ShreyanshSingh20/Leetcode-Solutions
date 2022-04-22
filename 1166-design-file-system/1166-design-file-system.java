class FileSystem {

		Node rootNode;

		public FileSystem() {
			rootNode = new Node();
		}

		public boolean createPath(String path, int value) {
			int lastSlash = -1;
			for (int i = path.length() - 1; i >= 0; i--) {
				if (path.charAt(i) == '/') {
					lastSlash = i;
					break;
				}
			}

			if (lastSlash == 0) {
				if (search(path) == -1) {
					insert(path, value);
					return true;
				} else {
					return false;
				}
			} else {
				String str = path.substring(0, lastSlash);
				if (search(str) != -1) {
					if (search(path) == -1) {
						insert(path, value);
						return true;
					} else {
						return false;
					}
				} else
					return false;
			}
		}

		public int get(String path) {
			return search(path);
		}

		public void insert(String path, int val) {
			Node tempNode = rootNode;
			for (char c : path.toCharArray()) {
				if (tempNode.getChild((int) c) == null) {
					Node newNode = new Node();
					tempNode.setChild(newNode, (int) c);
				}
				tempNode = tempNode.getChild((int) c);
			}

			tempNode.setEOW();
			tempNode.setVal(val);
		}

		public int search(String path) {
			Node tempNode = rootNode;
			for (char c : path.toCharArray()) {
				if (tempNode.getChild((int) c) != null) {
					tempNode = tempNode.getChild((int) c);
				} else
					return -1;
			}
			return tempNode.getVal();
		}

}

class Node {
		Node arr[];
		int val;
		boolean eow;

		public Node() {
			super();
			this.arr = new Node[128];
			this.val = -1;
			this.eow = false;
		}

		public Node getChild(int i) {
			return arr[i];
		}

		public int getVal() {
			return val;
		}

		public void setChild(Node newNode, int i) {
			arr[i] = newNode;
		}

		public void setEOW() {
			eow = true;
		}

		public void setVal(int val) {
			this.val = val;
		}
	}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */