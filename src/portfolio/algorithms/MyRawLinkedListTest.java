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

import portfolio.algorithms.MyRawLinkedList.Node;

import static org.junit.jupiter.api.Assertions.*;

class MyRawLinkedListTest {
	
	@Test
	void testRawContainsSubsequence() {

		/*
		 * TEST 1: Ensure a single-letter subsequence can be found in the original sequence
		 */
		
		//Create a LinkedList
		MyRawLinkedList.Node list1 = new MyRawLinkedList.Node("A",
				new MyRawLinkedList.Node("B",
				new MyRawLinkedList.Node("C",
				new MyRawLinkedList.Node("D", null))));
		
		MyRawLinkedList.Node subsequence1 = new MyRawLinkedList.Node("B", null);
		
		//Ensure the subsequence can be found in the original sequence
		 assertTrue(MyRawLinkedList.containsSubsequence(list1, subsequence1), 
				 "A single-letter subsequence should be detected in the original sequence");
		
		
		/*
		 * TEST 2: Ensure a subsequence of letters in the same order can be found in the original sequence
		 */
		 
			//Create a LinkedList
			MyRawLinkedList.Node list2 = new MyRawLinkedList.Node("A",
					new MyRawLinkedList.Node("B",
					new MyRawLinkedList.Node("C",
					new MyRawLinkedList.Node("D", null))));
			
			MyRawLinkedList.Node subsequence2 = new MyRawLinkedList.Node("A", 
					new MyRawLinkedList.Node("B", null));
			
			//Ensure the subsequence can be found in the original sequence
			 assertTrue(MyRawLinkedList.containsSubsequence(list2, subsequence2), 
					 "A multi-letter subsequence should be detected in the original sequence");
		
		/*
		 * TEST 3: Ensure a subsequence of letters in the same order but skipping a few can be found in the original sequence
		 */
		
		//Create a LinkedList
			 MyRawLinkedList.Node list3 = new MyRawLinkedList.Node("A",
					new MyRawLinkedList.Node("B",
					new MyRawLinkedList.Node("C",
					new MyRawLinkedList.Node("D", null))));
				
			 MyRawLinkedList.Node subsequence3 = new MyRawLinkedList.Node("A", 
						new MyRawLinkedList.Node("B", 
						new MyRawLinkedList.Node("D", null)));
				
			//Ensure the subsequence can be found in the original sequence
			assertTrue(MyRawLinkedList.containsSubsequence(list3, subsequence3), 
				"A multi-letter subsequence with skipped letters but correct order should be detected in the original sequence");
						 
		
		/*
		 * TEST 4: Ensure a subsequence of letters in a different order cannot be found in the original sequence
		 */
			
			//Create a LinkedList
			MyRawLinkedList.Node list4 = new MyRawLinkedList.Node("A",
					new MyRawLinkedList.Node("B",
					new MyRawLinkedList.Node("C",
					new MyRawLinkedList.Node("D", null))));
			
			MyRawLinkedList.Node subsequence4 = new MyRawLinkedList.Node("B", 
					new MyRawLinkedList.Node("A", null));
			
			//Ensure the subsequence can be found in the original sequence
			 assertFalse(MyRawLinkedList.containsSubsequence(list4, subsequence4), 
					 "A subsequence with incorrect order should not be detected in the original sequence");
		
		/*
		 * TEST 5: Ensure an empty subsequence can be found in the original sequence
		 */
			 
			 //Create a LinkedList
			MyRawLinkedList.Node list5 = new MyRawLinkedList.Node("A",
					new MyRawLinkedList.Node("B",
					new MyRawLinkedList.Node("C",
					new MyRawLinkedList.Node("D", null))));
				
			MyRawLinkedList.Node subsequence5 = null;
				
			//Ensure the subsequence can be found in the original sequence
				assertTrue(MyRawLinkedList.containsSubsequence(list5, subsequence5), 
					"An empty subsequence should be detected in the original sequence");
		
		/*
		 * TEST 6: Ensure a subsequence with letters that do not appear in the original sequence cannot be found
		 */
			
			//Create a LinkedList
			MyRawLinkedList.Node list6 = new MyRawLinkedList.Node("A",
					new MyRawLinkedList.Node("B",
					new MyRawLinkedList.Node("C",
					new MyRawLinkedList.Node("D", null))));
				
			MyRawLinkedList.Node subsequence6 = new MyRawLinkedList.Node("A", 
					new MyRawLinkedList.Node("B", 
					new MyRawLinkedList.Node("F", null)));
				
			//Ensure the subsequence can be found in the original sequence
			assertFalse(MyRawLinkedList.containsSubsequence(list6, subsequence6), 
					"A subsequence with incorrect letters should not be detected in the original sequence");
		
		/*
		 * TEST 7: Ensure program can handle scenarios where head contains null value
		 */
			//Create a LinkedList
			MyRawLinkedList.Node list7 = new MyRawLinkedList.Node("A",
					new MyRawLinkedList.Node("B",
					new MyRawLinkedList.Node(null,
					new MyRawLinkedList.Node("D", null))));
				
			MyRawLinkedList.Node subsequence7 = new MyRawLinkedList.Node("A", 
					new MyRawLinkedList.Node("B", null));
				
			//Ensure the subsequence can be found in the original sequence
			assertTrue(MyRawLinkedList.containsSubsequence(list7, subsequence7), 
					"A subsequence should be detected in the original sequence");
			
		/*
		 * TEST 8: Ensure program can handle scenarios where other contains null value
		 */
			
			//Create a LinkedList
			MyRawLinkedList.Node list8 = new MyRawLinkedList.Node("A",
					new MyRawLinkedList.Node("B",
					new MyRawLinkedList.Node("C",
					new MyRawLinkedList.Node("D", null))));
				
			MyRawLinkedList.Node subsequence8 = new MyRawLinkedList.Node("A", 
					new MyRawLinkedList.Node(null, 
					new MyRawLinkedList.Node("B", null)));
				
			//Ensure the subsequence cannot be found in the original sequence
			assertFalse(MyRawLinkedList.containsSubsequence(list8, subsequence8), 
					"A subsequence containing a null value should not be detected in the original sequence if the original sequence does not contain a null value");
		
			/*
			 * TEST 9: Ensure program can handle scenarios where head and other contain null values
			 */
				
				//Create a LinkedList
				MyRawLinkedList.Node list9 = new MyRawLinkedList.Node("A",
						new MyRawLinkedList.Node(null,
						new MyRawLinkedList.Node("B",
						new MyRawLinkedList.Node("C", null))));
					
				MyRawLinkedList.Node subsequence9 = new MyRawLinkedList.Node("A", 
						new MyRawLinkedList.Node(null, 
						new MyRawLinkedList.Node("B", null)));
					
				//Ensure the subsequence can be found in the original sequence
				assertTrue(MyRawLinkedList.containsSubsequence(list9, subsequence9), 
						"A subsequence containing a null value should be detected in the original sequence if the original sequence contains the same order of values");			
		
	}

