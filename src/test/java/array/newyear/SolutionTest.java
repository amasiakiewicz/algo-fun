package array.newyear;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

    @Test
    @Parameters(method = "resultParams")
    public void shouldResult(int[] q, String expectedMinimumBribesStr) {
        //given

        //when
        final String minimumBribesStr = Solution.minimumBribesStr(q);

        //then
        assertThat(minimumBribesStr).isEqualTo(expectedMinimumBribesStr);
    }

    private Object resultParams() {
        return new Object[] {
                new Object[] {
                        new int[] { 2, 1, 5, 3, 4 }, "3",
                },
                new Object[] {
                        new int[] { 2, 5, 1, 3, 4 }, "Too chaotic",
                },
                new Object[] {
                        new int[] { 1 }, "0",
                },
                new Object[] {
                        new int[] { 1, 2 }, "0",
                },
                new Object[] {
                        new int[] { 2, 1 }, "1",
                },
                new Object[] {
                        new int[] { 3, 1, 2 }, "2",
                },
                new Object[] {
                        new int[] { 3, 2, 1 }, "3",
                },
                new Object[] {
                        new int[] { 1, 2, 5, 4, 3 }, "3",
                },
                new Object[] {
                        new int[] { 1, 2, 5, 3, 7, 8, 6, 4 }, "7",
                },
        };
    }

}
