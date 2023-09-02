class Node
{
    int key,val;
    Node prev,next;
    Node(int key,int val)
    {
        this.key=key;
        this.val=val;
    }
}

class LRUCache {
    int cap;
    Map<Integer,Node> cache;//Map each key to a node
    Node left=new Node(0,0);//LRU
    Node right = new Node(0,0);//Most Recently Used
    
    public LRUCache(int capacity) {
        cap=capacity;
        cache= new HashMap<>();
        left.next=right;
        right.prev=left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key))
        {
            remove(cache.get(key));//Remove the Node from its current position in the double linked list and insert it in the right.
            insert(cache.get(key));
            return cache.get(key).val;//Return the value in the node
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            remove(cache.get(key));
        }
        Node newNode=new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);

        if(cache.size()>cap)
        {
            cache.remove(left.next.key);
            remove(left.next);
        }
        
    }

    public void insert(Node node)
    {
        Node prev=right.prev,next=right;
        prev.next=next.prev=node;
        node.prev=prev;
        node.next=next;
    }

    public void remove(Node node)
    {
        Node previous=node.prev,next=node.next;
        previous.next=next;
        next.prev=previous;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */