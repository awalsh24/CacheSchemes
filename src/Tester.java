/**
 * @author sduvall2
 * 
 * Tester.java
 * 
 * Tests cache scheme algorithms to see if they return correct 
 * numbers of collisions on test sets.
 * 
 * Run with JUnit 5
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Tester{
	private FIF fif;
	private LFU lfu;
	private FIFO fifo;
	private LRU lru;
	private LIFO lifo;
	
	public Tester(){
		super();
		fif = new FIF();
		lfu = new LFU();
		fifo = new FIFO();
		lru = new LRU();
		lifo = new LIFO();
	}
	
	public void assertEquals2(String message, int correct, int computed) {
		assertEquals(correct, computed, message);
	}
	@Test
	public void testFIFO() {
		//assertEquals(4 ,fifo.numCollisions(10,"abcdefghijklabab"),"fifo(10,abcdefghijklabab)");
		assertEquals2("fifo(10,abcdefghijklabab)", 4 ,fifo.numCollisions(10,"abcdefghijklabab"));
		assertEquals2("fifo(100,abcdefecbab)", 0 ,fifo.numCollisions(100,"abcdefecbab"));
		assertEquals2("fifo(3,abcdefecbab)", 6 ,fifo.numCollisions(3,"abcdefecbab"));
		assertEquals2("fifo(3,723a1w31w21q)", 7 ,fifo.numCollisions(3,"723a1w31w21q"));
		assertEquals2("fifo(3,837y873681927368)", 11 ,fifo.numCollisions(3,"837y873681927368"));
		assertEquals2("fifo(3,abababab)", 0 ,fifo.numCollisions(3,"abababab"));
		assertEquals2("fifo(3,abcdcefdbcda)", 7 ,fifo.numCollisions(3,"abcdcefdbcda"));
		assertEquals2("fifo(4,abcdefecbab)", 4 ,fifo.numCollisions(4,"abcdefecbab"));
		assertEquals2("fifo(4,723a1w31w21q)", 4 ,fifo.numCollisions(4,"723a1w31w21q"));
		assertEquals2("fifo(4,837y873681927368)", 9 ,fifo.numCollisions(4,"837y873681927368"));
		assertEquals2("fifo(4,abababab)", 0 ,fifo.numCollisions(4,"abababab"));
		assertEquals2("fifo(4,abcdcefdbcda)", 6 ,fifo.numCollisions(4,"abcdcefdbcda"));
		assertEquals2("fifo(5,abcdefecbab)", 3 ,fifo.numCollisions(5,"abcdefecbab"));
		assertEquals2("fifo(5,723a1w31w21q)", 2 ,fifo.numCollisions(5,"723a1w31w21q"));
		assertEquals2("fifo(5,837y873681927368)", 7 ,fifo.numCollisions(5,"837y873681927368"));
		assertEquals2("fifo(5,abababab)", 0 ,fifo.numCollisions(5,"abababab"));
		assertEquals2("fifo(5,abcdcefdbcda)", 2 ,fifo.numCollisions(5,"abcdcefdbcda"));
	}
	
	@Test
	public void testLRU(){
		assertEquals2("lru(10,abcdefghijklabab)", 4 ,lru.numCollisions(10,"abcdefghijklabab"));
		assertEquals2("lru(100,abcdefecbab)", 0 ,lru.numCollisions(100,"abcdefecbab"));
		assertEquals2("lru(3,abcdefecbab)", 6 ,lru.numCollisions(3,"abcdefecbab"));
		assertEquals2("lru(3,723a1w31w21q)", 6 ,lru.numCollisions(3,"723a1w31w21q"));
		assertEquals2("lru(3,837y873681927368)", 12 ,lru.numCollisions(3,"837y873681927368"));
		assertEquals2("lru(3,abababab)", 0 ,lru.numCollisions(3,"abababab"));
		assertEquals2("lru(3,abcdcefdbcda)", 7 ,lru.numCollisions(3,"abcdcefdbcda"));
		assertEquals2("lru(4,abcdefecbab)", 4 ,lru.numCollisions(4,"abcdefecbab"));
		assertEquals2("lru(4,723a1w31w21q)", 4 ,lru.numCollisions(4,"723a1w31w21q"));
		assertEquals2("lru(4,837y873681927368)", 8 ,lru.numCollisions(4,"837y873681927368"));
		assertEquals2("lru(4,abababab)", 0 ,lru.numCollisions(4,"abababab"));
		assertEquals2("lru(4,abcdcefdbcda)", 5 ,lru.numCollisions(4,"abcdcefdbcda"));
		assertEquals2("lru(5,abcdefecbab)", 2 ,lru.numCollisions(5,"abcdefecbab"));
		assertEquals2("lru(5,723a1w31w21q)", 2 ,lru.numCollisions(5,"723a1w31w21q"));
		assertEquals2("lru(5,837y873681927368)", 7 ,lru.numCollisions(5,"837y873681927368"));
		assertEquals2("lru(5,abababab)", 0 ,lru.numCollisions(5,"abababab"));
		assertEquals2("lru(5,abcdcefdbcda)", 2 ,lru.numCollisions(5,"abcdcefdbcda"));
	}
	
	@Test
	public void testLFU(){
		assertEquals2("lfu(10,abcdefghijklabab)", 4 ,lfu.numCollisions(10,"abcdefghijklabab"));
		assertEquals2("lfu(100,abcdefecbab)", 0 ,lfu.numCollisions(100,"abcdefecbab"));
		assertEquals2("lfu(3,abcdefecbab)", 6 ,lfu.numCollisions(3,"abcdefecbab"));
		assertEquals2("lfu(3,723a1w31w21qw)", 6 ,lfu.numCollisions(3,"723a1w31w21qw"));
		assertEquals2("lfu(3,837y873681927368)", 11 ,lfu.numCollisions(3,"837y873681927368"));
		assertEquals2("lfu(3,abababab)", 0 ,lfu.numCollisions(3,"abababab"));
		assertEquals2("lfu(3,abcdcefdbcda)", 6 ,lfu.numCollisions(3,"abcdcefdbcda"));
		assertEquals2("lfu(4,abcdefecbab)", 4 ,lfu.numCollisions(4,"abcdefecbab"));
		assertEquals2("lfu(4,723a1w31w21q)", 4 ,lfu.numCollisions(4,"723a1w31w21q"));
		assertEquals2("lfu(4,837y873681927368)", 5 ,lfu.numCollisions(4,"837y873681927368"));
		assertEquals2("lfu(4,abababab)", 0 ,lfu.numCollisions(4,"abababab"));
		assertEquals2("lfu(4,abcdcefdbcda)", 4 ,lfu.numCollisions(4,"abcdcefdbcda"));
		assertEquals2("lfu(5,abcdefecbab)", 2 ,lfu.numCollisions(5,"abcdefecbab"));
		assertEquals2("lfu(5,723a1w31w21q)", 2 ,lfu.numCollisions(5,"723a1w31w21q"));
		assertEquals2("lfu(5,837y873681927368)", 4 ,lfu.numCollisions(5,"837y873681927368"));
		assertEquals2("lfu(5,abababab)", 0 ,lfu.numCollisions(5,"abababab"));
		assertEquals2("lfu(5,abcdcefdbcda)", 2 ,lfu.numCollisions(5,"abcdcefdbcda"));
	}
	
	@Test
	public void testFIF(){
		assertEquals2("fif(100,abcdefecbab)", 0 ,fif.numCollisions(100,"abcdefecbab"));
		assertEquals2("fif(3,abcdefecbab)", 5 ,fif.numCollisions(3,"abcdefecbab"));
		assertEquals2("fif(3,723a1w31w21q)", 5 ,fif.numCollisions(3,"723a1w31w21q"));
		assertEquals2("fif(3,837y873681927368)", 8 ,fif.numCollisions(3,"837y873681927368"));
		assertEquals2("fif(3,abababab)", 0 ,fif.numCollisions(3,"abababab"));
		assertEquals2("fif(3,abcdcefdbcda)", 5 ,fif.numCollisions(3,"abcdcefdbcda"));
		assertEquals2("fif(4,abcdefecbab)", 3 ,fif.numCollisions(4,"abcdefecbab"));
		assertEquals2("fif(4,723a1w31w21q)", 3 ,fif.numCollisions(4,"723a1w31w21q"));
		assertEquals2("fif(4,837y873681927368)", 5 ,fif.numCollisions(4,"837y873681927368"));
		assertEquals2("fif(4,abababab)", 0 ,fif.numCollisions(4,"abababab"));
		assertEquals2("fif(4,abcdcefdbcda)", 3 ,fif.numCollisions(4,"abcdcefdbcda"));
		assertEquals2("fif(5,abcdefecbab)", 1 ,fif.numCollisions(5,"abcdefecbab"));
		assertEquals2("fif(5,723a1w31w21q)", 2 ,fif.numCollisions(5,"723a1w31w21q"));
		assertEquals2("fif(5,837y873681927368)", 3 ,fif.numCollisions(5,"837y873681927368"));
		assertEquals2("fif(5,abababab)", 0 ,fif.numCollisions(5,"abababab"));
		assertEquals2("fif(5,abcdcefdbcda)", 1 ,fif.numCollisions(5,"abcdcefdbcda"));
		
	}
	
	@Test
	public void testLIFO() {
		assertEquals2("lifo(10,abcdefghijklabab)", 2 ,lifo.numCollisions(10,"abcdefghijklabab"));
		assertEquals2("lifo(100,abcdefecbab)", 0 ,lifo.numCollisions(100,"abcdefecbab"));
		assertEquals2("lifo(3,abcdefecbab)", 5 ,lifo.numCollisions(3,"abcdefecbab"));
		assertEquals2("lifo(3,723a1w311w21q)", 8 ,lifo.numCollisions(3,"723a1w311w21q"));
		assertEquals2("lifo(3,837y873681927368)", 8 ,lifo.numCollisions(3,"837y873681927368"));
		assertEquals2("lifo(3,abababab)", 0 ,lifo.numCollisions(3,"abababab"));
		assertEquals2("lifo(3,abcdcefdbcda)", 7 ,lifo.numCollisions(3,"abcdcefdbcda"));
		assertEquals2("lifo(4,abcdefecbab)", 3 ,lifo.numCollisions(4,"abcdefecbab"));
		assertEquals2("lifo(4,723a1w31w21q)", 6 ,lifo.numCollisions(4,"723a1w31w21q"));
		assertEquals2("lifo(4,837y873681927368)", 5 ,lifo.numCollisions(4,"837y873681927368"));
		assertEquals2("lifo(4,abababab)", 0 ,lifo.numCollisions(4,"abababab"));
		assertEquals2("lifo(4,abcdcefdbcda)", 3 ,lifo.numCollisions(4,"abcdcefdbcda"));
		assertEquals2("lifo(5,abcdefecbab)", 2 ,lifo.numCollisions(5,"abcdefecbab"));
		assertEquals2("lifo(5,723a1w31w21q)", 5 ,lifo.numCollisions(5,"723a1w31w21q"));
		assertEquals2("lifo(5,837y873681927368)", 4 ,lifo.numCollisions(5,"837y873681927368"));
		assertEquals2("lifo(5,abababab)", 0 ,lifo.numCollisions(5,"abababab"));
		assertEquals2("lifo(5,abcdcefdbcda)", 1 ,lifo.numCollisions(5,"abcdcefdbcda"));
	}
}
