public class LeetCodeLinkedList
   {
      //REM: implementation
      //inst vars
      private LNode m_first;//head
      
      public LeetCodeLinkedList()
      {
         m_first = null;
      }
      public LNode getHead(){
         return m_first;
      }
      
      public void insert(int v)//basically a push method
      {
         //insert at front
         //creates a new node with the value given by int v
         
         LNode newNode = new LNode(v);
         newNode.setLink(m_first);
         m_first = newNode;
      }
 //      Target Code
      public LNode removeElements(LNode head, int val) {
        
        //needed in case ist node is a val we have to remove
        LNode result = new LNode(-1);
        result.next = head;
        LNode prev = result;
        
        while(prev.getLink() != null)
         {
         //getInfo is a base method
         //moves pointer over twice (thus skipping a value)
            if(prev.getLink().getInfo() == val){
               head = head.getLink();
                  prev = prev.getLink().getLink();
               }
            else {
               prev = prev.getLink();
            }
         }
         return result.next;
      }
      
       public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
      
      // public boolean contains(int v)
//       {
//          //WALK THE LIST
//          while(current != null)
//          {
//             if(current.getInfo() == v)
//                return true;
//             else
//                current = current.getLink();
//          }
//          return false;
//       }

   public String toString(LNode current)
      {
         String listContent =  "The content of the list is: ";

         while(current != null)
         {
            listContent += current.getInfo() + " ";
            current = current.getLink();
         }
         
         return listContent;

      }
 }