	@Test
	void testRawRemoveMaximumValues() {
		/*
		 * TEST 1: Ensure N=1 removes the correct maximum value when max value is in the middle
		 */
		
		//Create a LinkedList with the MaxValue in the middle
	    MyRawLinkedList.Node list1 = new MyRawLinkedList.Node(
	            "DOG", 
	            new MyRawLinkedList.Node("GORILLA", 
	            new MyRawLinkedList.Node("BANANA", 
	            new MyRawLinkedList.Node("CAT", null))));

	    //Remove 1 max value
	    MyRawLinkedList.Node result1 = MyRawLinkedList.removeMaximumValues(list1, 1);
	    
	    //Ensure the correct value was removed
	     assertEquals("[ \"DOG\", \"BANANA\", \"CAT\" ]", MyRawLinkedList.listToString(result1),
	      "N=1 should remove the largest value 'GORILLA'");
		
	    /*
	     * TEST 2: Ensure N=1 removes the correct maximum value when max value is at the front
	     */
		
	     //Create a LinkedList with the MaxValue in the middle
		 MyRawLinkedList.Node list2 = new MyRawLinkedList.Node(
		            "GORILLA", 
		            new MyRawLinkedList.Node("DOG", 
		            new MyRawLinkedList.Node("BANANA", 
		            new MyRawLinkedList.Node("CAT", null))));
		 
		 //Remove 1 max value
		 MyRawLinkedList.Node result2 = MyRawLinkedList.removeMaximumValues(list2, 1);
		 
		 //Ensure the correct value was removed
		 assertEquals("[ \"DOG\", \"BANANA\", \"CAT\" ]", MyRawLinkedList.listToString(result2),
		      "N=1 should remove the largest value 'GORILLA'");
		 
		 //Ensure the head was replaced
		 assertEquals("DOG", result2.value); 
	  
	    /*
	     * TEST 3: Ensure N=1 removes the correct maximum value when max value is at the end
	     */
		 
	     //Create a LinkedList with the MaxValue at the end
		 MyRawLinkedList.Node list3 = new MyRawLinkedList.Node(
		            "DOG", 
		            new MyRawLinkedList.Node("BANANA", 
		            new MyRawLinkedList.Node("CAT", 
		            new MyRawLinkedList.Node("GORILLA", null))));
		 
		 //Remove 1 max value
		 MyRawLinkedList.Node result3 = MyRawLinkedList.removeMaximumValues(list3, 1);
		 
		 //Ensure the correct value was removed
		 assertEquals("[ \"DOG\", \"BANANA\", \"CAT\" ]", MyRawLinkedList.listToString(result3),
		      "N=1 should remove the largest value 'GORILLA'");
	     
		/*
		 * TEST 4: Ensure N=1 removes all instances of the largest value
		 */
		 
	     //Create a LinkedList with multiple occurrences of the MaxValue 
		 MyRawLinkedList.Node list4 = new MyRawLinkedList.Node(
		            "DOG", 
		            new MyRawLinkedList.Node("GORILLA", 
		            new MyRawLinkedList.Node("CAT", 
		            new MyRawLinkedList.Node("BANANA", 
		            new MyRawLinkedList.Node("DOLPHIN", 
		            new MyRawLinkedList.Node("GORILLA", 
		            new MyRawLinkedList.Node("GORILLA", 
		            new MyRawLinkedList.Node("ELEPHANT", null))))))));
		 
		 //Remove 1 max value
		 MyRawLinkedList.Node result4 = MyRawLinkedList.removeMaximumValues(list4, 1);
		 
		 //Ensure the correct value was removed
		 assertEquals("[ \"DOG\", \"CAT\", \"BANANA\", \"DOLPHIN\", \"ELEPHANT\" ]", MyRawLinkedList.listToString(result4),
		      "N=1 should remove all occurrences of the largest value 'GORILLA'");
		
		/*
		 * TEST 5: Ensure N>1 removes largest values in the correct order
		 */
		 
	     //Create a LinkedList  
			 MyRawLinkedList.Node list5 = new MyRawLinkedList.Node(
			            "DOG", 
			            new MyRawLinkedList.Node("GORILLA", 
			            new MyRawLinkedList.Node("CAT", 
			            new MyRawLinkedList.Node("BANANA", 
			            new MyRawLinkedList.Node("DOLPHIN", 
			            new MyRawLinkedList.Node("ELEPHANT", null))))));
			 
			 //Remove 1 max value
			 MyRawLinkedList.Node result5 = MyRawLinkedList.removeMaximumValues(list5, 3);
			 
			 //Ensure the correct value was removed
			 assertEquals("[ \"DOG\", \"CAT\", \"BANANA\" ]", MyRawLinkedList.listToString(result5),
			      "N=3 should remove 3 of the largest value nodes");
			
		
		/*
		 * TEST 6: Ensure N=0 returns the original unmodified list 
		 */
			 
		//Create a LinkedList  
		MyRawLinkedList.Node list6 = new MyRawLinkedList.Node(
			        	"DOG", 
			        	new MyRawLinkedList.Node("GORILLA", 
			            new MyRawLinkedList.Node("CAT", null)));
			 
			 //Use N=0
			 MyRawLinkedList.Node result6 = MyRawLinkedList.removeMaximumValues(list6, 0);
			 
			 //Ensure the original list is returned
			 assertEquals("[ \"DOG\", \"GORILLA\", \"CAT\" ]", MyRawLinkedList.listToString(result6),
			      "N=0 should return the original unmodified list");
		
			 
		/*
		* TEST 7: Ensure N<0 returns the original unmodified list 
		*/
			 
			 //Create a LinkedList  
			 MyRawLinkedList.Node list7 = new MyRawLinkedList.Node(
					 	"DOG", 
					 		new MyRawLinkedList.Node("GORILLA", 
					 		new MyRawLinkedList.Node("CAT", null)));
					 
			 //Use N<0
			MyRawLinkedList.Node result7 = MyRawLinkedList.removeMaximumValues(list7, -4);
					 
			//Ensure the original list is returned
			assertEquals("[ \"DOG\", \"GORILLA\", \"CAT\" ]", MyRawLinkedList.listToString(result7),
				"N<0 should return the original unmodified list");
			 
		/*
		 * TEST 8: Ensure an empty list is returned if an empty list is passed
		 */
			
			//Create an empty LinkedList  
			 MyRawLinkedList.Node list8 = new MyRawLinkedList.Node("", null);
					 
			 //Try removing the max values
			MyRawLinkedList.Node result8 = MyRawLinkedList.removeMaximumValues(list8, 2);
					 
			//Ensure the empty list is returned
			assertEquals("[ ]", MyRawLinkedList.listToString(result8),
				"Ensure passing an empty list returns an empty list");
		
		/*
		 * TEST 9: Ensure a null list is returned when all nodes are removed
		 */
	
			 //Create a LinkedList  
			 MyRawLinkedList.Node list9 = new MyRawLinkedList.Node(
					 	"DOG", 
					 		new MyRawLinkedList.Node("GORILLA", 
					 		new MyRawLinkedList.Node("CAT", null)));
					 
			 //Use N=3 to equal the number of nodes in the list
			MyRawLinkedList.Node result9 = MyRawLinkedList.removeMaximumValues(list9, 3);
					 
			//Ensure an empty list is returned since all the nodes were removed
			assertEquals("[ ]", MyRawLinkedList.listToString(result9),
				"An empty list should be returned when all the nodes are removed");
		
		/*
		 * TEST 10: Ensure an empty list is returned when you remove more nodes than the list contains
		 */
			 
			//Create a LinkedList  
			 MyRawLinkedList.Node list10 = new MyRawLinkedList.Node(
					 	"DOG", 
					 		new MyRawLinkedList.Node("GORILLA", 
					 		new MyRawLinkedList.Node("CAT", null)));
					 
			 //Use N=4 to be greater than the number of nodes in the list
			MyRawLinkedList.Node result10 = MyRawLinkedList.removeMaximumValues(list10, 4);
					 
			//Ensure an empty list is returned when N is greater than the number of nodes
			assertEquals("[ ]", MyRawLinkedList.listToString(result10),
				"An empty list should be returned when N is greater than the number of nodes");
			
			/*
			 * TEST 11: Ensure all values are correctly removed when multiple values have multiple occurrences
			 */
		     
			//Create a LinkedList  
					 MyRawLinkedList.Node list11 = new MyRawLinkedList.Node(
					            "KANGAROO", 
					            new MyRawLinkedList.Node("PLATYPUS", 
					            new MyRawLinkedList.Node("AARDVARK", 
					            new MyRawLinkedList.Node("KANGAROO", 
					            new MyRawLinkedList.Node("DONKEY", 
					            new MyRawLinkedList.Node("DONKEY", 
					            new MyRawLinkedList.Node("AARDVARK", null)))))));
					 
			//Remove 3 max values
			MyRawLinkedList.Node result11 = MyRawLinkedList.removeMaximumValues(list11, 3);
					 
			//Ensure the correct values were removed
			assertEquals("[ \"AARDVARK\", \"AARDVARK\" ]", MyRawLinkedList.listToString(result11),
					      "N=3 should remove all occurrences of 3 of the largest value nodes");
	}

