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
                        new int[] {1, 2, 3, 4, 5},
                        9L,
                },
        };
    }

}
