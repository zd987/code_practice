package deepIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompositeItem c1 = new CompositeItem();
		CompositeItem c2 = new CompositeItem();
		c1.add(new Item(1));
		c2.add(new Item(2));
		c2.add(new Item(3));
		c1.add(c2);
		c1.add(new Item(4));
		Iterator it = new DeepIterator(c1.createIterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
