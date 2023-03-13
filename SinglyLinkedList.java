/**
*  File Name: SSL.java
*
*  Software Quality Assurance Corporation 
*  Code Review Project
*
*  (c) Copyright 2023 SQAC
*  ALL RIGHTS RESERVED
*
* Functional description: This class implements a singly-linked list
* that support insertion and deletion of nodes.
*
* Input: None.

* Output: None except error messages. 

* Supported Requirements: TBD

* Classes in this file: this class

* Related Documents: None; this file provides in-code documentation.

* Update History: 

* Error Messages:
 
* Constraints: None. 

* Assumptions: None. 
**/

package sll;

public class SinglyLinkedList {
   private Node headNode; 
   private int size;
   /** insert node before current node */
   public void insert(Node node, Node current) 
   {
      // Check for and handle null current pointer
      if (current == headNode) {
         node.setNext(current);
         headNode= node; size++;
         return;
      }
      // current node is not null
      Node n = new Node();
      n.data = current.getData();
      n.next = current.getNext();
      current.setData(node.getData());
      current.setNext(n); size++;
   }
   /** Find the first node with the given value */
   public Node find(String value) {
      Node p=headNode;
      while (p!=null) {
         if (p.data.compareTo(value)==0) return p;
         p=p.next;
      }
      return null;
   }
   /** Remove the node referenced by current */
   public void remove(Node current) {
      current.setData(current.getNext().getData());
      current.setNext(current.getNext().getNext());
      size--;
   }
   public int size() { return size; }
   /** Return a string that represent the values of the nodes */
   public String toString() {
      Node p = headNode; String r = "";
      while (p != null) {
         r += p.getData() + " ";
         p = p.next;
      }
      return r;
   }
   public Node head() { return headNode; }
}
