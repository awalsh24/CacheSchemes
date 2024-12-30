/**
 * @author Aidan Walsh
 * 
 * FIF.java
 * 
 * 
 * This class implements the Cache Scheme Furthest in Future
 * 
 * It is not a realistic cache scheme but rather an optimal scheme
 * for benchmarking.  It "cheats" by looking into the future!
 * 
 * You do NOT have to use the Data class for this, nor do you have to worry about 
 * run time.
 */


import java.util.HashMap;
import java.util.Map;


public class FIF extends CacheScheme {

    @Override
    public int numCollisions(int cacheSize, String dataStream) {
        
        DataLinkedList cache = new DataLinkedList();
        Map<Character, Data> cacheMap = new HashMap<>();
        int collisions = 0;

        for (int i = 0; i < dataStream.length(); i++) {
            char currentChar = dataStream.charAt(i);
            Data currentData = new Data(currentChar);

            if (cacheMap.containsKey(currentChar)) {
                // Cache hit 
            } else {
                // Cache miss
                if (cacheMap.size() == cacheSize) {
                    // Cache is full
                    int farthestIndex = -1;
                    Data farthestData = null;

                    for (Data data : cacheMap.values()) {
                        int indexInFuture = dataStream.substring(i + 1).indexOf(data.getData());
                        if (indexInFuture > farthestIndex) {
                            farthestIndex = indexInFuture;
                            farthestData = data;
                        } else if (indexInFuture == -1) { 
                            farthestData = data;
                            break;
                        }
                    }

                    cache.remove(farthestData);
                    cacheMap.remove(farthestData.getData());
                    collisions++;
                }

                
                cache.addToEnd(currentData);
                cacheMap.put(currentChar, currentData);
            }
        }

        return collisions;
    }
}
