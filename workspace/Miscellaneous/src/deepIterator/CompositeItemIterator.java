package deepIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeItemIterator implements Iterator {
	ArrayList<Component> list;
	int pos;
	public CompositeItemIterator(ArrayList<Component> list){
		this.list = list;
		pos = 0;
	}
	
	@Override
	public boolean hasNext() {
		return pos < list.size();
	}

	@Override
	public Object next() {
		return list.get(pos++);
	}

	@Override
	public void remove() {
		throw new java.lang.UnsupportedOperationException();
	}

}
