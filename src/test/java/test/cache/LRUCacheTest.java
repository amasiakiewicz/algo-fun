package test.cache;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void shouldResult() {
        //given
        final LRUCache lruCache = new LRUCache(2);

        //when
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        //then
        assertThat(lruCache.get(1)).isEqualTo(1);

        //when
        lruCache.put(3, 3);

        //then
        assertThat(lruCache.get(2)).isEqualTo(-1);

        //when
        lruCache.put(4, 4);

        //then
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertThat(lruCache.get(3)).isEqualTo(3);
        assertThat(lruCache.get(4)).isEqualTo(4);
    }

}