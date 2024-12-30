
/**
 * CacheScheme.java
 * 
 * @author Shannon Duvall
 * 
 * This class provides the abstract superclass for all cache schemes
 * 
 * Each Cache Scheme implementation class should provide a "numCollisions" calculator method
 */

public abstract class CacheScheme {
	/**
	 * @param cacheSize - the number of slots alloted for the cache.
	 * 
	 * @param word - a string giving the data requests to the cache, in order.
	 * 
	 * @return integer giving the number of collisions that occurred in processing the given data requests with the given cache size.
	 */
	public abstract int numCollisions(int cacheSize, String word);
}
