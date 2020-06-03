package search.swap;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int[][] indexes, final int[] queries, final int[][] expectedSwapNodes) {
        //given

        //when
        final int[][] swapNodes = Solution.swapNodes(indexes, queries);

        //then
        assertThat(swapNodes).isEqualTo(expectedSwapNodes);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 1, 2, 3 },
                        "Array is sorted in 0 swaps.\n" +
                                "First Element: 1\n" +
                                "Last Element: 3"
                },
        };
    }

}
