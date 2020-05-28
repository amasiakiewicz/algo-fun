package greedy.florist;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(final int k, final int[] c, int expectedMinimumCost) {
        //given

        //when
        final int minimumCost = Solution.getMinimumCost(k, c);

        //then
        assertThat(minimumCost).isEqualTo(expectedMinimumCost);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        3,
                        new int[] { 2, 5, 6 },
                        13
                },
                new Object[] {
                        2,
                        new int[] { 2, 5, 6 },
                        15
                },
                new Object[] {
                        3,
                        new int[] { 1, 3, 5, 7, 9 },
                        29
                },               
                new Object[] {
                        3,
                        new int[] { 1, 3, 9, 7, 5 },
                        29
                },                
                new Object[] {
                        4,
                        new int[] { 1 },
                        1
                },
                new Object[] {
                        1,
                        new int[] { 1 },
                        1
                },
        };
    }

}
