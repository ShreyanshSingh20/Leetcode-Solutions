class LFUCache {
    
    class DLLNode{
        DLLNode prev;
        Integer key;
        Integer val;
        DLLNode next;
        Integer freq;
        
        public DLLNode(Integer key,Integer val){
            this.key=key;
            this.val=val;
            this.freq=1;
        }
    }
    
    class DoublyLinkedList{
        DLLNode head;
        DLLNode tail;
        int listSize;
        
        public DoublyLinkedList(){
            this.listSize=0;
            this.head=new DLLNode(null,null);
            this.tail=new DLLNode(null,null);
            head.next=tail;
            tail.prev=head;
        }
        
        public void addNode(DLLNode node){
            node.next=head.next;
            head.next.prev=node;
            
            head.next=node;
            node.prev=head;
            
            listSize++;
        }
        
        public void removeNode(DLLNode node){
            DLLNode prev=node.prev;
            DLLNode next=node.next;
            
            prev.next=next;
            next.prev=prev;
            listSize--;
        }
    }
    
    int cap;int minFreq;
    int size;
    HashMap<Integer,DLLNode> map;
    HashMap<Integer,DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.cap=capacity;
        this.size=0;
        this.minFreq=0;
        this.map=new HashMap<>();
        this.freqMap=new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode node=map.get(key);
        
        if(node==null) return -1;
        updateNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(cap==0) return;
        
        if(map.containsKey(key)){
            DLLNode node=map.get(key);
            node.val=value;
            updateNode(node);
        }else{
            size++;
            //make the size of the lfu cache limit
            while(size>cap){
                DoublyLinkedList list=freqMap.get(minFreq);
                map.remove(list.tail.prev.key);
                list.removeNode(list.tail.prev);
                size--;
            }

            minFreq=1;
            DLLNode newNode=new DLLNode(key,value);
            freqMap.putIfAbsent(minFreq,new DoublyLinkedList());
            DoublyLinkedList list=freqMap.get(minFreq);    
            list.addNode(newNode);
            map.put(key,newNode);     
        }
    }
    
    public void updateNode(DLLNode node){
        int newFreq=node.freq+1;
        int oldFreq=node.freq;
        
        node.freq=newFreq;
        
        
        DoublyLinkedList list=freqMap.get(oldFreq);
        list.removeNode(node);
        
        if(oldFreq==minFreq&&list.listSize==0){
            minFreq++;
        }
        
        freqMap.putIfAbsent(newFreq,new DoublyLinkedList());
        DoublyLinkedList newList=freqMap.get(newFreq);
        
        newList.addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */