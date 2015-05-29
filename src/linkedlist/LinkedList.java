package linkedlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
	private static final long serialVersionUID = 1234234234L;
	private Node<E> head = null;
	private int size = 0;

	private static class Node<T> {
		private T data;
		private Node<T> next;

		private Node(T data){
			this.data = data;
			this.next = null;
		}
	}

	public LinkedList(){
		this.size = 0;
		this.head = null;
	}

	@Override
	public void addFirst(E value) {
		if (this.head == null){
			this.head = new Node<E>(value);
		} else {
			Node<E> node = new Node<E>(value);
			node.next = this.head;
			this.head = node;
		}
		size++;
	}

	@Override
	public void addLast(E value) {
		if (this.head == null){
			this.head = new Node<E>(value);
		} else {
			Node<E> pointer = this.head;
			while (pointer.next != null){
				pointer = pointer.next;
			}
			pointer.next = new Node<E>(value);
		}
		size++;
	}

	@Override
	public boolean offerFirst(E value) {
		if (this.head == null){
			this.head = new Node<E>(value);
		} else {
			Node<E> node = new Node<E>(value);
			node.next = this.head;
			this.head = node;
		}
		size++;
		return true;
	}

	@Override
	public boolean offerLast(E value) {
		if (this.head == null){
			this.head = new Node<E>(value);
		} else {
			Node<E> pointer = this.head;
			while (pointer.next != null){
				pointer = pointer.next;
			}
			pointer.next = new Node<E>(value);
		}
		size++;
		return true;
	}

	@Override
	public E removeFirst() {
		if (this.head == null){
			throw new UnsupportedOperationException("The list is empty, no first element found.");
		}
		E data = this.head.data;
		this.head = this.head.next;
		size--;
		return data;
	}

	@Override
	public E removeLast() {
		if (this.head == null){
			return null;
		}
		E data = this.head.data;
		this.head = this.head.next;
		size--;
		return data;
	}

	@Override
	public E pollFirst() {
		return (this.head == null || this.size == 0) ? null : this.removeFirst();
	}

	@Override
	public E pollLast() {
		return (this.head == null || this.size == 0) ? null : this.removeLast();
	}

	@Override
	public E getFirst() {
		if (this.head == null){
			throw new UnsupportedOperationException("The list is empty, no first element found.");
		} else {
			return this.head.data;
		}
	}

	@Override
	public E getLast() {
		if (this.head == null){
			throw new UnsupportedOperationException("The list is empty, no first element found.");
		} else {
			Node<E> pointer = this.head;
			while (pointer.next == null){
				pointer = pointer.next;
			}
			return pointer.data;
		}
	}

	@Override
	public E peekFirst() {
		return this.head == null ? null: this.head.data;
	}

	@Override
	public E peekLast() {
		if (this.head == null){
			return null;
		}
		Node<E> pointer = this.head;
		while (pointer.next == null){
			pointer = pointer.next;
		}
		return pointer.data;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E value) {
		return this.offerLast(value);
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public E poll() {
		return pollFirst();
	}

	@Override
	public E element() {
		if (this.head == null){
			throw new UnsupportedOperationException("The list is empty, no first element found.");
		}
		return this.head.data;
	}

	@Override
	public E peek() {
		return (this.head == null) ? null : this.head.data;
	}

	@Override
	public void push(E value) {
		this.addFirst(value);
	}

	@Override
	public E pop() {
		return this.removeFirst();
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public boolean contains(Object o) {
		if (this.head == null){
			return false;
		}
		Node<E> pointer = this.head;
		while (pointer.next != null){
			if (o == null){
				if (pointer.data == null){
					return true;
				}
			} else if (o.equals(pointer.data)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		if (this.size == 0 || this.head == null){
			return new Object[0];
		}
		Object [] array = new Object[size];
		Node<E> pointer = this.head;
		int arrayIndex = 0;
		while (pointer.next != null){
			array[arrayIndex++] = pointer.data;
			pointer = pointer.next;
		}
		return array;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> T[] toArray(T[] a) {
		if (this.size == 0 || this.head == null){
			return Arrays.copyOf(a, 0);
		}
		T[] array = Arrays.copyOf(a, this.size);
		Object[] objectsArray = this.toArray();
		int arrayIndex = 0;
		for (Object object: objectsArray){
			array[arrayIndex++] = (T) object;
		}
		return array;
	}

	@Override
	public boolean add(E value) {
		if (this.head == null){
			this.head = new Node<E>(value);
			size++;
			return true;
		}
		Node<E> pointer = this.head;
		while (pointer.next != null){
			pointer = pointer.next;
		}
		pointer.next = new Node<E>(value);
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (this.head == null){
			return false;
		}
		if (this.head.next == null){
			if (o == null){
				if (this.head.data == null){
					this.head = null;
					size--;
					return true;
				}
			} else if (o.equals(this.head.data)) {
				this.head = null;
				size--;
				return true;
			}
			return false;
		}

		Node<E> prev = this.head;
		Node<E> curr = this.head.next;

		while (curr != null){
			if (o == null){
				if (curr.data == null){
					prev.next = curr.next;
					size--;
					return true;
				}
			} else if (o.equals(this.head.data)) {
				prev.next = curr.next;
				size--;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (c == null){
			throw new NullPointerException ("Null collection provided.");
		}
		if (c.isEmpty()){
			return false;
		}
		Iterator<?> iterator = c.iterator();
		while (iterator.hasNext()){
			if (!this.contains(iterator.next())){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c == null){
			throw new NullPointerException ("Null collection provided.");
		}
		if (c.isEmpty()){
			return false;
		}
		int originalSize = this.size;
		Iterator<? extends E> iterator = c.iterator();
		while (iterator.hasNext()){
			this.add(iterator.next());
		}
		return originalSize != this.size;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if (index < 0 || index > this.size){
			throw new IndexOutOfBoundsException("Index (" + index + ") is out of range for list of size: " + size);
		}
		if (c == null){
			throw new NullPointerException ("Null collection provided.");
		}
		if (c.isEmpty()){
			return false;
		}
		int originalSize = this.size;
		Iterator<? extends E> iterator = c.iterator();
		while (iterator.hasNext()){
			int previousSize = this.size;
			this.add(index, iterator.next());
			if (this.size > previousSize){
				index++;
			}
		}
		return originalSize != this.size;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (c == null){
			throw new NullPointerException ("Null collection provided.");
		}
		if (c.isEmpty()){
			return false;
		}
		int originalSize = this.size;
		Iterator<?> iterator = c.iterator();
		while (iterator.hasNext()){
			this.remove(iterator.next());
		}
		return originalSize != this.size;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if (c == null){
			throw new NullPointerException ("Null collection provided.");
		}
		int originalSize = this.size;
		if (c.size() == 0){
			this.head = null;
			this.size = 0;
			return originalSize > 0;
		}
		if (this.head == null || this.size == 0){
			return false;
		}
		if (this.head.next == null){
			if (c.contains(this.head.data)){
				return false;
			} else {
				this.head = null;
				this.size = 0;
				return true;
			}
		}
		Node<E> prev = this.head;
		Node<E> curr = this.head.next;
		while (curr != null){
			if (!c.contains(curr.data)){
				prev.next = curr.next;
				this.size--;
				prev = curr.next;
				if (curr.next == null){
					return true;
				} else {
					curr = curr.next.next;
				}
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return this.size != originalSize;
	}

	@Override
	public void clear() {
		this.head = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index (" + index + ") is out of range for list of size: " + size);
		}
		if (index == 0){
			return this.head.data;
		} else {
			int elementIndex = 0;
			E data = this.head.data;
			Node<E> pointer = this.head;
			while (pointer != null){
				if (elementIndex == index){
					data = pointer.data;
				}
				pointer = pointer.next;
				elementIndex++;
			}
			return data;
		}
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index (" + index + ") is out of range for list of size: " + size);
		}
		E oldData = this.head.data;
		if (index == 0){	
			this.head.data = element;
			return oldData;
		} else {
			int elementIndex = 0;
			Node<E> pointer = this.head;
			while (pointer != null){
				if (elementIndex == index){
					oldData = pointer.data;
					pointer.data = element;
					return oldData;
				}
				pointer = pointer.next;
				elementIndex++;
			}
			return oldData;
		}
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		if (this.head == null){
			return -1;
		}
		if (this.head.next == null){
			return (o == null) ? ((this.head.data == null) ? 0 : -1) : (o.equals(this.head.data) ? 0 : -1);
		} 
		Node<E> pointer = this.head;
		int index = 0;
		while (pointer != null){
			if (o == null){
				if (pointer.data == null){
					return index;
				}
			} else if (o.equals(pointer.data)){
				return index;
			} else {
				pointer = pointer.next;
				index++;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (this.head == null){
			return -1;
		}
		if (this.head.next == null){
			return (o == null) ? ((this.head.data == null) ? 0 : -1) : (o.equals(this.head.data) ? 0 : -1);
		} 
		Node<E> pointer = this.head;
		int index = 0;
		int foundIndex = -1;
		while (pointer != null){
			if (o == null){
				if (pointer.data == null){
					foundIndex = index;
				}
			} else if (o.equals(pointer.data)){
				foundIndex = index;
			} 
			pointer = pointer.next;
			index++;
		}
		return foundIndex;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(){
		if (this.head == null){
			return "{}";
		}
		StringBuffer start = new StringBuffer("{" + this.head.data);
		Node<E> pointer = this.head.next;
		while (pointer != null){
			start.append(", " + pointer.data);
			pointer = pointer.next;
		}
		return start.append("}").toString();
	}
}
