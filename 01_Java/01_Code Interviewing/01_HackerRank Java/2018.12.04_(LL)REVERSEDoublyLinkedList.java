//https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem

static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }

        //instead of re-arranging all my previous and next 
        //pointers to do the reverse "in place"
        //we make a new DLL and just insert nodes starting at the
        //end of the first list and then backtracking
        DoublyLinkedList newDLL = new DoublyLinkedList();
        newDLL.insertNode(cur.data);

        while(cur.prev != null){
            cur = cur.prev;
            newDLL.insertNode(cur.data);
        }

        return newDLL.head;
    }