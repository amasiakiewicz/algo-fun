package search.pair;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int k, final int[] arr, final int expectedPairs) {
        //given

        //when
        final int pairs = Solution.pairs(k, arr);

        //then
        assertThat(pairs).isEqualTo(expectedPairs);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        2,
                        new int[] { 1, 5, 3, 4, 2  },
                        3
                },
                new Object[] {
                        4,
                        new int[] { 1, 5  },
                        1
                },
        };
    }

}
