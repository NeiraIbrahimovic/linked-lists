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

public class MyRawLinkedList {
    private static final long serialVersionUID = 1561306366555780559L;

    static class Node {
        private static final long serialVersionUID = -3505677833599614054L;
        String value;
        Node next = null;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(String value) {
            this(value, null);
        }
    }

    /* This is intentionally left private so that you can't erroneously try to
     * instantiate a `new MyRawLinkedList()`
     */
    private MyRawLinkedList() {}

    /*
     * These methods included as examples for how to use Node as a linked list.
     */
    public static String listToString(Node head) {
        String ret = "";
        while (head != null) {
            ret += "\"" + head.value + (head.next == null ? "\" " : "\", ");
            head = head.next;
        }
        return "[ " + ret + "]";
    }

    public static void print(Node head) {
        System.out.println(listToString(head));
    }

    public static void main(String[] args) {
        Node list1 = new Node("One", new Node("Two", new Node("Three", null)));
        print(list1);

        Node args_as_list = null;
        for (int i = args.length - 1; i >= 0; i--)
            args_as_list = new Node(args[i], args_as_list);

        print(args_as_list);

        Node list2 = null;
        list2 = new Node("a", list2);
        list2 = new Node("b", list2);
        list2 = new Node("c", list2);
        print(list2);
    }

    /*
     * Implement the methods below. Please do not change their signatures!
     */

    public static Node reverse(Node head) {
    	
        //If head is null (empty list), return null
        if (head == null) {
            return null; 
        }
    	
    	//Store a variable to hold the previous node, as the current node will need to point to the previous node
    	//Set prev to null, as head will first point to null
    	Node prev = null;
    	
    	//Store a reference to the current node so we can keep track of where we are in the list
    	Node current = head;
    	
    	//While we still have nodes in the list, follow the steps to reverse the link
    	while (current != null) {
    		
    		//Store the next node after current in a variable so we don't lose track of it when we reverse the link
            Node next = current.next; 
            
            //Now reverse the link so current points to the previous node
            current.next = prev; 
            
            //Move prev to current, so the next node will point to the current node as its previous node
            prev = current; 
            
            //Move current to the next node to begin the steps again if nodes are remaining
            current = next; 
        }
    	
    	//Return the new head of the reversed list (which is the last current node before we reach null)
    	return prev;
    }

    public static Node removeMaximumValues(Node head, int N) {
        //Edge Case: If N is 0 or negative, return the original list unmodified
    	if (N <= 0) {
    		return head;
    	}
    	
    	//Edge case: If list is empty, return empty list
    	if (head == null) {
    		return null;
    	}
    	
    	//Create a variable to store the current Node
    	Node current;
    	
    	//Create a variable to store the max Node
    	Node maxNode;
 
    	//Continue the loop as many times as specified by N to find and remove the N largest values
    	for (int i = 0; i < N; i++) {  
    	    //Set current to head    
    		current = head;
    		//Set maxNode to null as it hasn't been found yet
    	    maxNode = null;

    	    //Find the largest value in the list by comparing each value to the next until you get to the end of the list
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

    	        //Next, remove all occurrences of this max value
    	        
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
    	    }

    		//Return the new head of the list
    	    return head; 
    	}

    public static boolean containsSubsequence(Node head, Node other) {
    	    
    		//Edge Case: If user passes an empty node, this counts as a valid subsequence of any list
    	    if (other == null) {
    	        return true;
    	    }

    	    //Edge Case: If 'head' is null, return false
    	    if (head == null) {
    	        return false;
    	    }

    	    //Store the head node in a current variable
    	    Node currentHead = head;

    	    //Go through all nodes in the head list to find the first match
    	    while (currentHead != null) {
    	        //Check if the subsequence starts here
    	        Node headNode = currentHead;
    	        //Store the other head node in a variable
    	        Node otherNode = other;

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

    	    // If no match was found, return false
    	    return false;
    }

}

