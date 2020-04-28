package array.minimumswap;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] arr, int expectedMinimumSwaps) {
        //given

        //when
        final int minimumSwaps = Solution.minimumSwaps(arr);

        //then
        assertThat(minimumSwaps).isEqualTo(expectedMinimumSwaps);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 1, 3, 5, 2, 4, 6, 7 }, 3,
                },
                new Object[] {
                        new int[] { 4, 3, 1, 2 }, 3,
                },
                new Object[] {
                        new int[] { 2, 3, 4, 1, 5 }, 3,
                },
                new Object[] {
                        new int[] { 7, 1, 3, 2, 4, 5, 6 }, 5,
                },
                new Object[] {
                        new int[] { 1 }, 0,
                },
                new Object[] {
                        new int[] { 1, 2, 3 }, 0,
                },
        };
    }

}
