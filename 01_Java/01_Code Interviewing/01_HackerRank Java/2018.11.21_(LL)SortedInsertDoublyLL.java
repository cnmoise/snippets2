https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists

static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int val) {
        //insert a new value into a DLL while maintaining the lists sorting
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode lastNode = new DoublyLinkedListNode(-1);
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        
        if(head == null){
            head = newNode;
            return head;
        } else if (val < head.data) { // insert in front of list
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        
        while(current != null){
            //insert at the end
            if(current.next == null){
                //saves the last node so we can reffer to it later
                lastNode = current;
            }
            if(val< current.data){
                //originally was going to insert at the front of the list using this
                //but it seems we can't refer to a null prev?
                // if(current.prev == null){
                //     current.prev = newNode;
                //     current.prev.next = current;
                //     return head;
                // }
                current.prev.next = newNode;
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev = newNode;
                return head;
            }
            current = current.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
        return head;
    }