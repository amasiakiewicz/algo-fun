package stackandqueue.largestrectangle;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int[] h, final long expectedLargestRectangle) {
        //given

        //when
        final long largestRectangle = Solution.largestRectangle(h);

        //then
        assertThat(largestRectangle).isEqualTo(expectedLargestRectangle);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 1, 2, 5, 4, 3 },
                        9L,
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 5 },
                        9L,
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 5, 1, 1, 1, 9, 9 },
                        18L,
                },
                new Object[] {
                        new int[] { 1, 3, 6, 8, 7, 2, 4, 1 },
                        18L,
                },
        };
    }

}
