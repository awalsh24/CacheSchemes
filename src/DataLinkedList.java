/**
 * @author Shannon Duvall
 * 
 * This class implements a doubly linked list of Data objects.
 */ 

public class DataLinkedList {
	
	// Keep pointers to the first and last in the list.
	private Data first;
	private Data last;
	
	/**
	 * Removes an object from the list
	 * @param data	Data object to remove
	 */
	
	public void remove(Data data){
		Data firstOne = data.getPrevious();
		Data secondOne  = data.getNext();
		// This is the only item in the cache
		if(firstOne == null && secondOne == null){
			first = null;
			last = null;
		}
		// I'm removing the first thing in the list
		else if(firstOne == null){
			first = secondOne;
			secondOne.setPrevious(null);
			//secondOne.before = null;
		}
		// I'm removing the last thing in the list
		else if(secondOne == null){
			last = firstOne;
			firstOne.setNext(null);
			//firstOne.after = null;
		}
		// I'm removing from the middle of the list
		else{
			firstOne.setNext(secondOne);
			secondOne.setPrevious(firstOne);
		}
		data.setNext(null);
		data.setPrevious(null);
	}
	
	/**
	 *
	 * Remove and return the first element in a linked list
	 * 
	 */
	public Data removeFirst(){
		Data toDeliver = first;
		remove(first);
		return toDeliver;
	}
	
	public Data removeLast(){
		Data toDeliver = last;
		remove(last);
		return toDeliver;
	}
	
	public void addToEnd(Data data){
		if(last != null){
			last.setNext(data);
			data.setPrevious(last);
			//last.after = data;
			//data.before = last;
		}
		else{
			first = data;
		}
		last = data;
	}
	
	/**
	 * Adds a new Data to the front of the list.
	 * 
	 * @param data	Data object to add.
	 */
	public void addToBeginning(Data data) {
		if(first != null){
			first.setPrevious(data);
			data.setNext(first);
			//last.after = data;
			//data.before = last;
		}
		else{
			last = data;
		}
		first = data;
	}
	
	
	public Data getFirst() {
		return first;
	}
	
	public Data getLast() {
		return last;
	}
	
	/**
	 * toString
	 * 
	 * Used for debugging and testing, 
	 * returns the string "empty list" or a 
	 * String representing the Data from front to back.
	 */
	public String toString() {
		if (first == null) {
			return "empty list";
		}
		String s = first.toString();
		Data current = first.getNext();
		while(current != null) {
			s+=", "+current.toString();
			current = current.getNext();
		}
		s+= "\n";
		return s;
	}
	
	/*
	 * Testing my implementation
	 */
	public void testList() {
		first = null;
		last = null;
		addToBeginning(new Data('3'));
		addToBeginning(new Data('2'));
		addToBeginning(new Data('1'));
		addToEnd(new Data('4'));
		addToEnd(new Data('5'));
		System.out.println(this.toString());
		System.out.println(removeFirst());
		System.out.println(removeLast());
		System.out.println(removeFirst());
		System.out.println(removeLast());
		System.out.println(removeFirst());
		System.out.println(this.toString());
		
	}
	
	/*
	public static void main(String[] args) {
		DataLinkedList l = new DataLinkedList();
		l.testList();
	}
	*/
	
}
