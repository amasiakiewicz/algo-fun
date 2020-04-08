package array.leftrotation;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] a, int d, int[] expectedRotLeft) {
        //given

        //when
        final int[] rotLeft = Solution.rotLeft(a, d);

        //then
        assertThat(rotLeft).isEqualTo(expectedRotLeft);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 1, 2, 3, 4, 5 }, 4, new int[] { 5, 1, 2, 3, 4 },
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 5 }, 1, new int[] { 2, 3, 4, 5, 1 },
                },
                new Object[] {
                        new int[] { 1, 2, 3, 4, 5 }, 5, new int[] { 1, 2, 3, 4, 5 },
                },
                new Object[] {
                        new int[] { 1 }, 1, new int[] { 1 },
                },
                new Object[] {
                        new int[] { 1, 2 }, 1, new int[] { 2, 1 },
                },
                new Object[] {
                        new int[] { 1, 2, 3 }, 1, new int[] { 2, 3, 1 },
                },
                new Object[] {
                        new int[] { 1, 2, 3 }, 2, new int[] { 3, 1, 2 },
                },
        };
    }

}
