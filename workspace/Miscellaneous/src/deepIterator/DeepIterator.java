package deepIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DeepIterator implements Iterator{
	Stack<Iterator> s = new Stack<Iterator>();
	
	public DeepIterator(Iterator it) {
		s.add(it);
	}
	
	@Override
	public boolean hasNext() {
		if(s.isEmpty()) {
			return false;
		} else {
			Iterator it = s.peek();
			if(!it.hasNext()){
				s.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	@Override
	public Object next() {
		Iterator it = s.peek();
		Component c = (Component)it.next();
		if(c instanceof CompositeItem){
			CompositeItem ci = (CompositeItem)c;
			s.push(ci.createIterator());
			return ci;
		}
		return c;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
