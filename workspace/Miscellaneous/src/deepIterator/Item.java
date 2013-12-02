package deepIterator;

import java.util.Iterator;

public class Item extends Component{
	private Integer val;
	public Item(Integer val){
		this.val = val;
	}
	
	@Override
	public String toString(){
		return "" + val;
	}
	
	public Iterator createIterator(){
		return new NullIterator();
	}
}
