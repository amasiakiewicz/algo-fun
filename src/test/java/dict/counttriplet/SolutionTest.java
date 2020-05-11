package dict.counttriplet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(List<Long> arr, long r, long expectedCountTriplets) {
        //given

        //when
        final long countTriplets = Solution.countTriplets(arr, r);

        //then
        assertThat(countTriplets).isEqualTo(expectedCountTriplets);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        Arrays.asList(1L, 3L, 9L, 10L),
                        3L,
                        1L
                },
                new Object[] {
                        Arrays.asList(1L, 2L, 2L, 4L),
                        2L,
                        2L
                },
                new Object[] {
                        Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L),
                        3L,
                        6L
                },
                new Object[] {
                        Arrays.asList(1L, 5L, 5L, 25L, 125L),
                        5,
                        4
                },
                new Object[] {
                        Collections.singletonList(1L),
                        2L,
                        0L
                },
                new Object[] {
                        Arrays.asList(1L, 2L),
                        2L,
                        0L
                },
                new Object[] {
                        Arrays.asList(1L, 2L, 3L),
                        2L,
                        0L
                },
                new Object[] {
                        Arrays.asList(1L, 1L, 1L),
                        1L,
                        1L
                },
                new Object[] {
                        Arrays.asList(1L, 1L, 1L, 1L),
                        1L,
                        4L
                },
                new Object[] {
                        Arrays.asList(1L, 5L, 5L, 25L, 25L),
                        5L,
                        4L
                },
                new Object[] {
                        Arrays.asList(1L, 2L, 4L, 6L),
                        2L,
                        1L
                },
                new Object[] {
                        Arrays.asList(1L, 1L, 2L, 2L, 4L, 4L, 6L),
                        2L,
                        8L
                },
                new Object[] {
                        Arrays.asList(1L, 1L, 1L, 2L, 2L, 2L, 6L),
                        1L,
                        2L
                },
        };
    }

}
