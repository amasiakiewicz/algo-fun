package test.cache;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LRUCacheCustomTest {

    @Test
    public void shouldResult() {
        //given
        final LRUCacheCustom lruCacheCustom = new LRUCacheCustom(2);

        //when
        lruCacheCustom.put(1, 1);
        lruCacheCustom.put(2, 2);

        //then
        assertThat(lruCacheCustom.get(1)).isEqualTo(1);

        //when
        lruCacheCustom.put(3, 3);

        //then
        assertThat(lruCacheCustom.get(2)).isEqualTo(-1);

        //when
        lruCacheCustom.put(4, 4);

        //then
        assertThat(lruCacheCustom.get(1)).isEqualTo(-1);
        assertThat(lruCacheCustom.get(3)).isEqualTo(3);
        assertThat(lruCacheCustom.get(4)).isEqualTo(4);
    }

}