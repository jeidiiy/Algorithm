package programmers;

import java.util.Map;
import java.util.LinkedHashMap;

public class 캐시 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            LRUCache<String, Object> cache = new LRUCache<>(cacheSize);

            for (String city : cities) {
                cache.put(city.toLowerCase(), null);
            }

            return cache.getRuntime();
        }

        static class LRUCache<K, V> {
            private int capacity;
            private int runtime;
            private LinkedHashMap<K, V> cache;

            public LRUCache(int capacity) {
                this.capacity = capacity;
                this.runtime = 0;
                this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                        return size() > capacity;
                    }
                };
            }

            public int getRuntime() {
                return runtime;
            }

            public void put(K key, V value) {
                runtime += cache.containsKey(key) ? 1 : 5;
                cache.put(key, value);
            }
        }
    }
}
