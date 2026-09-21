package portfolio.algorithms;/*
 ***** Important!  Please Read! *****
 *
 *  - Do NOT remove any of the existing import statements
 *  - Do NOT import additional junit packages 
 *  - You MAY add in other non-junit packages as needed
 * 
 *  - Do NOT remove any of the existing test methods or change their name
 *  - You MAY add additional test methods.  If you do, they should all pass
 * 
 *  - ALL of your assert test cases within each test method MUST pass, otherwise the 
 *        autograder will fail that test method
 *  - You MUST write the require number of assert test cases in each test method, 
 *        otherwise the autograder will fail that test method
 *  - You MAY write more than the required number of assert test cases as long as they all pass
 * 
 *  - All of your assert test cases within a method must be related to the method they are meant to test
 *  - All of your assert test cases within a method must be distinct and non-trivial
 *  - Your test cases should reflect the method requirements in the homework instruction specification
 * 
 *  - Your assert test cases will be reviewed by the course instructors and they may take off
 *        points if your assert test cases to do not meet the requirements
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
	
	@Test
	void testContainsSubsequence() {
		    /*
		     * TEST 1: Ensure a single-letter subsequence can be found in the original sequence
		     */
		    MyLinkedList list1 = new MyLinkedList();
		    list1.addLast("A");
		    list1.addLast("B");
		    list1.addLast("C");
		    list1.addLast("D");

		    MyLinkedList subsequence1 = new MyLinkedList();
		    subsequence1.addLast("B");

		    assertTrue(list1.containsSubsequence(subsequence1),
		        "A single-letter subsequence should be detected in the original sequence");


		    /*
		     * TEST 2: Ensure a subsequence of letters in the same order can be found in the original sequence
		     */
		    MyLinkedList list2 = new MyLinkedList();
		    list2.addLast("A");
		    list2.addLast("B");
		    list2.addLast("C");
		    list2.addLast("D");

		    MyLinkedList subsequence2 = new MyLinkedList();
		    subsequence2.addLast("A");
		    subsequence2.addLast("B");

		    assertTrue(list2.containsSubsequence(subsequence2),
		        "A multi-letter subsequence should be detected in the original sequence");


		    /*
		     * TEST 3: Ensure a subsequence of letters in the same order but skipping a few can be found in the original sequence
		     */
		    MyLinkedList list3 = new MyLinkedList();
		    list3.addLast("A");
		    list3.addLast("B");
		    list3.addLast("C");
		    list3.addLast("D");

		    MyLinkedList subsequence3 = new MyLinkedList();
		    subsequence3.addLast("A");
		    subsequence3.addLast("B");
		    subsequence3.addLast("D");

		    assertTrue(list3.containsSubsequence(subsequence3),
		        "A multi-letter subsequence with skipped letters but correct order should be detected in the original sequence");


		    /*
		     * TEST 4: Ensure a subsequence of letters in a different order cannot be found in the original sequence
		     */
		    MyLinkedList list4 = new MyLinkedList();
		    list4.addLast("A");
		    list4.addLast("B");
		    list4.addLast("C");
		    list4.addLast("D");

		    MyLinkedList subsequence4 = new MyLinkedList();
		    subsequence4.addLast("B");
		    subsequence4.addLast("A");

		    assertFalse(list4.containsSubsequence(subsequence4),
		        "A subsequence with incorrect order should not be detected in the original sequence");


		    /*
		     * TEST 5: Ensure an empty subsequence can be found in the original sequence
		     */
		    MyLinkedList list5 = new MyLinkedList();
		    list5.addLast("A");
		    list5.addLast("B");
		    list5.addLast("C");
		    list5.addLast("D");

		    MyLinkedList subsequence5 = new MyLinkedList(); // Empty subsequence

		    assertTrue(list5.containsSubsequence(subsequence5),
		        "An empty subsequence should be detected in the original sequence");


		    /*
		     * TEST 6: Ensure a subsequence with letters that do not appear in the original sequence cannot be found
		     */
		    MyLinkedList list6 = new MyLinkedList();
		    list6.addLast("A");
		    list6.addLast("B");
		    list6.addLast("C");
		    list6.addLast("D");

		    MyLinkedList subsequence6 = new MyLinkedList();
		    subsequence6.addLast("A");
		    subsequence6.addLast("B");
		    subsequence6.addLast("F");

		    assertFalse(list6.containsSubsequence(subsequence6),
		        "A subsequence with incorrect letters should not be detected in the original sequence");


		    /*
		     * TEST 7: Ensure program can handle scenarios where head contains null value
		     */
		    MyLinkedList list7 = new MyLinkedList();
		    list7.addLast("A");
		    list7.addLast("B");
		    list7.addLast(null);
		    list7.addLast("D");

		    MyLinkedList subsequence7 = new MyLinkedList();
		    subsequence7.addLast("A");
		    subsequence7.addLast("B");

		    assertTrue(list7.containsSubsequence(subsequence7),
		        "A subsequence should be detected in the original sequence when original contains null values");


		    /*
		     * TEST 8: Ensure program can handle scenarios where other contains null value
		     */
		    MyLinkedList list8 = new MyLinkedList();
		    list8.addLast("A");
		    list8.addLast("B");
		    list8.addLast("C");
		    list8.addLast("D");

		    MyLinkedList subsequence8 = new MyLinkedList();
		    subsequence8.addLast("A");
		    subsequence8.addLast(null);
		    subsequence8.addLast("B");

		    assertFalse(list8.containsSubsequence(subsequence8),
		        "A subsequence containing a null value should not be detected in the original sequence if the original sequence does not contain a null value");


		    /*
		     * TEST 9: Ensure program can handle scenarios where head and other contain null values
		     */
		    MyLinkedList list9 = new MyLinkedList();
		    list9.addLast("A");
		    list9.addLast(null);
		    list9.addLast("B");
		    list9.addLast("C");

		    MyLinkedList subsequence9 = new MyLinkedList();
		    subsequence9.addLast("A");
		    subsequence9.addLast(null);
		    subsequence9.addLast("B");

		    assertTrue(list9.containsSubsequence(subsequence9),
		        "A subsequence containing a null value should be detected in the original sequence if the original sequence contains the same order of values");


		    /*
		     * TEST 10: Ensure passing `null` as `other` returns `null`
		     */
		    MyLinkedList list10 = new MyLinkedList();
		    list10.addLast("A");
		    list10.addLast("B");
		    list10.addLast("C");
		    list10.addLast("D");

		    assertNull(list10.containsSubsequence(null),
		        "Passing a null list should return null");
}

	@Test
	void testRemoveMaximumValues() {
	    /*
	     * TEST 1: Ensure N=1 removes the correct maximum value when max value is in the middle
	     */
	    MyLinkedList list1 = new MyLinkedList();
	    list1.addLast("DOG");
	    list1.addLast("GORILLA");
	    list1.addLast("BANANA");
	    list1.addLast("CAT");

	    list1.removeMaximumValues(1);

	    assertEquals("[ \"DOG\", \"BANANA\", \"CAT\" ]", list1.toString(),
	        "N=1 should remove the largest value 'GORILLA'");


	    /*
	     * TEST 2: Ensure N=1 removes the correct maximum value when max value is at the front
	     */
	    MyLinkedList list2 = new MyLinkedList();
	    list2.addLast("GORILLA");
	    list2.addLast("DOG");
	    list2.addLast("BANANA");
	    list2.addLast("CAT");

	    list2.removeMaximumValues(1);

	    assertEquals("[ \"DOG\", \"BANANA\", \"CAT\" ]", list2.toString(),
	        "N=1 should remove the largest value 'GORILLA'");

	    //Ensure the head was updated correctly
	    assertEquals("DOG", list2.head.value, "Head should be updated correctly after removing max value");


	    /*
	     * TEST 3: Ensure N=1 removes the correct maximum value when max value is at the end
	     */
	    MyLinkedList list3 = new MyLinkedList();
	    list3.addLast("DOG");
	    list3.addLast("BANANA");
	    list3.addLast("CAT");
	    list3.addLast("GORILLA");

	    list3.removeMaximumValues(1);

	    assertEquals("[ \"DOG\", \"BANANA\", \"CAT\" ]", list3.toString(),
	        "N=1 should remove the largest value 'GORILLA'");

	    //Ensure the tail was updated correctly
	    assertEquals("CAT", list3.tail.value, "Tail should be updated correctly after removing max value");


	    /*
	     * TEST 4: Ensure N=1 removes all instances of the largest value
	     */
	    MyLinkedList list4 = new MyLinkedList();
	    list4.addLast("DOG");
	    list4.addLast("GORILLA");
	    list4.addLast("CAT");
	    list4.addLast("BANANA");
	    list4.addLast("DOLPHIN");
	    list4.addLast("GORILLA");
	    list4.addLast("GORILLA");
	    list4.addLast("ELEPHANT");

	    list4.removeMaximumValues(1);

	    assertEquals("[ \"DOG\", \"CAT\", \"BANANA\", \"DOLPHIN\", \"ELEPHANT\" ]", list4.toString(),
	        "N=1 should remove all occurrences of the largest value 'GORILLA'");


	    /*
	     * TEST 5: Ensure N>1 removes largest values in the correct order
	     */
	    MyLinkedList list5 = new MyLinkedList();
	    list5.addLast("DOG");
	    list5.addLast("GORILLA");
	    list5.addLast("CAT");
	    list5.addLast("BANANA");
	    list5.addLast("DOLPHIN");
	    list5.addLast("ELEPHANT");

	    list5.removeMaximumValues(3);

	    assertEquals("[ \"DOG\", \"CAT\", \"BANANA\" ]", list5.toString(),
	        "N=3 should remove 3 of the largest value nodes");


	    /*
	     * TEST 6: Ensure N=0 returns the original unmodified list
	     */
	    MyLinkedList list6 = new MyLinkedList();
	    list6.addLast("DOG");
	    list6.addLast("GORILLA");
	    list6.addLast("CAT");

	    list6.removeMaximumValues(0);

	    assertEquals("[ \"DOG\", \"GORILLA\", \"CAT\" ]", list6.toString(),
	        "N=0 should return the original unmodified list");


	    /*
	     * TEST 7: Ensure N<0 returns the original unmodified list
	     */
	    MyLinkedList list7 = new MyLinkedList();
	    list7.addLast("DOG");
	    list7.addLast("GORILLA");
	    list7.addLast("CAT");

	    list7.removeMaximumValues(-4);

	    assertEquals("[ \"DOG\", \"GORILLA\", \"CAT\" ]", list7.toString(),
	        "N<0 should return the original unmodified list");


	    /*
	     * TEST 8: Ensure an empty list is returned if an empty list is passed
	     */
	    MyLinkedList list8 = new MyLinkedList();

	    list8.removeMaximumValues(2);

	    assertEquals("[]", list8.toString(), "Ensure passing an empty list returns an empty list");


	    /*
	     * TEST 9: Ensure a null list is returned when all nodes are removed
	     */
	    MyLinkedList list9 = new MyLinkedList();
	    list9.addLast("DOG");
	    list9.addLast("GORILLA");
	    list9.addLast("CAT");

	    list9.removeMaximumValues(3);

	    assertEquals("[]", list9.toString(), "An empty list should be returned when all the nodes are removed");
	    assertNull(list9.head, "Head should be null when all nodes are removed");
	    assertNull(list9.tail, "Tail should be null when all nodes are removed");


	    /*
	     * TEST 10: Ensure an empty list is returned when you remove more nodes than the list contains
	     */
	    MyLinkedList list10 = new MyLinkedList();
	    list10.addLast("DOG");
	    list10.addLast("GORILLA");
	    list10.addLast("CAT");

	    list10.removeMaximumValues(4);

	    assertEquals("[]", list10.toString(),
	        "An empty list should be returned when N is greater than the number of nodes");
	    assertNull(list10.head, "Head should be null when removing more nodes than exist");
	    assertNull(list10.tail, "Tail should be null when removing more nodes than exist");


	    /*
	     * TEST 11: Ensure all values are correctly removed when multiple values have multiple occurrences
	     */
	    MyLinkedList list11 = new MyLinkedList();
	    list11.addLast("KANGAROO");
	    list11.addLast("PLATYPUS");
	    list11.addLast("AARDVARK");
	    list11.addLast("KANGAROO");
	    list11.addLast("DONKEY");
	    list11.addLast("DONKEY");
	    list11.addLast("AARDVARK");

	    list11.removeMaximumValues(3);

	    assertEquals("[ \"AARDVARK\", \"AARDVARK\" ]", list11.toString(),
	        "N=3 should remove all occurrences of 3 of the largest value nodes");
	}

	@Test
	void testReverse() {
	    /*
	     * TEST 1: Ensure reversing an empty list does not cause errors (list remains empty)
	     */
		
		//Create an empty linked list
	    MyLinkedList emptyList = new MyLinkedList(); 
	    
	    //Reverse the empty list
	    emptyList.reverse();
	    
	    //Ensure that reversing an empty list keeps it empty
	    assertNull( emptyList.head, "Reversing an empty list should keep it empty");
	    
	    //Ensure size of list is still 0
	    assertEquals(0, emptyList.size, "Size should remain 0 after reversing an empty list");
	    
	    /*
	     * TEST 2: Ensure reversing a normal list with multiple nodes works correctly
	     */
	    
	    //Create a LinkedList and add nodes
	    MyLinkedList list = new MyLinkedList();
	    list.addLast("One");
	    list.addLast("Two");
	    list.addLast("Three");
	    list.addLast("Four");

	    //Reverse the list
	    list.reverse();

	    //Ensure the list was reversed properly
	    assertEquals("[ \"Four\", \"Three\", \"Two\", \"One\" ]", list.toString(),
	        "A list with multiple nodes is not properly reversed");

	    /*
	     * TEST 3: Ensure reversing a single-node list does not change the list
	     */
	    
	    //Create a single node list
	    MyLinkedList singleNodeList = new MyLinkedList();
	    singleNodeList.addLast("One");

	    //Reverse the list
	    singleNodeList.reverse();

	    //Ensure the list remains the same after reversing
	    assertEquals("[ \"One\" ]", singleNodeList.toString(), 
	        "A single-node list should remain the same after reversing");

	    /*
	     * TEST 4: Ensure reversing updates the head and tail correctly
	     */
	    
	    //Create a linked list
	    MyLinkedList list1 = new MyLinkedList();
	    list1.addLast("First");
	    list1.addLast("Middle");
	    list1.addLast("Last");

	    //Reverse the list
	    list1.reverse();
	    
	    //Check head directly
	    assertEquals("Last", list1.head.value, "Head should be 'Last' after reversing");
	    
	    
	    /*
	     * TEST 5: Ensure reversing a list with a null-valued node works correctly
	     */
	    
	    //Create LinkedList with a null value
	    MyLinkedList listWithNull = new MyLinkedList();
	    listWithNull.addLast("A");
	    listWithNull.addLast(null);
	    listWithNull.addLast("B");

	    //Reverse LinkedList
	    listWithNull.reverse();

	    //Ensure the list is reversed correctly
	    assertEquals("[ \"B\", null, \"A\" ]", listWithNull.toString(), 
	        "A list with a null node should be reversed correctly");
	}

}

