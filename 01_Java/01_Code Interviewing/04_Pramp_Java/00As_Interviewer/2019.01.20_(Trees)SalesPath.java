//Source: https://www.pramp.com/challenge/15oxrQx6LjtQj9JK9XqA

import java.io.*;
import java.util.*;

class Solution {
 
  static class Node {
      
    int cost;
    Node[] children;
    Node parent;

    Node(int cost) {
      this.cost = cost;
      children = null;
      parent = null;
    }
  }

  static class SalesPath {
        
    static int getCheapestCost(Node rootNode) {
      if(rootNode.children.length == 0){ return rootNode.cost;}
      
      int minCost = Integer.MAX_VALUE;
      for(Node t: rootNode.children){
          int tempcost = getCheapestCost(t);
          System.out.println(tempcost);
          if(tempcost < minCost){
            minCost = tempcost;
          }
      }
      return minCost + rootNode.cost;
    }
    
    static void printTree(Node root){
      if (root.children == null || root.children.length == 0){
        System.out.println();
      }
      else{
        for(Node t : root.children){
          System.out.println(t.cost);
          printTree(t);
        }
      }
      
    }
  }
    
  /*********************************************
   * Driver program to test above method     *
   *********************************************/

  public static void main(String[] args) {
    Node testTreeHead = new Node(0);
    
    Node child1 = new Node(5);
    Node child2 = new Node(3);
    Node child3 = new Node(6);
    
    Node[] tna = {child1, child2, child3};
    
    testTreeHead.children = tna;
    
    Node child4 = new Node(4);
    Node[] tna2 = {child4};
    child1.children = tna2;
    
    Node child5 = new Node(2);
    Node child6 = new Node(0);
    Node[] tna3 = {child5, child6};
    child2.children = tna3;
    
    Node child7 = new Node(1);
    Node[] tna4 = {child7};
    child5.children = tna4;
    
    Node child8 = new Node(1);
    Node[] tna5 = {child8};
    child7.children = tna5;
    
    Node child9 = new Node(10);
    Node[] tna6 = {child9};
    child6.children = tna6;
    
    Node child10 = new Node(1);
    Node child11 = new Node(5);
    Node[] tna7 = {child10, child11};
    child3.children = tna7;
    
    //SalesPath.printTree(testTreeHead);
    
    System.out.println(SalesPath.getCheapestCost(child1));
    
  }
}