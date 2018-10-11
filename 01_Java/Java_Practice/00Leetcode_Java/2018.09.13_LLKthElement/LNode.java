//This class represents a node in a Linked List
//09.06.16
   
   public class LNode
   {
     private int mvalue;
     private LNode mlink;
     
     public LNode(int val){
         mvalue = val;
         mlink = null;
     }
     
     public void setLink(LNode linkNode){
         mlink = linkNode;
     }
     public LNode getLink(){
         return mlink;
     }
     
     public int getInfo(){
         return mvalue;
     }
     
   }