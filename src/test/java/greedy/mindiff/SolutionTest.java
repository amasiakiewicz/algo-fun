package greedy.mindiff;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] arr, int expectedMinDiff) {
        //given

        //when
        final int minDiff = Solution.minimumAbsoluteDifference(arr);

        //then
        assertThat(minDiff).isEqualTo(expectedMinDiff);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 3, -7, 0 },
                        3
                },
                new Object[] {
                        new int[] { -59, -36, -13, 1, -53, -92, -2, -96, -54, 75 },
                        1
                },
                new Object[] {
                        new int[] { 1, -3, 71, 68, 17 },
                        3
                },
                new Object[] {
                        new int[] { 1, -3, },
                        4
                },
                new Object[] {
                        new int[] { 1, -3, -1 },
                        2
                },
        };
    }

}
