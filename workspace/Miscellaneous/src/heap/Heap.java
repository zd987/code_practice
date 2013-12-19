/**
* Copyright ? 2013年12月19日 
* Miscellaneous 下午9:40:20
* Version 1.0
* All right reserved.
*
*/

package heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: 2013年12月19日 下午9:40:20
 * Version: 1.0
 */
public class Heap<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private Object[] queue;
	private int size = 0;
	private final Comparator<? super E> comparator;
	public Heap(){
		this(DEFAULT_INITIAL_CAPACITY, null);
	}
	
	public Heap(int initialCapacity){
		this(initialCapacity, null);
	}
	
	public Heap(int initialCapacity, Comparator<? super E> comparator){
		if(initialCapacity < 1)
			throw new IllegalArgumentException();
		this.queue = new Object[initialCapacity];
		this.comparator = comparator;
	}
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	private void grow(int minCapacity){
		int oldCapacity = queue.length;
		int newCapacity = oldCapacity + ((oldCapacity < 64) ?
										(oldCapacity + 2) :
										(oldCapacity >> 1));
		if(newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		queue = Arrays.copyOf(queue, newCapacity);
			
	}
	private static int hugeCapacity(int minCapacity){
		if(minCapacity < 0)
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ?
			Integer.MAX_VALUE:
			MAX_ARRAY_SIZE;
	}
	public boolean offer(E e){
		if(e == null)
			throw new NullPointerException();
		int i = size;
		if(i >= queue.length)
			grow(i + 1);
		size = i + 1;
		if(i == 0) 
			queue[0] = e;
		else 
			siftUp(i, e);
		return true;
	}
	public E peek(){
		if(size == 0)
			return null;
		return (E) queue[0];
	}
	private int indexOf(Object o){
		if(o != null){
			for(int i = 0; i < size; i++)
				if(o.equals(queue[i]))
					return i;
		}
		return -1;
	}
	public boolean remove(Object o){
		int i = indexOf(o);
		if(i == -1)
			return false;
		else {
			removeAt(i);
			return true;
		}
	}
	public boolean contains(Object o){
		return indexOf(o) != -1;
	}
	public Object[] toArray(){
		return Arrays.copyOf(queue, size);
	}
	public int size(){
		return size;
	}
	public void clear(){
		for(int i = 0; i < size; i++)
			queue[i] = null;
		size = 0;
	}
	public E poll(){
		if(size == 0)
			return null;
		int s = --size;
		E result = (E) queue[0];
		E x = (E) queue[s];
		queue[s] = null;
		if(s != 0)
			siftDown(0, x);
		return result;		
	}
	private E removeAt(int i){
		int s = --size;
		if(s == i)
			queue[i] = null;
		else {
			E moved = (E) queue[s];
			queue[s] = null;
			siftDown(i, moved);
			if(queue[i] == moved) {
				siftUp(i, moved);
				if(queue[i] != moved)
					return moved;
			}
		}
		return null;
	}
	private void siftUp(int k, E x){
		if(comparator != null)
			siftUpUsingComparator(k, x);
		else 
			siftUpComparable(k, x);
	}
	private void siftUpComparable(int k, E x){
		Comparable<? super E> key = (Comparable<? super E>) x;
		while(k > 0){
			int parent = (k - 1) >>> 1;
			Object e = queue[parent];
			if(key.compareTo((E)e) >= 0)
				break;
			queue[k] = e;
			k = parent;
		}
		queue[k] = key;
	}
	private void siftUpUsingComparator(int k, E x){
		while(k > 0){
			int parent = (k - 1) >>> 1;
			Object e = queue[parent];
			if(comparator.compare(x, (E) e) >= 0)
				break;
			queue[k] = e;
			k = parent;
		}
		queue[k] = x;
	}
	private void siftDown(int k, E x){
		if(comparator != null)
			siftDownUsingComparator(k, x);
		else
			siftDownComparable(k, x);
	}
	private void siftDownComparable(int k, E x){
		Comparable<? super E> key = (Comparable<? super E>)x;
		int half = size >>> 1;
		while(k < half){
			int child = (k << 1) + 1;
			Object c = queue[child];
			int right = child + 1;
			if(right < size &&
				((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
				c = queue[child = right];
			if(key.compareTo((E) c) <= 0)
				break;
			queue[k] = c;
			k = child;
		}
		queue[k] = key;
	}
	private void siftDownUsingComparator(int k, E x){
		int half = size >>> 1;
		while(k < half){
			int child = (k << 1) + 1;
			Object c = queue[child];
			int right = child + 1;
			if(right < size &&
				comparator.compare((E) c, (E)queue[right]) > 0)
				c = queue[child = right];
			if(comparator.compare(x, (E) c) <= 0)
				break;
			queue[k] = c;
			k = child;
		}
		queue[k] = x;
	}
	private void heapify(){
		for(int i = (size >>> 1) - 1; i >= 0; i--)
			siftDown(i, (E)queue[i]);
	}
}
