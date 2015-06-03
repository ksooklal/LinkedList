package linkedlist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.junit.Test;

@SuppressWarnings(value = {"rawtypes", "unchecked"})
public class LinkedListUnitTest {

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
		LinkedList<int []> listOfArrays = new LinkedList<int []>();
		assertEquals(0, listOfArrays.size());

		assertEquals(true, listOfArrays.offerFirst(new int [] {2, 234}));
		assertEquals(1, listOfArrays.size());
		int [] storedArray = listOfArrays.get(0);
		assertEquals(2, storedArray[0]);
		assertEquals(234, storedArray[1]);

		assertEquals(true, listOfArrays.offerFirst(new int [] {9129, 123901, 12309}));
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
	public void testOfferLast(){
		LinkedList<int []> listOfArrays = new LinkedList<int []>();
		assertEquals(0, listOfArrays.size());

		assertEquals(true, listOfArrays.offerLast(new int [] {2, 234}));
		assertEquals(1, listOfArrays.size());
		int [] storedArray = listOfArrays.get(0);
		assertEquals(2, storedArray[0]);
		assertEquals(234, storedArray[1]);

		assertEquals(true, listOfArrays.offerLast(new int [] {9129, 123901, 12309}));
		assertEquals(2, listOfArrays.size());

		int previousStoredArray [] = listOfArrays.get(0);
		assertEquals(2, previousStoredArray[0]);
		assertEquals(234, previousStoredArray[1]);

		int [] newStoredArray = listOfArrays.get(1);
		assertEquals(9129, newStoredArray[0]);
		assertEquals(123901, newStoredArray[1]);
		assertEquals(12309, newStoredArray[2]);

		assertEquals(true, listOfArrays.offerLast(new int [] {23, 31, 37}));
		assertEquals(3, listOfArrays.size());
		int [] nextStoredArray = listOfArrays.get(2);
		assertEquals(23, nextStoredArray[0]);
		assertEquals(31, nextStoredArray[1]);
		assertEquals(37, nextStoredArray[2]);
	}

	private static <T> Object testRemoveFirstWithExceptions(LinkedList<T> list){
		Object object = null;
		if (list != null){
			try{
				object = list.removeFirst();
			} catch (UnsupportedOperationException uoe){
				return uoe.getMessage();
			}
		}
		return object;
	}

	@Test
	public void testRemoveFirst(){
		LinkedList<Boolean> list = new LinkedList<Boolean>();
		assertEquals(null, testRemoveFirstWithExceptions(null));
		assertEquals("The list is empty, no first element found.", testRemoveFirstWithExceptions(list));
		assertEquals(true, list.add(true));
		assertEquals(true, list.add(false));
		assertEquals(2, list.size());
		assertEquals(true, testRemoveFirstWithExceptions(list));
		assertEquals(false, list.removeFirst());
		
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
		LinkedList<Short> list = new LinkedList<Short>();
		
		assertEquals(null, list.peekFirst());
		short a = 234;
		assertEquals(true, list.add(a = 234));
		assertEquals(true, list.add(a++));
		assertEquals(--a, list.peekFirst().shortValue());
	}

	@Test
	public void testPeekLast() {
		LinkedList<Short> list = new LinkedList<Short>();
		
		assertEquals(null, list.peekLast());
		short a = 234;
		assertEquals(true, list.add(a = 234));
		assertEquals(234, list.peekLast().shortValue());
		assertEquals(true, list.add(a++));
		assertEquals(--a, list.peekFirst().shortValue());
	}

	@Test
	public void testRemoveFirstOccurrence() {
		LinkedList<Long> list = new LinkedList<Long>();
		assertEquals(false, list.removeFirstOccurrence("ASFDA"));
		assertEquals(true, list.add(23423l));
		assertEquals(1, list.size());
		assertEquals(false, list.removeFirstOccurrence(new Long(234234)));
		assertEquals(false, list.removeFirstOccurrence(null));
		assertEquals(true, list.removeFirstOccurrence(23423l));
		assertEquals(0, list.size());
		assertEquals(true, list.add(null));
		assertEquals(true, list.removeFirstOccurrence(null));
		assertEquals(0, list.size());
		
		assertEquals(true, list.add(new Long(234)));
		assertEquals(true, list.add(new Long(234234)));
		assertEquals(true, list.add(new Long(2342390)));
		assertEquals(3, list.size());
		assertEquals(false, list.removeFirstOccurrence(234234234234l));
		assertEquals(true, list.removeFirstOccurrence(2342390l));
		assertEquals(2, list.size());
		assertEquals(true, list.add(null));
		assertEquals(true, list.add(null));
		assertEquals(true, list.removeFirstOccurrence(null));
		assertEquals(3, list.size());
	}

