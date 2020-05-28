package greedy.maxmin;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int k, int[] arr, int expectedMaxMin) {
        //given

        //when
        final int maxMin = Solution.maxMin(k, arr);

        //then
        assertThat(maxMin).isEqualTo(expectedMaxMin);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 3, -7, 0 },
                        3
                },
        };
    }

}
