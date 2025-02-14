// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Design hashmap


class MyHashMap {
    
    class Node{
        int key;
        int val;
        Node next;
        
        Node(){
            
        }
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private int idx(int key){
        return key%10000;
    }
    
    private Node find(Node head, int target){
        Node prev = head; // dummy node
        Node curr = head.next;
        while(curr != null && curr.key != target){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx = idx(key);
        if(nodes[idx] == null){
            //create dummy node
            nodes[idx] = new Node(-1, -1);
        }
        Node prev = find(nodes[idx], key);
        if(prev.next == null){
            //key not present
            prev.next = new Node(key,value);
        } else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = idx(key);
        if(nodes[idx] == null) return -1;
        
        Node prev = find(nodes[idx], key);
        if(prev.next == null) {
            //not found
            return -1;
        }
        return prev.next.val;
        
    }
    
    public void remove(int key) {
        int idx = idx(key);
        if(nodes[idx] == null) return;
        
        Node prev = find(nodes[idx], key);
        if(prev.next == null){
            //not found
            return;
        }
        prev.next = prev.next.next;
    }
}