	@Test
	public void testRemoveLastOccurrence() {
	}

	@Test
	public void testOffer() {
	}

	@Test
	public void testRemove() {
		LinkedList<Long> list = new LinkedList<Long>();
		assertEquals(false, list.remove("ASFDA"));
		assertEquals(true, list.add(23423l));
		assertEquals(1, list.size());
		assertEquals(false, list.remove(new Long(234234)));
		assertEquals(false, list.remove(null));
		assertEquals(true, list.remove(23423l));
		assertEquals(0, list.size());
		assertEquals(true, list.add(null));
		assertEquals(true, list.remove(null));
		assertEquals(0, list.size());
		
		assertEquals(true, list.add(new Long(234)));
		assertEquals(true, list.add(new Long(234234)));
		assertEquals(true, list.add(new Long(2342390)));
		assertEquals(3, list.size());
		assertEquals(false, list.remove(234234234234l));
		assertEquals(true, list.remove(2342390l));
		assertEquals(2, list.size());
		assertEquals(true, list.add(null));
		assertEquals(true, list.add(null));
		assertEquals(true, list.remove(null));
		assertEquals(3, list.size());
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
		LinkedList<Set> listOfSets = new LinkedList<Set>();
		assertEquals(true, listOfSets.isEmpty());
		assertEquals(true, listOfSets.add(new TreeSet()));
		assertEquals(false, listOfSets.isEmpty());
		assertEquals(new TreeSet(), listOfSets.remove());
		assertEquals(true, listOfSets.isEmpty());
	}

