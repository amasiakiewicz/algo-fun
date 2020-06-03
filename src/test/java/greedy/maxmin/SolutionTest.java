package greedy.maxmin;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

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
                        3,
                        new int[] { 10, 100, 300, 200, 1000, 20, 30 },
                        20
                },
                new Object[] {
                        4,
                        new int[] { 1, 2, 3, 4, 10, 20, 30, 40, 100, 200 },
                        3
                },
                new Object[] {
                        2,
                        new int[] { 1, 2, 1, 2, 1 },
                        0
                },
                new Object[] {
                        2,
                        new int[] { 1, 1 },
                        0
                },
                new Object[] {
                        2,
                        new int[] { 1, 4 },
                        3
                },
                new Object[] {
                        4,
                        new int[] { 1, 4, 5, 100 },
                        99
                },
                new Object[] {
                        2,
                        new int[] { 1, 4, 5, 100 },
                        1
                },
        };
    }

}
