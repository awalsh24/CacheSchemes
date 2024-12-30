/**
 * Data.java
 * 
 * This class represents the data being stored in the cache.  
 * 
 * While the main data being stored is a character, we use this object
 * so we can also include meta data that will help implement a 
 * cache scheme, like whether or not the Data is currently in the cache, 
 * when it became cached, and how often it is requested.
 * 
 * This class also includes before and after pointers to Data objects,
 * making it the basis of a doubly-linked list.
 * 
 * This class implements the Comparable interface, which means that 
 * outside this class one can add Data to a priority queue or describe one Data 
 * as "less than", "greater than", or "equal to" another.  
 * 
 * @author Shannon Duvall
 * 
 */
public class Data implements Comparable<Data>{
	private Data before = null;
	private Data after = null;
	private Character letter = null;
	//private boolean cached = false;
	private int frequency = 0;
	private int time = 0;
	
	public Data(char character) {
		letter = character;
	}
	
	public Data(char character, int timeCreated) {
		letter = character;
		time = timeCreated;
	}
	
	/*
	 * Methods for data access
	 */
	
	/*
	 * Data are compared based on frequency first, 
	 * then time as a tie breaker.
	 */
	public int compareTo(Data other){
		if(this.frequency== other.frequency){
			return this.time - other.time;
		}
		return this.frequency-other.frequency;
	}
	
	public void setData(char newLetter) {
		letter = newLetter;
	}
	
	public char getData() {
		return letter;
	}
	
	public void nullData() {
		letter = null;
	}
	
	/*
	 * Methods for frequency access
	 */
	public void addFrequency() {
		frequency += 1;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void resetFrequency() {
		frequency = 0;
	}
	
	/*
	 * Methods for cache toggling
	 
	public void cache() {
		cached = true;
	}
	
	public void unCache() {
		cached = false;
	}
	
	public boolean isCached() {
		return cached;
	}
	*/
	
	/* Methods for time access
	 * 
	 */
	public void setTime(int newTime) {
		time = newTime;
	}
	
	public int getTime() {
		return time;
	}
	
	public void resetTime() {
		time = 0;
	}
	
	/*
	 * Methods for the linked list maintenance
	 */
	
	public void setNext(Data afterData) {
		after = afterData;
	}
	public void setPrevious(Data beforeData) {
		before = beforeData;
	}
	
	public Data getNext() {
		return after;
	}
	
	public Data getPrevious() {
		return before;
	}
	
	/*
	 * Methods for debugging help
	 */
	
	public String toString() {
		return ""+letter+": freq= "+frequency+" time = "+time;
	}
	
	public void printList() {
		System.out.println(this);
		if(after != null) {
			after.printList();;
		}
	}
	
}
