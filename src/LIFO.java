
import java.util.Map;
import java.util.HashMap;


/**
 * @author Aidan Walsh
 * LIFO.java
 * 
 * This class implements a last-in, first-out cache scheme
 * 
 */

public class LIFO extends CacheScheme {
	@Override
    public int numCollisions(int cacheSize, String dataStream) {

        DataLinkedList cache = new DataLinkedList();
        Map<Character, Data> cacheMap = new HashMap<>();
        int collisions = 0;

        for (int i = 0; i < dataStream.length(); i++) {
            char currentChar = dataStream.charAt(i);

            if (!cacheMap.containsKey(currentChar)) {
                // Cache miss
                if (cacheMap.size() == cacheSize) {
                    // full
                    Data lastData = cache.removeLast();
                    cacheMap.remove(lastData.getData());
                    collisions++;
                }

                // Add the data
                Data newData = new Data(currentChar);
                cache.addToEnd(newData);  
                cacheMap.put(currentChar, newData);
            }
        }

        return collisions;
    }
}