	@Test
	public void testContains() {
		LinkedList<Float> list = new LinkedList<Float>();
		assertEquals(false, list.contains("here"));
		assertEquals(true, list.add(2.354f));
		assertEquals(false, list.contains(null));
		assertEquals(true, list.add(234f));
		assertEquals(true, list.add(234234f));
		assertEquals(3, list.size());
		assertEquals(false, list.contains(null));
		assertEquals(true, list.add(null));
		assertEquals(true, list.contains(null));
		assertEquals(true, list.contains(234f));
		assertEquals(false, list.contains(234));
	
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

	private static <T> Object testRemoveAllWithExceptions(LinkedList<T> list, Collection<?> c){
		Object returned = null;
		if (list != null){
			try{
				returned = list.removeAll(c);
			} catch (NullPointerException npe){
				returned = npe.getMessage();
			}
		}
		return returned;
	}
	
	@Test
	public void testRemoveAll() {
		LinkedList<Character> list = new LinkedList<Character>();
		assertEquals(null, testRemoveAllWithExceptions(null, null));
		assertEquals("Null collection provided.", testRemoveAllWithExceptions(list, null));
		assertEquals(false, testRemoveAllWithExceptions(list, new Stack()));
		Stack stack = new Stack();
		stack.add('c');
		assertEquals(false, testRemoveAllWithExceptions(list, stack));
		assertEquals(true, list.add('d'));
		assertEquals(true, list.add('a'));
		assertEquals(true, list.add('b'));
		assertEquals(false, testRemoveAllWithExceptions(list, stack));
		assertEquals(3, list.size());
		assertEquals(true, list.add('e'));
		assertEquals(false, testRemoveAllWithExceptions(list, stack));
		assertEquals(true, list.add('c'));
		assertEquals(true, testRemoveAllWithExceptions(list, stack));
		assertEquals(4, list.size());
		assertEquals(true, list.add('c'));
		stack.add('e');
		assertEquals(true, testRemoveAllWithExceptions(list, stack));
		assertEquals(3, list.size());
		assertEquals(true, list.add('c'));
		assertEquals(true, list.add('e'));
		stack.add('f');
		assertEquals(true, testRemoveAllWithExceptions(list, stack));
		assertEquals(3, list.size());
		assertEquals(false, list.contains('c'));
		assertEquals(true, list.contains('b'));
		stack.add('d');
		stack.add('b');
		stack.add('g');
		stack.add('h');
		assertEquals(true, testRemoveAllWithExceptions(list, stack));
		assertEquals(1, list.size());
		stack.push('a');
		stack.push('c');
		assertEquals(true, testRemoveAllWithExceptions(list, stack));
		assertEquals(0, list.size());
	}

	@Test
	public void testRetainAll() {

	}

	@Test
	public void testClear() {
		LinkedList<String> list = new LinkedList<String>();
		assertEquals(0, list.size());
		list.clear();
		assertEquals(0, list.size());
		list.add("Baltimore");
		list.add("Annapolis");
		list.add("Silver Spring");
		assertEquals(3, list.size());
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testGet(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		assertEquals("Third", list.get(2));

		assertEquals("Index (-123) is out of range for list of size: 4",  testGetWithExceptions(list, -123));
		assertEquals("Fourth", testGetWithExceptions(list, 3));
		assertEquals(null, testGetWithExceptions(null, 123));
	}

	private static <T> Object testGetWithExceptions(LinkedList<T> list, int index){
		Object element = null;
		if (list != null){
			try{
				element = list.get(index);
			} catch (IndexOutOfBoundsException ie){
				element = ie.getMessage();
			}
		}
		return element;
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
		LinkedList<String> list = new LinkedList<String>();
		assertEquals(-1, list.indexOf("2"));
		assertEquals(true, list.add("234"));
		assertEquals(0, list.indexOf("234"));
		assertEquals(true, list.add("234234"));
		assertEquals(-1, list.indexOf("2"));
		assertEquals(-1, list.indexOf(null));
		assertEquals(1, list.indexOf("234234"));
		assertEquals(true, list.add("35"));
		assertEquals(-1, list.indexOf(35));
		assertEquals(1, list.indexOf("234234"));
		assertEquals(2, list.indexOf("35"));
		assertEquals(true, list.remove("35"));
		assertEquals(-1, list.indexOf("35"));
		assertEquals(true, list.add(null));
		assertEquals(2, list.indexOf(null));

		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.add(null));
		assertEquals(0, list.indexOf(null));
		assertEquals(true, list.add(null));
		assertEquals(0, list.indexOf(null));
		assertEquals(-1, list.indexOf(234));
		assertEquals(null, list.set(0, "asdfasdf"));
		assertEquals(-1, list.indexOf("23423"));
		assertEquals(0, list.indexOf("asdfasdf"));
		assertEquals(true, list.add("asdf"));
		assertEquals(true, list.add(null));
		assertEquals(true, list.add(null));
		assertEquals(1, list.indexOf(null));
	}

	@Test
	public void testlastIndexOf(){
		LinkedList<String> list = new LinkedList<String>();
		assertEquals(-1, list.lastIndexOf("2"));
		
		assertEquals(true, list.add("234"));
		assertEquals(true, list.add("234"));
		assertEquals(1, list.lastIndexOf("234"));
		assertEquals(true, list.add("234"));
		assertEquals(2, list.lastIndexOf("234"));


		assertEquals(-1, list.lastIndexOf("2"));
		assertEquals(true, list.add("2"));
		assertEquals(3, list.lastIndexOf("2"));
		assertEquals(true, list.add("234"));
		
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.add(null));
		assertEquals(0, list.lastIndexOf(null));
		assertEquals(-1, list.lastIndexOf(234));
		assertEquals(null, list.set(0, "asdfasdf"));
		assertEquals(-1, list.lastIndexOf("23423"));
		assertEquals(0, list.lastIndexOf("asdfasdf"));
		assertEquals(true, list.add("asdf"));
		assertEquals(true, list.add(null));
		assertEquals(true, list.add(null));
		assertEquals(3, list.lastIndexOf(null));
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