	@Test
	void testRawReverse() {

		/*
		 * TEST 1: Ensure reversing an empty list returns null
		 */
		
		//Create an empty list 
		MyRawLinkedList.Node emptyList = null;
		
		//Assert that reversing this empty list will return null
        assertNull(MyRawLinkedList.reverse(emptyList), "Reversing an empty list should return null");
        
        /*
         * TEST 2: Ensure reversing a normal list with many nodes works as expected
         */
        
        //Create a linked list with multiple nodes
        MyRawLinkedList.Node normalMultiNodeList = new Node("One", new Node("Two", new Node("Three", new Node("Four", null))));
        
        //Store the reversed list in a variable
        MyRawLinkedList.Node reversedMultiNodeList = MyRawLinkedList.reverse(normalMultiNodeList);
        
        //Convert the reversed link to a String and store in variable
        String reversedMultiNodeListAsString = MyRawLinkedList.listToString(reversedMultiNodeList);
        
        //Assert that the list was reversed correctly
        assertEquals("[ \"Four\", \"Three\", \"Two\", \"One\" ]", reversedMultiNodeListAsString, "A list with multiple nodes is not properly reversed");
        
        
        /*
         * TEST 3: Ensure reversing a single-node list does not change the list
         */
        
        //Create a single node list
        MyRawLinkedList.Node singleNodeList = new Node("One", null);
        
        //Store the reversed list in a variable
        MyRawLinkedList.Node reversedSingleNodeList = MyRawLinkedList.reverse(singleNodeList);
        
        //Convert the reversed link to a String and store in variable
        String reversedSingleNodeListAsString = MyRawLinkedList.listToString(reversedSingleNodeList);
        
        //Assert that the list was reversed correctly
        assertEquals("[ \"One\" ]", reversedSingleNodeListAsString, "A list with a single node is not properly reversed");
        
        /*
         * TEST 4: Ensure the method returns the Node representing the head of the reversed list
         */
        
        //Create a linked list with multiple nodes
        MyRawLinkedList.Node nodeList = new Node("One", new Node("Two", new Node("Three", null)));
        
        //Store the actual returned head in a variable
        MyRawLinkedList.Node actualReturnedHead = MyRawLinkedList.reverse(nodeList);
        
        //Assert that the correct Head was returned
        assertEquals("Three", actualReturnedHead.value, "Reverse method should return the new head of the reversed list.");
        
        
        /*
         * TEST 5: Ensure an empty list will return an empty list when reversed
         */
        
        //Create an empty list
         MyRawLinkedList.Node nullNodeList = new MyRawLinkedList.Node("", null);
        
         //Reverse the list
        MyRawLinkedList.Node reversedNullNodeList = MyRawLinkedList.reverse(nullNodeList);
        
        //Convert the reversed link to a String and store in variable
        String nullNodeListAsString = MyRawLinkedList.listToString(reversedNullNodeList);
        
        //Assert that the list returned is empty
        assertEquals("[ \"\" ]", nullNodeListAsString, 
        		"An empty list should return an empty list upon reversing");
	}

}
