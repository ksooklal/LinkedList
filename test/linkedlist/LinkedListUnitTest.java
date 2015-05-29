package linkedlist;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListUnitTest {

	@SuppressWarnings(value = "rawtypes")
	@Test
	public void testConstructor(){
		LinkedList<String> list = new LinkedList<String>();
		assertNotEquals(null, list);
		assertEquals(0, list.size());
		
		LinkedList<Double> newList = new LinkedList<Double>();
		assertNotEquals(null, newList);
		
		LinkedList untypedList = new LinkedList();
		assertEquals(0, untypedList.size());
	}

	@Test
	public void testAddFirst() {
		LinkedList<int []> listOfArrays = new LinkedList<int []>();
		assertEquals(0, listOfArrays.size());
		
		listOfArrays.addFirst(new int [] {2, 234});
		assertEquals(1, listOfArrays.size());
		int [] storedArray = listOfArrays.get(0);
		assertEquals(2, storedArray[0]);
		assertEquals(234, storedArray[1]);
		
		listOfArrays.addFirst(new int [] {9129, 123901, 12309});
		assertEquals(2, listOfArrays.size());
		storedArray = listOfArrays.get(0);
		assertEquals(9129, storedArray[0]);
		assertEquals(123901, storedArray[1]);
		assertEquals(12309, storedArray[2]);
		
		int previousStoredArray [] = listOfArrays.get(1);
		assertEquals(2, previousStoredArray[0]);
		assertEquals(234, previousStoredArray[1]);
		
	}

	@Test
	public void testAddLast() {
		LinkedList<int []> listOfArrays = new LinkedList<int []>();
		assertEquals(0, listOfArrays.size());
		
		listOfArrays.addLast(new int [] {2, 234});
		assertEquals(1, listOfArrays.size());
		int [] storedArray = listOfArrays.get(0);
		assertEquals(2, storedArray[0]);
		assertEquals(234, storedArray[1]);
		
		listOfArrays.addLast(new int [] {9129, 123901, 12309});
		assertEquals(2, listOfArrays.size());
		
		int previousStoredArray [] = listOfArrays.get(0);
		assertEquals(2, previousStoredArray[0]);
		assertEquals(234, previousStoredArray[1]);
		
		int [] newStoredArray = listOfArrays.get(1);
		assertEquals(9129, newStoredArray[0]);
		assertEquals(123901, newStoredArray[1]);
		assertEquals(12309, newStoredArray[2]);
	}

	@Test
	public void testOfferFirst() {
	}

	@Test
	public void testOfferLast(){
	}

	@Test
	public void testRemoveFirst(){
	}

	@Test
	public void testRemoveLast() {
	}

	@Test
	public void testPollFirst() {
	}

	@Test
	public void testPollLast() {
	}

	@Test
	public void testGetFirst() {
	}

	@Test
	public void testGetLast() {
	}

	@Test
	public void testPeekFirst() {
	}

	@Test
	public void testPeekLast() {
	}

	@Test
	public void testRemoveFirstOccurrence() {
	}

	@Test
	public void testRemoveLastOccurrence() {
	}

	@Test
	public void testOffer() {
	}

	@Test
	public void testRemove() {
	}

	@Test
	public void testPoll() {
	}

	@Test
	public void testElement() {
	}

	@Test
	public void testPeek() {
	}

	@Test
	public void testPush() {
	}

	@Test
	public void testPop() {
	}

	@Test
	public void testDescendingIterator() {
	}

	@Test
	public void testSize() {
	}

	@Test
	public void testIsEmpty() {
		
	}

	@Test
	public void testContains() {
	
	}

	@Test
	public void testIterator() {
		
	}

	@Test
	public void testToArray() {
	
	}

	@Test
	public void testToArray2() {
	}

	@Test
	public void testAdd2() {
	}

	@Test
	public void testRemove2() {
		
	}

	@Test
	public void testContainsAll() {
		
	}

	@Test
	public void testAddAll() {
	}

	@Test
	public void testAddAll2() {
		
	}

	@Test
	public void testRemoveAll() {
		
	}

	@Test
	public void testRetainAll() {
		
	}

	@Test
	public void testClear() {
		
	}

	@Test
	public void testGet(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		assertEquals("Third", list.get(2));
	}

	@Test
	public void testSet() {
		
	}

	@Test
	public void testAdd() {
		
	}

	@Test
	public void testRemove3(){
		
	}

	@Test
	public void testIndexOf(){
		
	}

	@Test
	public void testlastIndexOf(){
	}

	@Test
	public void testListIterator() {
		
	}

	@Test
	public void testListIterator2() {
		
	}

	@Test
	public void testSubList() {
		
	}

	@Test
	public void testToString(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertEquals("{}", list.toString());
		assertEquals(true, list.add(1));
		assertEquals("{1}", list.toString());
		
		for (int i = 2; i <= 10; i++){
			list.addLast(i);
		}
		assertEquals("{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}", list.toString());
	}
}