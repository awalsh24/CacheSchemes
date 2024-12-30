import java.util.HashMap;
import java.util.Map;

/**
 * @author Aidan Walsh
 * 
 * FIFO.java
 * 
 * This class implements a first-in, first-out cache scheme.
 * 
 */
//

public class FIFO extends CacheScheme {

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
                    Data oldestData = cache.removeFirst();
                    cacheMap.remove(oldestData.getData());
                    collisions++;
                }

                
                Data newData = new Data(currentChar);
                cache.addToEnd(newData);  
                cacheMap.put(currentChar, newData);
            }
        }

        return collisions;
    }
}

