package portfolio.algorithms;/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 * Signed,
 * Author: Neira Ibrahimovic
 * Date: 2025-01-28
 */

public class MyLinkedList {

    private static final long serialVersionUID = 1663679278942178557L;
    static class Node {
        private static final long serialVersionUID = -539394075146871892L;
        String value;
        Node next;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(String value) {
            this(value, null);
        }
    }

    protected Node head = null;
    protected Node tail = null;
    protected int size = 0;

    public void addFirst(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(String value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, String value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            if (current.next == null) {
                tail = newNode;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }


    public void removeFirst() {
        if (head != null) {
            head = head.next;
        } else {
            return;
        }
        if (head == null) {
            tail = null;
        }
        if (size > 0)
            size--;
    }

    public void removeLast() {
        if (head == null) { // empty list
            return;
        } else if (head == tail) {
            // single element list
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            current.next = null;
        }
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        else if (index == 0)
            removeFirst();
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
            size--;
        }
    }

    
    @Override
    //Create a toString method for test cases
    public String toString() {
    	//Return "[]" for an empty list
        if (head == null) return "[]"; 

        //Create a StringBuilder variable to hold the string
        StringBuilder sb = new StringBuilder("[ ");
        Node current = head;

        //Append the nodes' values to the string
        while (current != null) {
            sb.append(current.value == null ? "null" : "\"" + current.value + "\"");
            
            if (current.next != null) sb.append(", ");
            current = current.next;
        }

        sb.append(" ]");
        
        //Return the String
        return sb.toString();
    }
    
    
    /*
     * Implement the methods below. Please do not change their signatures!
     */

    public void reverse() {
    	    //If the list is empty or has only one element, there is no need to reverse, so return
    	    if (head == null || head.next == null) {
    	        return;
    	    }

    	    Node prev = null;
    	    Node current = head;
    	    Node next = null;

    	    //Set the original head to be the new tail
    	    tail = head; 

    	    //Reverse the links
    	    while (current != null) {
    	    	//Store the next node so the node isn't lost when the link is removed
    	        next = current.next; 
    	        //Reverse the link
    	        current.next = prev;  
    	        //Move prev to the current node
    	        prev = current;  
    	        //Move to the next node
    	        current = next;      
    	    }

    	    //Update head to the last processed node before null (prev is now the new head)
    	    head = prev;
    }

    public void removeMaximumValues(int N) {
    	    //Edge Case: If N is 0 or negative, return the original list unmodified
    	    if (N <= 0) {
    	        return;
    	    }

    	    //Edge Case: If list is empty, do nothing
    	    if (head == null) {
    	        return;
    	    }

    	  //Continue the loop as many times as specified by N to find and remove the N largest values
    	    for (int i = 0; i < N; i++) { 
    	    	//Set current to head 
    	        Node current = head;
    	        //Set maxNode to null as it hasn't been found yet
    	        Node maxNode = null;

    	        //Find the maximum value in the list by comparing each value to the next until you get to the end of the list
    	        while (current != null) {
    	        	//If this is the first iteration of the while loop, maxNode will be null and thus will automatically be updated to current
       	    	 	//Compare the current value to the next value 
       	    	 	//If the current value is larger, store it in the variable maxNode
    	            if (maxNode == null || current.value.compareTo(maxNode.value) > 0) {
    	                maxNode = current;
    	            }
    	            //Iterate through the list by updating the current variable to point to the next node
    	            current = current.next;
    	        }

    	        //If no maxNode was found, break 
    	     	//This handles the case where all max values were found before N iterations (N > number of nodes)
    	        if (maxNode == null) {
    	            break;
    	        }

    	        ///Next, remove all occurrences of this max value
    	        
    	        //Create a dummy prev node to store the previous node before current
    	        Node dummy = new Node("", head); 
    	        Node prev = dummy;
    	        current = head;

    	      //Iterate through all the nodes until you reach null
    	        while (current != null) {
    	        	//If the current node's value equals the max node's value, remove the current node
    	            if (current.value.equals(maxNode.value)) { 
    	            	//Remove the current node by making the previous node point to the next node after current
    	                prev.next = current.next; 
    	                //Decrease size since a node is removed
    	                size--; 
    	            } else {
    	            	//If the current value doesn't equal the max value, update the prev variable so the loop can continue
    	                prev = current;
    	            }
    	            //Update current to the next node
    	            current = current.next;
    	        }

    	        //Dummy points to the head, so in the case where the head is removed,
    	        //update the head to point to the node after head
    	        head = dummy.next;

    	        //Update tail if needed
    	        if (tail != null && tail.value.equals(maxNode.value)) {
    	        	//Move tail backward
    	            tail = prev; 
    	        }
    	        
    	        //If all nodes were removed, set tail to null
    	        if (head == null) {
    	            tail = null;
    	        }
    	    }
    }

    public Boolean containsSubsequence(MyLinkedList other) {
    	    //Edge Case: If 'other' is null (non-instantiated), return null
    	    if (other == null) {
    	        return null;
    	    }

    	    //Edge Case: If user passes an empty node, this counts as a valid subsequence of any list
    	    if (other.head == null) {
    	        return true;
    	    }

    	    //Edge Case: If 'head' is null, return false
    	    if (this.head == null) {
    	        return false;
    	    }

    	    //Store the head node in a current variable
    	    Node currentHead = this.head;

    	    //Go through all nodes in the head list to find the first match
    	    while (currentHead != null) {
    	    	//Check if the subsequence starts here
    	        Node headNode = currentHead;
    	        //Store the other head node in a variable
    	        Node otherNode = other.head;

    	      //While you have nodes left in head and other, compare them all until the first runs out
    	        while (headNode != null && otherNode != null) {
    	        	//Compare values to check if they're both null
    	            if ((headNode.value == null && otherNode.value == null) ||
    	            	//Compare values to check if the head value matches the other value
    	                (headNode.value != null && headNode.value.equals(otherNode.value))) {
    	            	//If the values match, move to the next node in 'other' to see if those match
    	            	//If the values don't match, leave otherNode alone as we will compare it to the next node in the head list
    	                otherNode = otherNode.next; 
    	            }
    	            //Move 'headNode' forward to compare the next node's value to the subsequence (only if otherNode matched)
    	            headNode = headNode.next; 
    	        }

    	      //If we've matched all nodes in 'other' (meaning we have reached the next value of null and broke the while loop), return true
    	        if (otherNode == null) {
    	            return true;
    	        }

    	      //Move to the next node in 'head' and try again
    	        currentHead = currentHead.next;
    	    }

    	    //If no match is found, return false
    	    return false;
    	}

}
