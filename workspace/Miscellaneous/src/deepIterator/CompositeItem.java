package deepIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeItem extends Component{
	ArrayList<Component> list;
	public CompositeItem() {
		this.list = new ArrayList<Component>();
	}
	@Override
	public Iterator createIterator() {
		return new CompositeItemIterator(list);
	}
	public void add(Component c){
		this.list.add(c);
	}
}
