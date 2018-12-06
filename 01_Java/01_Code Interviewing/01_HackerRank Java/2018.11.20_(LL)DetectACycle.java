//https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists

boolean hasCycle(Node head) {
    if(head == null){
        return false;
    }
    Node slow = head;
    Node fast = head.next;
    
    while(slow != fast){//self-same, collision
        if(fast == null || fast.next == null){
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}