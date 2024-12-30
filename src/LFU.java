import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Aidan Walsh
 * 
 * LFU.java
 * 
 * This class implements a least-frequently-used cache scheme
 * 
 */

public class LFU extends CacheScheme {

    @Override
    public int numCollisions(int cacheSize, String dataStream) {

       
        PriorityQueue<Data> frequencyQueue = new PriorityQueue<>((data1, data2) -> {
            
            int frequencyCompare = Integer.compare(data1.getFrequency(), data2.getFrequency());
            return frequencyCompare != 0 ? frequencyCompare : Integer.compare(data1.getTime(), data2.getTime());
        });

        Map<Character, Data> cacheMap = new HashMap<>();
        int collisions = 0;
        int time = 0;

        for (int i = 0; i < dataStream.length(); i++, time++) {
            char currentChar = dataStream.charAt(i);
            Data currentData;

            if (cacheMap.containsKey(currentChar)) {
                // Cache hit 
                currentData = cacheMap.get(currentChar);
                frequencyQueue.remove(currentData);
                currentData.addFrequency();
                currentData.setTime(time);
            } else {
                // Cache miss
                currentData = new Data(currentChar, time);
                currentData.addFrequency();

                if (cacheMap.size() == cacheSize) {
                    // Cache is full 
                    Data leastUsedData = frequencyQueue.poll();
                    cacheMap.remove(leastUsedData.getData());
                    collisions++;
                }

                cacheMap.put(currentChar, currentData);
            }

            frequencyQueue.add(currentData);
        }

        return collisions;
    }
}
