package stackandqueue.minmaxriddle;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final long[] arr, final long[] expectedRiddle) {
        //given

        //when
        final long[] riddle = Solution.riddle(arr);

        //then
        assertThat(riddle).isEqualTo(expectedRiddle);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new long[] { 6, 3, 5, 1, 12 },
                        new long[] { 12, 3, 3, 1, 1 },
                },
                new Object[] {
                        new long[] { 2, 6, 1, 12, },
                        new long[] { 12, 2, 1, 1, },
                },
                new Object[] {
                        new long[] { 1, 2, 3, 5, 1, 13, 3, },
                        new long[] { 13, 3, 2, 1, 1, 1, 1, },
                },
                new Object[] {
                        new long[] { 3, 5, 4, 7, 6, 2, },
                        new long[] { 7, 6, 4, 4, 3, 2, },
                },
        };
    }

}
