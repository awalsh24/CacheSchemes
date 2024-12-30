import java.util.Map;
import java.util.HashMap;

/**
 * @author Aidan Walsh
 * LRU.java
 * 
 * This class implements a least-recently-used cache scheme
 * 
 */
public class LRU extends CacheScheme {

	
	@Override
    public int numCollisions(int cacheSize, String dataStream) {
        DataLinkedList cache = new DataLinkedList();
        Map<Character, Data> cacheMap = new HashMap<>();
        int collisions = 0;

        for (int i = 0; i < dataStream.length(); i++) {
            char currentChar = dataStream.charAt(i);
            Data currentData = cacheMap.get(currentChar);

            if (currentData != null) {
                // Cache hit 
                cache.remove(currentData);
                cache.addToEnd(currentData);
            } else {
                // Cache miss
                if (cacheMap.size() == cacheSize) {
                    // full
                    Data leastUsedData = cache.removeFirst();
                    cacheMap.remove(leastUsedData.getData());
                    collisions++;
                }

                // add data 
                Data newData = new Data(currentChar);
                cache.addToEnd(newData);
                cacheMap.put(currentChar, newData);
            }
        }

        return collisions;
    }
			
}

