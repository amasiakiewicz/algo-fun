package test.cache;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private final int maxSize;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(final Map.Entry eldest) {
                return this.size() > maxSize;
            }
        };
    }

    public synchronized int get(int key) {
        Integer v = cache.get(key);
        return v == null ? -1 : v;
    }

    public synchronized void put(int key, int value) {
        cache.put(key, value);
    }

}